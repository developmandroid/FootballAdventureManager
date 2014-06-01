package pl.arnea.footballadventuremanager.models.person;

public class Manager {
    String firstname;
    String lastname;

    public Manager(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String toString() {

        String managerName = getFirstname() + " " + getLastname();
        return managerName;

    }

}




