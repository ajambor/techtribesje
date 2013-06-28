package je.techtribes.domain.badge;

import je.techtribes.domain.ContentSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SignedInBadge extends AbstractBadge implements ContentSourceBadge {

    public SignedInBadge() {
        super(Badges.SIGNED_IN_ID, "Signed In", "You'll get this if you sign in to techtribes.je with your Twitter account. Simples.");
    }

    @Override
    public Set<ContentSource> findEligibleContentSources(Collection<ContentSource> contentSources) {
        Set<ContentSource> eligibleContentSources = new HashSet<>();

        if (contentSources != null) {
            for (ContentSource contentSource : contentSources) {
                if (contentSource.hasSignedInBefore()) {
                    eligibleContentSources.add(contentSource);
                }
            }
        }

        return eligibleContentSources;
    }

}
