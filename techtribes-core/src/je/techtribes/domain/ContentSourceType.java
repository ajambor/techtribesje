package je.techtribes.domain;

public enum ContentSourceType {

    Person,
    Business,
    Community,
    Tech,
    Media;

    public static ContentSourceType lookupByChar(char type) {
        switch (type) {
            case 'p':
                return Person;
            case 'b':
                return Business;
            case 't':
                return Tech;
            case 'm':
                return Media;
            case 'c':
                return Community;
            default:
                // fall-back
                return Person;
        }
    }

    public String toChar() {
        return this.toString().toLowerCase().charAt(0) + "";
    }

}
