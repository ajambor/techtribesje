package je.techtribes.domain.badge;

public class SuperHowlerBadge extends AbstractHowlerBadge implements TalkBadge {

    public SuperHowlerBadge() {
        super(Badges.SUPER_HOWLER_ID, "Super Howler", "Earn this by doing 10 or more talks.");
    }

    @Override
    protected int getThreshold() {
        return 10;
    }
}