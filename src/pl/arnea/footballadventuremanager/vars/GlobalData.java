package pl.arnea.footballadventuremanager.vars;

import pl.arnea.footballadventuremanager.models.club.Club;
import pl.arnea.footballadventuremanager.models.competition.League;
import pl.arnea.footballadventuremanager.models.fixtures.MatchDay;
import pl.arnea.footballadventuremanager.models.person.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnea on 14.05.14.
 */
public class GlobalData {
    public static int MYCLUBID;
    public static int MYLEAGUEID;


    public static String goalkeeperPosName = "GK";
    public static String defPosName = "D";
    public static String defMidPosName = "DM";
    public static String midPosName = "M";
    public static String attMidPosName = "AM";
    public static String forwardPosName = "F";
    public static String leftSideName = "L";
    public static String rightSideName = "R";
    public static String centerSideName = "C";


    public static List<League> allLeagues = new ArrayList<League>();
    public static List<Club> allClubs = new ArrayList<Club>();
    public static List<MatchDay> fixtures = new ArrayList<MatchDay>();


    public static Player tempPlayer = new Player(-1, new PersonName("Temp", "temp"), new PersonBirth("12-12-1988"), "TEMP",
            new PersonContract("12-12-2018", 10000), 1, 1, 1, 1,
            new PlayerPosition(NewGameData.POSITION[0]), 0, 1, new Injury(0, 0), new Suspension(0, 0), new Skills(50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
            50)
    );


}
