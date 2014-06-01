package pl.arnea.footballadventuremanager.models.competition;

public class Competition {
    Friendly friendly;
    League league;
    NationalCup nationalCup;
    LeagueCup leagueCup;
    EuropeanCup europeanCup;
    EuropeanLeague europeanLeague;
    String competition;

    public Competition(String competition) {
        this.competition = competition;
    }

    public Competition(Friendly friendly, League league,
                       NationalCup nationalCup, LeagueCup leagueCup,
                       EuropeanCup europeanCup, EuropeanLeague europeanLeague) {

        this.friendly = friendly;
        this.league = league;
        this.nationalCup = nationalCup;
        this.leagueCup = leagueCup;
        this.europeanCup = europeanCup;
        this.europeanLeague = europeanLeague;
    }

    public Friendly getFriendly() {
        return friendly;
    }

    public void setFriendly(Friendly friendly) {
        this.friendly = friendly;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public NationalCup getNationalCup() {
        return nationalCup;
    }

    public void setNationalCup(NationalCup nationalCup) {
        this.nationalCup = nationalCup;
    }

    public LeagueCup getLeagueCup() {
        return leagueCup;
    }

    public void setLeagueCup(LeagueCup leagueCup) {
        this.leagueCup = leagueCup;
    }

    public EuropeanCup getEuropeanCup() {
        return europeanCup;
    }

    public void setEuropeanCup(EuropeanCup europeanCup) {
        this.europeanCup = europeanCup;
    }

    public EuropeanLeague getEuropeanLeague() {
        return europeanLeague;
    }

    public void setEuropeanLeague(EuropeanLeague europeanLeague) {
        this.europeanLeague = europeanLeague;
    }


}
