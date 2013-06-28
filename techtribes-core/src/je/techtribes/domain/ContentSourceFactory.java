package je.techtribes.domain;

public class ContentSourceFactory {

    public static ContentSource create(ContentSourceType type) {
        switch (type) {
            case Person:
                return new Person();
            default:
                return new Tribe(type);
        }
    }

    public static ContentSource create(ContentSourceType type, int id) {
        switch (type) {
            case Person:
                return new Person(id);
            default:
                return new Tribe(type, id);
        }
    }

}
