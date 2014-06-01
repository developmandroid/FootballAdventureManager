package pl.arnea.footballadventuremanager.models.club;

import pl.arnea.footballadventuremanager.models.person.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Tactics tactics;
    private List<Player> teamPlayers = new ArrayList<Player>();

    public Team(List<Player> teamPlayers, Tactics tactics) {
        this.teamPlayers = teamPlayers;
        this.tactics = tactics;
    }

    public List<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public Tactics getTeamTactics() {
        return tactics;
    }

    public void setTeamTactics(Tactics tactics) {
        this.tactics = tactics;
    }

    // TODO
    // MatchLineUp
    // MatchTactic
    // teamCoach;
}
