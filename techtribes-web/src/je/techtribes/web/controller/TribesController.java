package je.techtribes.web.controller;

import je.techtribes.component.activity.ActivityComponent;
import je.techtribes.component.badge.BadgeComponent;
import je.techtribes.component.event.EventComponent;
import je.techtribes.component.github.GitHubComponent;
import je.techtribes.component.job.JobComponent;
import je.techtribes.component.newsfeedentry.NewsFeedEntryComponent;
import je.techtribes.component.newsfeedentry.NewsFeedEntryException;
import je.techtribes.component.talk.TalkComponent;
import je.techtribes.component.tweet.TweetComponent;
import je.techtribes.component.tweet.TweetException;
import je.techtribes.domain.*;
import je.techtribes.domain.badge.AwardedBadge;
import je.techtribes.util.PageSize;
import je.techtribes.util.comparator.AwardedBadgeComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class TribesController extends AbstractController {

    private static Log log = LogFactory.getLog(TribesController.class);

    private BadgeComponent badgeComponent;
    private NewsFeedEntryComponent newsFeedEntryComponent;
    private TweetComponent tweetComponent;
    private TalkComponent talkComponent;
    private ActivityComponent activityComponent;
    private JobComponent jobService;
    private EventComponent eventService;
    private GitHubComponent gitHubComponent;

    @Autowired
    public TribesController(BadgeComponent badgeComponent, NewsFeedEntryComponent newsFeedEntryComponent, TweetComponent tweetComponent, TalkComponent talkComponent, ActivityComponent activityComponent, JobComponent jobService, EventComponent eventService, GitHubComponent gitHubComponent) {
        this.badgeComponent = badgeComponent;
        this.newsFeedEntryComponent = newsFeedEntryComponent;
        this.tweetComponent = tweetComponent;
        this.talkComponent = talkComponent;
        this.activityComponent = activityComponent;
        this.jobService = jobService;
        this.eventService = eventService;
        this.gitHubComponent = gitHubComponent;
    }

    @RequestMapping(value = "/tech", method = RequestMethod.GET)
	public String viewTechTribes(ModelMap model) {
        return viewTribesByType(model, ContentSourceType.Tech, "tribes-tech", "Tech tribes");
	}

    @RequestMapping(value = "/community", method = RequestMethod.GET)
	public String viewSocialTribes(ModelMap model) {
        return viewTribesByType(model, ContentSourceType.Community, "tribes-community", "Community tribes");
	}

    @RequestMapping(value = "/business", method = RequestMethod.GET)
	public String viewBusinessTribes(ModelMap model) {
        return viewTribesByType(model, ContentSourceType.Business, "tribes-business", "Business tribes");
	}

    @RequestMapping(value = "/media", method = RequestMethod.GET)
	public String viewMediaTribes(ModelMap model) {
        return viewTribesByType(model, ContentSourceType.Media, "tribes-media", "Media tribes");
	}

    @RequestMapping(value = "/tribes", method = RequestMethod.GET)
	public String viewTribes(ModelMap model) {
        List<Tribe> tribes = contentSourceComponent.getTribes();

        model.addAttribute("tribes", tribes);
        addCommonAttributes(model);
        setPageTitle(model, "Tribes");

        return "tribes";
	}

	public String viewTribesByType(ModelMap model, ContentSourceType type, String view, String title) {
        List<ContentSource> tribes = contentSourceComponent.getContentSources(type);

        model.addAttribute("tribes", tribes);
        addCommonAttributes(model);
        setPageTitle(model, title);

        return view;
	}

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}", method = RequestMethod.GET)
	public String viewTribe(@PathVariable("name")String shortName, ModelMap model) {
        ContentSource contentSource = contentSourceComponent.findByShortName(shortName);
        if (contentSource.isPerson()) {
            log.error(shortName + " is not a tribe");
            return "404";
        }
        Tribe tribe = (Tribe)contentSource;

        // redirect to the jobs page for tribes where we're not aggregating content
        if (!tribe.isContentAggregated()) {
            return "redirect:/tribes/" + tribe.getShortName() + "/jobs";
        }

        List<NewsFeedEntry> newsFeedEntries;
        List<Tweet> tweets;
        if (tribe.getType() == ContentSourceType.Tech) {
            Collection<ContentSource> contentSources = createListOfShortNamesForTribeMembers(tribe);
            newsFeedEntries = newsFeedEntryComponent.getRecentNewsFeedEntries(contentSources, 1, PageSize.RECENT_NEWS_FEED_ENTRIES);
            tweets = tweetComponent.getRecentTweets(contentSources, 1, PageSize.RECENT_TWEETS);
        } else {
            newsFeedEntries = newsFeedEntryComponent.getRecentNewsFeedEntries(contentSource, PageSize.RECENT_NEWS_FEED_ENTRIES);
            tweets = tweetComponent.getRecentTweets(tribe, PageSize.RECENT_TWEETS);
        }

        List<Job> jobs = jobService.getRecentJobs(contentSource, PageSize.RECENT_JOBS, false);

        Activity activity = activityComponent.getActivity(contentSource);
        List<AwardedBadge> badges = badgeComponent.getAwardedBadges(contentSource);
        Collections.sort(badges, new AwardedBadgeComparator());

        model.addAttribute("tribe", contentSource);
        model.addAttribute("badges", badges);
        model.addAttribute("newsFeedEntries", newsFeedEntries);
        model.addAttribute("tweets", tweets);
        model.addAttribute("jobs", jobs);
        model.addAttribute("activeNav", "summary");
        model.addAttribute("activity", activity);
        addCommonAttributes(model);
        setPageTitle(model, contentSource.getName());

        return "tribe";
	}

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/tweets", method = RequestMethod.GET)
	public String viewTribeTweets(@PathVariable("name")String shortName, ModelMap model) {
        return viewTribeTweets(shortName, 1, model);
    }

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/tweets/{page:[\\d]+}", method = RequestMethod.GET)
	public String viewTribeTweets(@PathVariable("name")String shortName, @PathVariable("page")int page, ModelMap model) {
        ContentSource contentSource = contentSourceComponent.findByShortName(shortName);
        if (contentSource.isPerson()) {
            log.error(shortName + " is not a tribe");
            return "404";
        }
        Tribe tribe = (Tribe)contentSource;
        Collection<ContentSource> contentSources = createListOfShortNamesForTribeAndMembers(tribe);

        List<Tweet> tweets = new LinkedList<>();
        long numberOfTweets = tweetComponent.getNumberOfTweets(contentSources);
        int maxPage = PageSize.calculateNumberOfPages(numberOfTweets, PageSize.RECENT_TWEETS);
        page = PageSize.validatePage(page, maxPage);

        if (numberOfTweets > 0) {
            try {
                tweets = tweetComponent.getRecentTweets(contentSources, page, PageSize.RECENT_TWEETS);
            } catch (TweetException tse) {
                log.warn("Couldn't retrieve tweets for " + shortName, tse);
            }
        }

        model.addAttribute("tribe", tribe);
        model.addAttribute("tweets", tweets);
        model.addAttribute("currentPage", page);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("activeNav", "tweets");
        model.addAttribute("contentSourceStatistics", new ContentSourceStatistics(tweets).getStatistics());
        addCommonAttributes(model);
        setPageTitle(model, tribe.getName(), "Tweets", "" + page);

        return "tribe-tweets";
	}

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/content", method = RequestMethod.GET)
	public String viewTribeContent(@PathVariable("name")String shortName, ModelMap model) {
        return viewTribeContent(shortName, 1, model);
    }

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/content/{page:[\\d]+}", method = RequestMethod.GET)
	public String viewTribeContent(@PathVariable("name")String shortName, @PathVariable("page")int page, ModelMap model) {
        ContentSource contentSource = contentSourceComponent.findByShortName(shortName);
        if (contentSource.isPerson()) {
            log.error(shortName + " is not a tribe");
            return "404";
        }
        Tribe tribe = (Tribe)contentSource;

        Collection<ContentSource> contentSources = createListOfShortNamesForTribeAndMembers(tribe);

        List<NewsFeedEntry> newsFeedEntries = new LinkedList<>();
        long numberOfNewsFeedEntries = newsFeedEntryComponent.getNumberOfNewsFeedEntries(contentSources);
        int maxPage = PageSize.calculateNumberOfPages(numberOfNewsFeedEntries, PageSize.RECENT_NEWS_FEED_ENTRIES);
        page = PageSize.validatePage(page, maxPage);

        if (numberOfNewsFeedEntries > 0) {
            try {
                newsFeedEntries = newsFeedEntryComponent.getRecentNewsFeedEntries(contentSources, page, PageSize.RECENT_NEWS_FEED_ENTRIES);
            } catch (NewsFeedEntryException nfse) {
                log.warn("Couldn't retrieve content for " + shortName, nfse);
            }
        }

        model.addAttribute("tribe", contentSource);
        model.addAttribute("newsFeedEntries", newsFeedEntries);
        model.addAttribute("currentPage", page);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("activeNav", "content");
        model.addAttribute("contentSourceStatistics", new ContentSourceStatistics(newsFeedEntries).getStatistics());
        addCommonAttributes(model);
        setPageTitle(model, contentSource.getName(), "Content", "" + page);

        return "tribe-content";
	}

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/talks", method = RequestMethod.GET)
	public String viewTribeTalks(@PathVariable("name")String shortName, ModelMap model) {
        ContentSource contentSource = contentSourceComponent.findByShortName(shortName);
        if (contentSource.isPerson()) {
            log.error(shortName + " is not a tribe");
            return "404";
        }
        Tribe tribe = (Tribe)contentSource;

        List<Talk> talks = talkComponent.getTalks(createListOfMembers(tribe));

        Set<String> countries = new TreeSet<>();
        for (Talk talk : talks) {
            countries.add(talk.getCountry());
        }

        model.addAttribute("tribe", contentSource);
        model.addAttribute("talks", talks);
        model.addAttribute("countries", countries);
        model.addAttribute("numberOfCountries", countries.size());
        model.addAttribute("activeNav", "talks");
        model.addAttribute("contentSourceStatistics", new ContentSourceStatistics(talks).getStatistics());
        addCommonAttributes(model);
        setPageTitle(model, contentSource.getName(), "Talks");

        return "tribe-talks";
	}

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/jobs", method = RequestMethod.GET)
	public String viewTribeJobs(@PathVariable("name")String shortName, ModelMap model) {
        ContentSource contentSource = contentSourceComponent.findByShortName(shortName);

        List<Job> jobs = jobService.getRecentJobs(contentSource, 12, false);

        model.addAttribute("tribe", contentSource);
        model.addAttribute("jobs", jobs);
        model.addAttribute("activeNav", "jobs");
        addCommonAttributes(model);
        setPageTitle(model, contentSource.getName(), "Jobs");

        return "tribe-jobs";
	}

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/events", method = RequestMethod.GET)
	public String viewTribeEvents(@PathVariable("name")String shortName, ModelMap model) {
        ContentSource contentSource = contentSourceComponent.findByShortName(shortName);

        List<Event> events = eventService.getEvents(contentSource, 12);

        model.addAttribute("tribe", contentSource);
        model.addAttribute("events", events);
        model.addAttribute("activeNav", "events");
        addCommonAttributes(model);
        setPageTitle(model, contentSource.getName(), "Events");

        return "tribe-events";
	}

    @RequestMapping(value="/tribes/{name:^[a-z-0-9]*$}/code", method = RequestMethod.GET)
	public String viewCodeByTribe(@PathVariable("name")String shortName, ModelMap model) {
        ContentSource contentSource = contentSourceComponent.findByShortName(shortName);

        model.addAttribute("tribe", contentSource);
        model.addAttribute("activeNav", "code");
        if (contentSource.hasGitHubId()) {
            model.addAttribute("gitHubRepositories", gitHubComponent.getRepositories(contentSource));
        }
        addCommonAttributes(model);
        setPageTitle(model, contentSource.getName(), "Code");

        return "tribe-code";
	}

    private Collection<ContentSource> createListOfShortNamesForTribeAndMembers(Tribe tribe) {
        List<ContentSource> shortNames = new LinkedList<>();
        shortNames.add(tribe);
        shortNames.addAll(createListOfShortNamesForTribeMembers(tribe));

        return shortNames;
    }

    private Collection<ContentSource> createListOfShortNamesForTribeMembers(Tribe tribe) {
        if (tribe.getType() != ContentSourceType.Community) {
            List<ContentSource> list = new LinkedList<>();
            list.addAll(tribe.getMembers());
            return list;
        }

        return new LinkedList<>();
    }

    private Collection<ContentSource> createListOfMembers(Tribe tribe) {
        Collection<ContentSource> members = new LinkedList<>();
        if (tribe.getType() != ContentSourceType.Community) {
            for (Person person : tribe.getMembers()) {
                members.add(person);
            }
        }

        return members;
    }

}
