package pl.arnea.footballadventuremanager.gen;

import android.util.Log;
import pl.arnea.footballadventuremanager.models.club.*;
import pl.arnea.footballadventuremanager.models.competition.Competition;
import pl.arnea.footballadventuremanager.models.competition.League;
import pl.arnea.footballadventuremanager.models.fixtures.MatchDay;
import pl.arnea.footballadventuremanager.models.person.*;
import pl.arnea.footballadventuremanager.vars.DbVars;
import pl.arnea.footballadventuremanager.vars.GlobalData;
import pl.arnea.footballadventuremanager.vars.NewGameData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewGameCreator {

    Random generator = new Random();
    private int numberOfTeams = 100;
    private int numberOfClubInLeague = 18;

    //public static List<League> allLeagues = new ArrayList<League>();
    // public static List<Club> allClubs = new ArrayList<Club>();
    // public static List<MatchDay> competition = new ArrayList<MatchDay>();

    public void createNewClubs() {
        List<PlayerPosition> playerPos = new ArrayList<PlayerPosition>();

        for (int i = 1; i <= numberOfTeams; i++) {

            int teamCityRandomNumber = generator.nextInt(NewGameData.TEAMCITY.length);
            int teamNameRandomNumber = generator.nextInt(NewGameData.TEAMNAME.length);

            // name
            String name = NewGameData.TEAMNAME[teamNameRandomNumber] + " " + NewGameData.TEAMCITY[teamCityRandomNumber] + " " + i;

            // nation
            String nation = "England";

            // reputation
            int reputation = 25;

            // team
            List<Player> teamPlayers = new ArrayList<Player>();

            for (int idPlayer = 1; idPlayer <= 17; idPlayer++) {

                int firstnameRandomNumber = generator.nextInt(NewGameData.FIRSTNAME.length);
                int lastnameRandomNumber = generator.nextInt(NewGameData.LASTNAME.length);

                int nationalityRandomNumber = generator.nextInt(NewGameData.NATIONALITY.length);
                int positionRandomNumber = generator.nextInt(NewGameData.POSITION.length - 1) + 1;
                int positionSideRandomNumber = generator.nextInt(NewGameData.POSITIONSIDE.length);

                PersonName playerName = new PersonName(NewGameData.FIRSTNAME[firstnameRandomNumber], NewGameData.LASTNAME[lastnameRandomNumber]);
                PersonBirth birth = new PersonBirth("12-12-1988");
                String nationality = NewGameData.NATIONALITY[nationalityRandomNumber];
                PersonContract contractEnd = new PersonContract("12-12-2018", 10000);
                int morale = 100;
                int playerReputation = 20;
                int height = 178;
                int weight = 68;
                PlayerPosition preferredPosition;
                int squadPosition = 0;

                playerPos.add(new PlayerPosition(GlobalData.goalkeeperPosName));
                playerPos.add(new PlayerPosition(GlobalData.defPosName, GlobalData.leftSideName));
                playerPos.add(new PlayerPosition(GlobalData.defPosName, GlobalData.rightSideName));
                playerPos.add(new PlayerPosition(GlobalData.defPosName, GlobalData.centerSideName));
                playerPos.add(new PlayerPosition(GlobalData.defPosName, GlobalData.centerSideName));
                playerPos.add(new PlayerPosition(GlobalData.midPosName, GlobalData.leftSideName));
                playerPos.add(new PlayerPosition(GlobalData.midPosName, GlobalData.rightSideName));
                playerPos.add(new PlayerPosition(GlobalData.midPosName, GlobalData.centerSideName));
                playerPos.add(new PlayerPosition(GlobalData.midPosName, GlobalData.centerSideName));
                playerPos.add(new PlayerPosition(GlobalData.forwardPosName, GlobalData.centerSideName));
                playerPos.add(new PlayerPosition(GlobalData.forwardPosName, GlobalData.centerSideName));


                if (idPlayer < 12) {
                    if (idPlayer == 1 || idPlayer == 12) {
                        preferredPosition = new PlayerPosition(NewGameData.POSITION[0]);
                        squadPosition = NewGameData.START_SQUAD_POSITION[idPlayer - 1];
                    } else {
                        squadPosition = NewGameData.START_SQUAD_POSITION[idPlayer - 1];
                        preferredPosition = playerPos.get(idPlayer - 1);
                    }
                } else {
                    if (idPlayer == 1 || idPlayer == 12) {
                        preferredPosition = new PlayerPosition(NewGameData.POSITION[0]);
                        squadPosition = NewGameData.START_SQUAD_POSITION[idPlayer - 1];
                    } else {
                        squadPosition = NewGameData.START_SQUAD_POSITION[idPlayer - 1];
                        preferredPosition = new PlayerPosition(NewGameData.POSITION[positionRandomNumber], NewGameData.POSITIONSIDE[positionSideRandomNumber]);
                    }
                }


                int condition = 100;
                Injury injury = new Injury(0, 0);
                Suspension suspension = new Suspension(0, 0);
                Skills skills = new Skills(50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
                        50);

                Player player = new Player(idPlayer, playerName, birth, nationality,
                        contractEnd, morale, playerReputation, height, weight,
                        preferredPosition, squadPosition, condition, injury, suspension, skills);

                teamPlayers.add(player);

            }


            Tactics tactics = new Tactics(playerPos);
            Team firstTeam = new Team(teamPlayers, tactics);

            // club budget
            ClubBudget budget = new ClubBudget(300000, 0, 0, 0, 0, 0, 0, 0, 0,
                    0);

            // staff
            Staff staff = new Staff();

            // club facilities
            Stadium stadium = new Stadium();
            Office office = new Office();
            TrainingBase trainingBase = new TrainingBase();
            PhysioBase physioBase = new PhysioBase();
            ClubFacilities facilities = new ClubFacilities(stadium, office,
                    trainingBase, physioBase);

            // manager
            Manager manager = new Manager("Łukasz", "Murinio");

            Club club = new Club(i, name, nation, reputation, firstTeam,
                    budget, staff, facilities, manager);
            GlobalData.allClubs.add(club);


        }

    }


    public void createNewLeagues() {

        for (int l = 0; l < DbVars.LEAGUES.length; l++) {
            List<Club> leagueClubs = new ArrayList<Club>();
            for (int i = 0; i < numberOfClubInLeague; i++) {
                Club club = GlobalData.allClubs.get(i + (18 * l));
                leagueClubs.add(club);
                Log.d("fam", "Team gen: " + i);

            }
            League league = new League(DbVars.LEAGUES[l], leagueClubs);
            GlobalData.allLeagues.add(league);
            Log.d("fam", "League gen: " + l);
        }


        // NationalCup nationalCup = null;
        // LeagueCup leagueCup = null;
        // EuropeanCup europeanCup = null;
        // EuropeanLeague europeanLeague = null;

        // Competition competition = new Competition(friendly, league,
        // nationalCup, leagueCup, europeanCup, europeanLeague);
        // allCompetition.add(competition);

    }

    public void createNewLeagueFixtures() {
        Competition competition = new Competition("League");

        int idTeam = 0;

        for (int l = 1; l <= 34; l++) {
            Log.d("TESTER", "Kolejka: " + l);

            for (int x = 0; x < 8; x++) {

                int hometeam = NewGameData.FIXTURES[idTeam] - 1;
                idTeam++;
                int awayteam = NewGameData.FIXTURES[idTeam] - 1;
                idTeam++;
                Log.d("TESTER", "Kolejka: " + l + " " + GlobalData.allLeagues.get(0).getLeagueClubs().get(hometeam).getName() + " - " + GlobalData.allLeagues.get(0).getLeagueClubs().get(awayteam).getName());

                MatchDay matchday = new MatchDay(l, GlobalData.allLeagues.get(0).getLeagueClubs().get(hometeam), GlobalData.allLeagues.get(0).getLeagueClubs().get(awayteam), competition);
                GlobalData.fixtures.add(matchday);
            }
        }


        //for (int i = 1; i <= 34; i++) {

        //Log.d("TESTER", "Kolejka: " + i);

        // for (int x = 0; i < 8; x++) {

        // int hometeam = NewGameData.FIXTURES[idTeam]-1;
        // idTeam++;
        //int awayteam = NewGameData.FIXTURES[idTeam]-1;
        // idTeam++;
        // Log.d("TESTER", "Kolejka: " + i + " " + allLeagues.get(0).getLeagueClubs().get(hometeam).getName() + " - " + allLeagues.get(0).getLeagueClubs().get(awayteam).getName());

        // MatchDay matchday = new MatchDay(i, allLeagues.get(0).getLeagueClubs().get(hometeam), allLeagues.get(0).getLeagueClubs().get(awayteam), competition);
        // competition.add(matchday);
        // }
        // }

    }


}
