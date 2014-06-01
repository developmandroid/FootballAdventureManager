package pl.arnea.footballadventuremanager.models.person;

public abstract class Person {

    private long id;
    private PersonName name;
    private PersonBirth birth;
    private String nationality;
    private PersonContract contract;
    private int morale;
    private int reputation;
    private int height;
    private int weight;

    public Person(long id, PersonName name, PersonBirth birth,
                  String nationality, PersonContract contract, int morale,
                  int reputation, int height, int weight) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.nationality = nationality;
        this.contract = contract;
        this.morale = morale;
        this.reputation = reputation;
        this.height = height;
        this.weight = weight;


    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonName getName() {
        return name;
    }

    public void setName(PersonName name) {
        this.name = name;
    }

    public PersonBirth getBirth() {
        return birth;
    }

    public void setBirth(PersonBirth birth) {
        this.birth = birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public PersonContract getContract() {
        return contract;
    }

    public void setContract(PersonContract contract) {
        this.contract = contract;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
