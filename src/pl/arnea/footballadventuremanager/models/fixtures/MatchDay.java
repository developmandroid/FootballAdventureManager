package pl.arnea.footballadventuremanager.models.fixtures;

import pl.arnea.footballadventuremanager.models.club.Club;
import pl.arnea.footballadventuremanager.models.competition.Competition;

/**
 * Created by Arnea on 11.05.14.
 */
public class MatchDay {
    int round;
    Club homeTeam;
    Club awayTeam;
    Competition competitionType;

    public MatchDay(int round, Club homeTeam, Club awayTeam, Competition competitionType) {
        this.round = round;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.competitionType = competitionType;
    }


    public int getDate() {
        return round;
    }

    public void setDate(int round) {
        this.round = round;
    }

    public Club getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Club homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Club getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Club awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Competition getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(Competition competitionType) {
        this.competitionType = competitionType;
    }
}
