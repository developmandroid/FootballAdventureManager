package pl.arnea.footballadventuremanager.models.person;

public class Player extends Person {

    int squadPosition;
    private int condition;
    private Injury injury;
    private Suspension suspension;
    private Skills skills;
    private PlayerPosition preferredPosition;
    private String empty;

    public Player(int id, PersonName name, PersonBirth birth,
                  String nationality, PersonContract contract, int morale,
                  int reputation, int height, int weight, PlayerPosition preferredPosition, int squadPosition,
                  int condition, Injury injury, Suspension suspension, Skills skills) {

        super(id, name, birth, nationality, contract, morale, reputation,
                height, weight);

        this.preferredPosition = preferredPosition;
        this.squadPosition = squadPosition;
        this.condition = condition;
        this.injury = injury;
        this.suspension = suspension;
        this.skills = skills;

    }

    public Player() {
        super();
    }

    public PlayerPosition getPreferredPosition() {
        return preferredPosition;
    }

    public void setPreferredPosition(PlayerPosition preferredPosition) {
        this.preferredPosition = preferredPosition;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public Injury getInjury() {
        return injury;
    }

    public void setInjury(Injury injury) {
        this.injury = injury;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public String toString() {

        String playerName = super.getId() + " " + super.getName().toString()
                + " " + super.getBirth().toString() + " "
                + super.getNationality() + " " + super.getContract();

        return playerName;

    }

    public boolean getEmpty() {
        boolean emptyId = false;
        return emptyId;
    }

    public int getSquadPosition() {
        return squadPosition;
    }

    public void setSquadPosition(int squadPosition) {
        this.squadPosition = squadPosition;
    }
}
