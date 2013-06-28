package je.techtribes.domain.badge;

public class TripleHowlerBadge extends AbstractHowlerBadge implements TalkBadge {

    public TripleHowlerBadge() {
        super(Badges.TRIPLE_HOWLER_ID, "Triple Howler", "Earn this by doing 3 or more talks.");
    }

    @Override
    protected int getThreshold() {
        return 3;
    }

}
