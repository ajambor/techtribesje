package je.techtribes.domain;

import je.techtribes.util.comparator.ContentSourceByNameComparator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Tribe extends ContentSource {

    private final Set<Person> members = new TreeSet<>(new ContentSourceByNameComparator());

    public Tribe(ContentSourceType type) {
        super(type);
    }

    public Tribe(ContentSourceType type, int id) {
        super(type, id);
    }

    public int getNumberOfMembers() {
        return members.size();
    }

    public Collection<Person> getMembers() {
        return new LinkedList<>(members);
    }

    public void add(Person person) {
        synchronized (members) {
            if (!hasMember(person)) {
                members.add(person);
                person.add(this);
            }
        }
    }

    public void remove(Person person) {
        synchronized (members) {
            if (hasMember(person)) {
                members.remove(person);
                person.remove(this);
            }
        }
    }

    public boolean hasMember(Person person) {
        return members.contains(person);
    }

    public void setMembers(Collection<Person> people) {
        synchronized (members) {
            this.members.clear();

            for (Person person : people) {
                add(person);
            }
        }
    }

}
