package je.techtribes.domain.badge;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.Person;
import je.techtribes.domain.Tribe;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TribalBadge extends AbstractBadge implements ContentSourceBadge {

    public TribalBadge() {
        super(Badges.TRIBAL_ID, "Tribal", "This is awarded to people that are part of a tribe, or tribes that have one or more members.");
    }

    @Override
    public Set<ContentSource> findEligibleContentSources(Collection<ContentSource> contentSources) {
        Set<ContentSource> eligibleContentSources = new HashSet<>();

        if (contentSources != null) {
            for (ContentSource contentSource : contentSources) {
                switch (contentSource.getType()) {
                    case Person:
                        Person person = (Person)contentSource;
                        if (!person.getTribes().isEmpty()) {
                            eligibleContentSources.add(person);
                        }
                        break;
                    default:
                        Tribe tribe = (Tribe)contentSource;
                        if (!tribe.getMembers().isEmpty()) {
                            eligibleContentSources.add(tribe);
                        }
                        break;
                }
            }
        }

        return eligibleContentSources;
    }

}
