package je.techtribes.web.controller;

import je.techtribes.component.activity.ActivityComponent;
import je.techtribes.domain.*;
import je.techtribes.domain.badge.Badge;
import je.techtribes.domain.badge.Badges;
import je.techtribes.component.newsfeedentry.NewsFeedEntryComponent;
import je.techtribes.component.event.EventComponent;
import je.techtribes.component.job.JobComponent;
import je.techtribes.component.tweet.TweetComponent;
import je.techtribes.component.talk.TalkComponent;
import je.techtribes.domain.Tweet;
import je.techtribes.util.PageSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class RecentSummaryPageController extends AbstractController {

    private NewsFeedEntryComponent newsFeedEntryComponent;
    private TweetComponent twitterService;
    private TalkComponent talksService;
    private JobComponent jobService;
    private EventComponent eventService;
    private ActivityComponent activityComponent;

    @Autowired
    public RecentSummaryPageController(NewsFeedEntryComponent newsFeedEntryComponent, TweetComponent twitterService, TalkComponent talksService, JobComponent jobService, EventComponent eventService, ActivityComponent activityComponent) {
        this.newsFeedEntryComponent = newsFeedEntryComponent;
        this.twitterService = twitterService;
        this.talksService = talksService;
        this.jobService = jobService;
        this.eventService = eventService;
        this.activityComponent = activityComponent;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
        List<? extends ContentItem> newsFeedEntries = newsFeedEntryComponent.getRecentNewsFeedEntries(1, 6);
        List<ContentSource> mediaTribes = contentSourceComponent.getContentSources(ContentSourceType.Media);
        List<? extends ContentItem> newsEntries = newsFeedEntryComponent.getRecentNewsFeedEntries(mediaTribes, 1, 3);
        List<Tweet> tweets = twitterService.getRecentTweets(1, 12);

        List<Talk> talks = talksService.getRecentTalks();
        if (talks.size() > PageSize.RECENT_TALKS) {
            talks = talks.subList(0, PageSize.RECENT_TALKS);
        }

        List<Job> jobs = jobService.getRecentJobs(PageSize.RECENT_JOBS);
        List<Event> events = eventService.getFutureEvents(PageSize.RECENT_EVENTS);

        model.addAttribute("newsFeedEntries", newsFeedEntries);
        model.addAttribute("newsEntries", newsEntries);
        model.addAttribute("tweets", tweets);
        model.addAttribute("talks", talks);
        model.addAttribute("jobs", jobs);
        model.addAttribute("events", events);

        model.addAttribute("activityListForPeople", activityComponent.getActivityListForPeople());
        model.addAttribute("activityListForBusinessTribes", activityComponent.getActivityListForBusinessTribes());
        model.addAttribute("activityListForCommunityTribes", activityComponent.getActivityListForCommunityTribes());

        List<Badge> badges = Badges.getBadges();
        model.addAttribute("badges", badges);

        model.addAttribute("currentPage", 1);
        model.addAttribute("maxPage", 2);

        addCommonAttributes(model);

		return "home";
	}

}
