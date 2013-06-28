package je.techtribes.domain.badge;

import je.techtribes.domain.badge.Badges;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadgesTests {

    @Test
    public void testFindBadge() {
        assertEquals(901, Badges.find(901).getId());
    }

}
