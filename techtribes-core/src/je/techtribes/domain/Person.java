package je.techtribes.domain;

import je.techtribes.util.comparator.ContentSourceByNameComparator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Person extends ContentSource {

    private final Set<Tribe> tribes = new TreeSet<>(new ContentSourceByNameComparator());

    public Person() {
        super(ContentSourceType.Person);
    }

    public Person(int id) {
        super(ContentSourceType.Person, id);
    }

    public Collection<Tribe> getTribes() {
        return new LinkedList<>(tribes);
    }

    public int getNumberOfTribes() {
        return tribes.size();
    }

    void add(Tribe tribe) {
        synchronized (tribes) {
            if (!isAMemberOf(tribe)) {
                tribes.add(tribe);
            }
        }
    }

    void remove(Tribe tribe) {
        synchronized (tribes) {
            if (isAMemberOf(tribe)) {
                tribes.remove(tribe);
            }
        }
    }

    public boolean isAMemberOf(Tribe tribe) {
        return tribes.contains(tribe);
    }

}