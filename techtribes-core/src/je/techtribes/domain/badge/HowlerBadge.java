package je.techtribes.domain.badge;

public class HowlerBadge extends AbstractHowlerBadge implements TalkBadge {

    public HowlerBadge() {
        super(Badges.HOWLER_ID, "Howler", "This badge is awarded to those that have shared their knowledge and experience by doing a talk.");
    }

    @Override
    protected int getThreshold() {
        return 1;
    }

}
