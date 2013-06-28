package je.techtribes.component.badge;

import je.techtribes.AbstractComponentTestsBase;
import je.techtribes.domain.ContentSource;
import je.techtribes.domain.badge.AwardedBadge;
import je.techtribes.domain.badge.Badges;
import je.techtribes.util.DateUtils;
import org.junit.After;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BadgeComponentTests extends AbstractComponentTestsBase {

    @Test
    public void test_getAwardedBadges_ReturnsAnEmptyList_WhenNoBadgesHaveBeenAwarded() {
        List<AwardedBadge> badges = getBadgeComponent().getAwardedBadges();
        assertEquals(0, badges.size());
    }

    @Test
    public void test_getAwardedBadges_ReturnsANonEmptyList_WhenBadgesHaveBeenAwarded() {
        for (int i = 1; i <= 10; i++) {
            addBadge("simonbrown", Badges.getBadges().get(i).getId(), DateUtils.getXDaysAgo(10-i));
        }
        List<AwardedBadge> awardedBadges = getBadgeComponent().getAwardedBadges();
        assertEquals(10, awardedBadges.size());
        int i = 10;
        for (AwardedBadge awardedBadge : awardedBadges) {
            assertEquals(Badges.getBadges().get(i).getId(), awardedBadge.getBadge().getId());
            i--;
        }
    }

    @Test
    public void test_getRecentAwardedBadges_ReturnsAnEmptyList_WhenNoBadgesHaveBeenAwarded() {
        List<AwardedBadge> badges = getBadgeComponent().getRecentAwardedBadges(10);
        assertEquals(0, badges.size());
    }

    @Test
    public void test_getRecentAwardedBadges_ReturnsANonEmptyList_WhenBadgesHaveBeenAwarded() {
        for (int i = 1; i <= 10; i++) {
            addBadge("simonbrown", Badges.getBadges().get(i).getId(), DateUtils.getXDaysAgo(10-i));
        }
        List<AwardedBadge> awardedBadges = getBadgeComponent().getRecentAwardedBadges(10);
        assertEquals(10, awardedBadges.size());
        int i = 10;
        for (AwardedBadge awardedBadge : awardedBadges) {
            assertEquals(Badges.getBadges().get(i).getId(), awardedBadge.getBadge().getId());
            i--;
        }
    }

    @Test
    public void test_getAwardedBadgesForContentSource_ReturnsAnEmptyList_WhenNullIsSpecified() {
        List<AwardedBadge> badges = getBadgeComponent().getAwardedBadges(null);
        assertEquals(0, badges.size());
    }

    @Test
    public void test_getAwardedBadgesForContentSource_ReturnsAnEmptyList_WhenNoBadgesHaveBeenAwarded() {
        List<AwardedBadge> badges = getBadgeComponent().getAwardedBadges(getContentSourceComponent().findByShortName("simonbrown"));
        assertEquals(0, badges.size());
    }

    @Test
    public void test_getAwardedBadgesForContentSource_ReturnsANonEmptyList_WhenBadgesHaveBeenAwarded() {
        for (int i = 1; i <= 10; i++) {
            addBadge("simonbrown", Badges.getBadges().get(i).getId(), DateUtils.getXDaysAgo(20-i));
        }
        for (int i = 1; i <= 10; i++) {
            addBadge("chrisclark", Badges.getBadges().get(i).getId(), DateUtils.getXDaysAgo(20-i));
        }
        List<AwardedBadge> awardedBadges = getBadgeComponent().getAwardedBadges(getContentSourceComponent().findByShortName("simonbrown"));
        assertEquals(10, awardedBadges.size());
        int i = 10;
        for (AwardedBadge awardedBadge : awardedBadges) {
            assertEquals(Badges.getBadges().get(i).getId(), awardedBadge.getBadge().getId());
            i--;
        }
    }

    @Test
    public void test_BadgeDetailsAreCorrectlyStoredAndRetrieved() {
        ContentSource contentSource = getContentSourceComponent().findByShortName("simonbrown");
        Date yesterday = DateUtils.getXDaysAgo(1);
        AwardedBadge awardedBadge = new AwardedBadge(Badges.JETSETTER_ID, contentSource.getId(), yesterday);
        getBadgeComponent().add(awardedBadge);

        awardedBadge = getBadgeComponent().getRecentAwardedBadges(1).get(0);
        assertEquals(Badges.JETSETTER_ID, awardedBadge.getBadge().getId());
        assertEquals("Simon Brown", awardedBadge.getContentSource().getName());
        assertEquals(yesterday, awardedBadge.getDate());
    }

    @Test
    public void test_AddingANullBadge_DoesntBreak() {
        getBadgeComponent().add(null);
    }

    @After
    public void tearDown() {
        JdbcTemplate template = getJdbcTemplate();
        template.execute("delete from badge");
    }

    private void addBadge(String contentSourceShortName, int badgeId, Date date) {
        JdbcTemplate template = getJdbcTemplate();
        ContentSource contentSource = getContentSourceComponent().findByShortName(contentSourceShortName);
        template.update("insert into badge (badge_id, content_source_id, date) values (?, ?, ?)",
                badgeId,
                contentSource.getId(),
                date);
    }

}
