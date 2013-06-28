package je.techtribes.component.contentsource;

class TribeAndPersonLink {

    private int tribeId;
    private int personId;

    public TribeAndPersonLink(int tribeId, int personId) {
        this.tribeId = tribeId;
        this.personId = personId;
    }

    public int getTribeId() {
        return tribeId;
    }

    public int getPersonId() {
        return personId;
    }

}
