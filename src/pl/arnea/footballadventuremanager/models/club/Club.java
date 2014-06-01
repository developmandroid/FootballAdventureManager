package pl.arnea.footballadventuremanager.models.club;

import pl.arnea.footballadventuremanager.models.person.Manager;

public class Club {

    // TODO
    // LeagueInfo; YearFounded; Sign; Adress; Kit colours
    // ReserveTeam; JuniorTeam;
    // etc....

    public long id;
    public String name;
    public String nation;
    public int reputation;
    public ClubBudget budget;
    public Staff staff;
    public ClubFacilities facilities;
    public Manager manager;
    private Team firstTeam;

    public Club(int id, String name, String nation, int reputation,
                Team firstTeam, ClubBudget budget, Staff staff,
                ClubFacilities facilities, Manager manager) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.reputation = reputation;
        this.firstTeam = firstTeam;
        this.budget = budget;
        this.staff = staff;
        this.facilities = facilities;
        this.manager = manager;
    }

    public Club() {

    }

    public long getId() {
        return id;
    }

    public void setId(long insertid) {
        this.id = insertid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public ClubBudget getBudget() {
        return budget;
    }

    public void setBudget(ClubBudget string) {
        this.budget = string;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff string) {
        this.staff = string;
    }

    public ClubFacilities getFacilities() {
        return facilities;
    }

    public void setFacilities(ClubFacilities facilities) {
        this.facilities = facilities;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String toString() {
        String club = getName() + " " + budget.income;
        return club;

    }
}