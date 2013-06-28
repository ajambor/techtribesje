package je.techtribes.domain.badge;

import je.techtribes.util.comparator.BadgeComparator;

import java.util.*;

public class Badges {

    // activity badges
    public static final int MOST_ACTIVE_GOLD_ID = 1;
    public static final int MOST_ACTIVE_SILVER_ID = 2;
    public static final int MOST_ACTIVE_BRONZE_ID = 3;

    // talk badges
    public static final int HOWLER_ID = 101;
    public static final int ROCKHOPPER_ID = 102;
    public static final int JETSETTER_ID = 103;
    public static final int TRIPLE_HOWLER_ID = 104;
    public static final int SUPER_HOWLER_ID = 105;
    public static final int TRIPLE_JETSETTER_ID = 106;
    public static final int JETSETTER_EXTRAORDINAIRE_ID = 107;

    // blog badges
    public static final int BLOGGER_ID = 201;
    public static final int FREQUENT_BLOGGER_ID = 202;

    // Twitter badges
    public static final int TWEETER_ID = 301;
    public static final int COMMUNITY_HASHTAGGER_ID = 302;
    public static final int COMMUNITY_MENTIONER_ID = 303;

    // content source badges
    public static final int SIGNED_IN_ID = 401;
    public static final int TRIBAL_ID = 402;

    // special badges
    public static final int TECH_TRIBER_ID = 901;

    static final int[] BADGE_ORDER = new int[] {
        MOST_ACTIVE_GOLD_ID, MOST_ACTIVE_SILVER_ID, MOST_ACTIVE_BRONZE_ID,
        HOWLER_ID, ROCKHOPPER_ID, JETSETTER_ID, TRIPLE_HOWLER_ID, SUPER_HOWLER_ID, TRIPLE_JETSETTER_ID, JETSETTER_EXTRAORDINAIRE_ID,
        BLOGGER_ID, FREQUENT_BLOGGER_ID,
        TWEETER_ID, COMMUNITY_HASHTAGGER_ID, COMMUNITY_MENTIONER_ID,
        SIGNED_IN_ID, TRIBAL_ID,
        TECH_TRIBER_ID
    };

    private static final List<ActivityBadge> ACTIVITY_BADGES = new LinkedList<>();
    private static final List<TalkBadge> TALK_BADGES = new LinkedList<>();
    private static final List<ContentBadge> CONTENT_BADGES = new LinkedList<>();
    private static final List<TwitterBadge> TWITTER_BADGES = new LinkedList<>();
    private static final List<ContentSourceBadge> CONTENT_SOURCE_BADGES = new LinkedList<>();

    private static final Map<Integer, Badge> BADGES_BY_ID = new HashMap<>();
    private static final List<Badge> ALL_BADGES = new LinkedList<>();

    static {
        ACTIVITY_BADGES.add(new MostActiveGoldBadge());
        ACTIVITY_BADGES.add(new MostActiveSilverBadge());
        ACTIVITY_BADGES.add(new MostActiveBronzeBadge());
        ACTIVITY_BADGES.add(new FrequentBloggerBadge());

        for (Badge badge : ACTIVITY_BADGES) {
            BADGES_BY_ID.put(badge.getId(), badge);
        }

        TALK_BADGES.add(new HowlerBadge());
        TALK_BADGES.add(new TripleHowlerBadge());
        TALK_BADGES.add(new SuperHowlerBadge());
        TALK_BADGES.add(new RockhopperBadge());
        TALK_BADGES.add(new JetsetterBadge());
        TALK_BADGES.add(new TripleJetsetterBadge());
        TALK_BADGES.add(new JetsetterExtraordinaireBadge());

        for (Badge badge : TALK_BADGES) {
            BADGES_BY_ID.put(badge.getId(), badge);
        }

        CONTENT_BADGES.add(new BloggerBadge());

        for (Badge badge : CONTENT_BADGES) {
            BADGES_BY_ID.put(badge.getId(), badge);
        }

        TWITTER_BADGES.add(new TweeterBadge());
        TWITTER_BADGES.add(new CommunityHashtaggerBadge());
        TWITTER_BADGES.add(new CommunityMentionerBadge());

        for (Badge badge : TWITTER_BADGES) {
            BADGES_BY_ID.put(badge.getId(), badge);
        }

        CONTENT_SOURCE_BADGES.add(new SignedInBadge());
        CONTENT_SOURCE_BADGES.add(new TribalBadge());

        for (Badge badge : CONTENT_SOURCE_BADGES) {
            BADGES_BY_ID.put(badge.getId(), badge);
        }

        ALL_BADGES.addAll(ACTIVITY_BADGES);
        ALL_BADGES.addAll(TALK_BADGES);
        ALL_BADGES.addAll(CONTENT_BADGES);
        ALL_BADGES.addAll(TWITTER_BADGES);
        ALL_BADGES.addAll(CONTENT_SOURCE_BADGES);

        Badge techTriberBadge = new TechTriberBadge();
        ALL_BADGES.add(techTriberBadge);
        BADGES_BY_ID.put(techTriberBadge.getId(), techTriberBadge);

        // and order the badges
        for (int i = 0; i < Badges.BADGE_ORDER.length; i++) {
            BADGES_BY_ID.get(Badges.BADGE_ORDER[i]).setOrder(i);
        }
        Collections.sort(ALL_BADGES, new BadgeComparator());
    }

    public static List<ActivityBadge> getActivityBadges() {
        return new LinkedList<>(ACTIVITY_BADGES);
    }

    public static List<TalkBadge> getTalkBadges() {
        return new LinkedList<>(TALK_BADGES);
    }

    public static List<ContentBadge> getContentBadges() {
        return new LinkedList<>(CONTENT_BADGES);
    }

    public static List<TwitterBadge> getTwitterBadges() {
        return new LinkedList<>(TWITTER_BADGES);
    }

    public static List<ContentSourceBadge> getContentSourceBadges() {
        return new LinkedList<>(CONTENT_SOURCE_BADGES);
    }

    public static List<Badge> getBadges() {
        return new LinkedList<>(ALL_BADGES);
    }

    public static Badge find(int badgeId) {
        return BADGES_BY_ID.get(badgeId);
    }

}
