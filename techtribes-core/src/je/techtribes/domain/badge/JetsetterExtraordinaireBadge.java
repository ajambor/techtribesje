package je.techtribes.domain.badge;

public class JetsetterExtraordinaireBadge extends AbstractJetsetterBadge implements TalkBadge {

    public JetsetterExtraordinaireBadge() {
        super(Badges.JETSETTER_EXTRAORDINAIRE_ID, "Jetsetter Extraordinaire", "This illustrious badge is earned by doing 10 or more international talks.");
    }

    @Override
    protected int getThreshold() {
        return 10;
    }
}
