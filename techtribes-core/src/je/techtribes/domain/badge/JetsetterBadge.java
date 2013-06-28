package je.techtribes.domain.badge;

public class JetsetterBadge extends AbstractJetsetterBadge implements TalkBadge {

    public JetsetterBadge() {
        super(Badges.JETSETTER_ID, "Jetsetter", "This badge is earned by doing an international talk and representing your local community on the world stage.");
    }

    @Override
    protected int getThreshold() {
        return 1;
    }

}
