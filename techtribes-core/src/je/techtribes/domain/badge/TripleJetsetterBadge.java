package je.techtribes.domain.badge;

public class TripleJetsetterBadge extends AbstractJetsetterBadge implements TalkBadge {

    public TripleJetsetterBadge() {
        super(Badges.TRIPLE_JETSETTER_ID, "Triple Jetsetter", "Earn this by doing 3 or more international talks.");
    }

    @Override
    protected int getThreshold() {
        return 3;
    }
}
