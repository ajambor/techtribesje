package je.techtribes.domain;


public enum Island {

    Jersey,
    Guernsey,
    None;

    public static Island lookup(String name) {
        if ("jersey".equalsIgnoreCase(name)) {
            return Jersey;
        } else if ("guernsey".equalsIgnoreCase(name)) {
            return Guernsey;
        } else {
            return None;
        }
    }

    public static Island lookupByChar(String island) {
        if (island == null || island.trim().length() == 0) {
            return None;
        }

        switch (island.toLowerCase().charAt(0)) {
            case 'g':
                return Guernsey;
            default:
                return Jersey;
        }
    }

    public String toChar() {
        switch (this) {
            case Jersey:
                return "j";
            case Guernsey:
                return "g";
            default:
                return null;
        }
    }

}
