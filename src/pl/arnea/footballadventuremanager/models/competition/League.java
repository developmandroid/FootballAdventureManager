package pl.arnea.footballadventuremanager.models.competition;

import pl.arnea.footballadventuremanager.models.club.Club;

import java.util.ArrayList;
import java.util.List;

public class League {

    List<Club> leagueClubs = new ArrayList<Club>();


    public League(String leagueName, List<Club> leagueClubs) {


        this.leagueClubs = leagueClubs;
    }

    public List<Club> getLeagueClubs() {
        return leagueClubs;
    }

    public void setLeagueClubs(List<Club> leagueClubs) {
        this.leagueClubs = leagueClubs;
    }


}
