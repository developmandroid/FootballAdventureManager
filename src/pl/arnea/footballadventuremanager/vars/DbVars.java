package pl.arnea.footballadventuremanager.vars;

import pl.arnea.footballadventuremanager.database.Queries;

public class DbVars {

    /*
     * *************************************************
     * 
     * DATABASE VARS
     * 
     * **************************************************
     */

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ID_DATATYPE = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String COLUMN_INTEGER_DATATYPE = "INTEGER";
    public static final String COLUMN_TEXT_DATATYPE = "TEXT";

    /*
     * *************************************************
     * 
     * DATABASE TABLE FIELDS
     * 
     * **************************************************
     */

    /* Person Table */

    public static final String TABLE_PERSON = "Person";
    public static final String DROP_TABLE_PERSON = "DROP TABLE IF EXISTS "
            + TABLE_PERSON;
    public static final String[] TABLE_PERSON_FIELDS = {"id", "idClubFk",
            "idPersonJobFk", "firstName", "lastName", "nationality", "birth",
            "endContract", "contractValue", "morale", "reputation", "height",
            "weight"};
    public static final String INSERT_TABLE_PERSON = Queries.insertFieldsQuery(
            TABLE_PERSON, TABLE_PERSON_FIELDS);

    /* PersonJob Table */
    public static final String[] TABLE_PERSON_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES Club",
            "INTEGER REFERENCES PersonJob", "TEXT", "TEXT", "TEXT", "TEXT",
            "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER"};
    public static final String[] TABLE_PERSON_INDEX = null;
    public static final String CREATE_TABLE_PERSON = Queries.createTableQuery(
            TABLE_PERSON, TABLE_PERSON_FIELDS, TABLE_PERSON_DATATYPE,
            TABLE_PERSON_INDEX);
    public static final String TABLE_PERSON_JOB = "PersonJob";
    public static final String DROP_TABLE_PERSON_JOB = "DROP TABLE IF EXISTS "
            + TABLE_PERSON_JOB;
    public static final String[] TABLE_PERSON_JOB_FIELDS = {"id",
            "personJobType"};
    public static final String INSERT_TABLE_PERSON_JOB = Queries
            .insertFieldsQuery(TABLE_PERSON_JOB, TABLE_PERSON_JOB_FIELDS);
    public static final String[] TABLE_PERSON_JOB_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_PERSON_JOB_INDEX = null;
    public static final String CREATE_TABLE_PERSON_JOB = Queries
            .createTableQuery(TABLE_PERSON_JOB, TABLE_PERSON_JOB_FIELDS,
                    TABLE_PERSON_JOB_FIELDS, TABLE_PERSON_JOB_INDEX);
    /* Person has Skills */
    public static final String TABLE_PERSON_HAS_SKILL = "PersonHasSkill";
    public static final String DROP_TABLE_PERSON_HAS_SKILL = "DROP TABLE IF EXISTS "
            + TABLE_PERSON_HAS_SKILL;
    public static final String[] TABLE_PERSON_HAS_SKILL_FIELDS = {
            "idPersonFk", "idSkillTypeFk", "skillValue"};
    public static final String INSERT_TABLE_PERSON_HAS_SKILL = Queries
            .insertFieldsQuery(TABLE_PERSON_HAS_SKILL,
                    TABLE_PERSON_HAS_SKILL_FIELDS);
    public static final String[] TABLE_PERSON_HAS_SKILL_DATATYPE = {
            "INTEGER REFERENCES Person", "INTEGER REFERENCES skillType",
            "INTEGER"};
    public static final String[] TABLE_PERSON_HAS_SKILL_INDEX = null;
    public static final String CREATE_TABLE_PERSON_HAS_SKILL = Queries
            .createTableQuery(TABLE_PERSON_HAS_SKILL,
                    TABLE_PERSON_HAS_SKILL_FIELDS,
                    TABLE_PERSON_HAS_SKILL_DATATYPE,
                    TABLE_PERSON_HAS_SKILL_INDEX);
    /* Person Skill Type */
    public static final String TABLE_SKILL_TYPE = "SkillType";
    public static final String DROP_TABLE_SKILL_TYPE = "DROP TABLE IF EXISTS "
            + TABLE_SKILL_TYPE;
    public static final String[] TABLE_SKILL_TYPE_FIELDS = {"id",
            "skillTypeName"};
    public static final String INSERT_TABLE_SKILL_TYPE = Queries
            .insertFieldsQuery(TABLE_SKILL_TYPE, TABLE_SKILL_TYPE_FIELDS);
    public static final String[] TABLE_SKILL_TYPE_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_SKILL_TYPE_INDEX = null;
    public static final String CREATE_TABLE_SKILL_TYPE = Queries
            .createTableQuery(TABLE_SKILL_TYPE, TABLE_SKILL_TYPE_FIELDS,
                    TABLE_SKILL_TYPE_DATATYPE, TABLE_SKILL_TYPE_INDEX);
    /* CLUB */
    public static final String TABLE_CLUB = "Club";
    public static final String DROP_TABLE_CLUB = "DROP TABLE IF EXISTS "
            + TABLE_CLUB;
    public static final String[] TABLE_CLUB_FIELDS = {"id",
            "idClubFacilities", "idBudget", "idSponsors", "clubName",
            "clubReputation"};
    public static final String INSERT_TABLE_CLUB = Queries.insertFieldsQuery(
            TABLE_CLUB, TABLE_CLUB_FIELDS);
    public static final String[] TABLE_CLUB_DATATYPE = {"INTEGER PRIMARY KEY",
            "INTEGER REFERENCES Stadium", "INTEGER REFERENCES ClubFacilities",
            "INTEGER REFERENCES Budget", "INTEGER REFERENCES Sponsors", "TEXT",
            "INTEGER"};
    public static final String[] TABLE_CLUB_INDEX = null;
    public static final String CREATE_TABLE_CLUB = Queries.createTableQuery(
            TABLE_CLUB, TABLE_CLUB_FIELDS, TABLE_CLUB_DATATYPE,
            TABLE_CLUB_INDEX);
    /* STADIUM */
    public static final String TABLE_STADIUM = "Stadium";
    public static final String DROP_TABLE_STADIUM = "DROP TABLE IF EXISTS "
            + TABLE_STADIUM;
    public static final String[] TABLE_STADIUM_FIELDS = {"id", "stadiumName",
            "stadiumCapacity"};
    public static final String INSERT_TABLE_STADIUM = Queries
            .insertFieldsQuery(TABLE_STADIUM, TABLE_STADIUM_FIELDS);
    public static final String[] TABLE_STADIUM_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT", "INTEGER"};
    public static final String[] TABLE_STADIUM_INDEX = null;
    public static final String CREATE_TABLE_STADIUM = Queries.createTableQuery(
            TABLE_STADIUM, TABLE_STADIUM_FIELDS, TABLE_STADIUM_DATATYPE,
            TABLE_STADIUM_INDEX);
    /* CLUB FACILITIES */
    public static final String TABLE_CLUB_FACILITIES = "ClubFacilities";
    public static final String DROP_TABLE_CLUB_FACILITIES = "DROP TABLE IF EXISTS "
            + TABLE_CLUB_FACILITIES;
    public static final String[] TABLE_CLUB_FACILITIES_FIELDS = {"id",
            "idStadiumFk", "office", "trainingBase", "physioBase"};
    public static final String INSERT_TABLE_CLUB_FACILITIES = Queries
            .insertFieldsQuery(TABLE_CLUB_FACILITIES,
                    TABLE_CLUB_FACILITIES_FIELDS);
    public static final String[] TABLE_CLUB_FACILITIES_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES Stadium", "INTEGER",
            "INTEGER", "INTEGER"};
    public static final String[] TABLE_CLUB_FACILITIES_INDEX = null;
    public static final String CREATE_TABLE_CLUB_FACILITIES = Queries
            .createTableQuery(TABLE_CLUB_FACILITIES,
                    TABLE_CLUB_FACILITIES_FIELDS,
                    TABLE_CLUB_FACILITIES_DATATYPE, TABLE_CLUB_FACILITIES_INDEX);
    /* CLUB BUDGET */
    public static final String TABLE_CLUB_BUDGET = "ClubBudget";
    public static final String DROP_TABLE_CLUB_BUDGET = "DROP TABLE IF EXISTS "
            + TABLE_CLUB_BUDGET;
    public static final String[] TABLE_CLUB_BUDGET_FIELDS = {"id",
            "idBudgetTypeFk", "lastSeasonIncome", "lastSeasonOutcome",
            "lastMonthIncome", "lastMonthOutcome", "income", "outcome"};
    public static final String INSERT_TABLE_CLUB_BUDGET = Queries
            .insertFieldsQuery(TABLE_CLUB_BUDGET, TABLE_CLUB_BUDGET_FIELDS);
    public static final String[] TABLE_CLUB_BUDGET_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES BudgetType", "INTEGER",
            "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER"};
    public static final String[] TABLE_CLUB_BUDGET_INDEX = null;
    public static final String CREATE_TABLE_CLUB_BUDGET = Queries
            .createTableQuery(TABLE_CLUB_BUDGET, TABLE_CLUB_BUDGET_FIELDS,
                    TABLE_CLUB_BUDGET_DATATYPE, TABLE_CLUB_BUDGET_INDEX);
    /* CLUB BUDGET TYPE */
    public static final String TABLE_CLUB_BUDGET_TYPE = "ClubBudgetType";
    public static final String DROP_TABLE_CLUB_BUDGET_TYPE = "DROP TABLE IF EXISTS "
            + TABLE_CLUB_BUDGET_TYPE;
    public static final String[] TABLE_CLUB_BUDGET_TYPE_FIELDS = {"id",
            "budgetTypeDesc"};
    public static final String INSERT_TABLE_CLUB_BUDGET_TYPE = Queries
            .insertFieldsQuery(TABLE_CLUB_BUDGET_TYPE,
                    TABLE_CLUB_BUDGET_TYPE_FIELDS);
    public static final String[] TABLE_CLUB_BUDGET_TYPE_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_CLUB_BUDGET_TYPE_INDEX = null;
    public static final String CREATE_TABLE_CLUB_BUDGET_TYPE = Queries
            .createTableQuery(TABLE_CLUB_BUDGET_TYPE,
                    TABLE_CLUB_BUDGET_TYPE_FIELDS, TABLE_CLUB_BUDGET_DATATYPE,
                    TABLE_CLUB_BUDGET_TYPE_INDEX);
    /* SPONSORS */
    public static final String TABLE_SPONSORS = "Sponsors";
    public static final String DROP_TABLE_SPONSORS = "DROP TABLE IF EXISTS "
            + TABLE_SPONSORS;
    public static final String[] TABLE_SPONSORS_FIELDS = {"id", "sponsorName",
            "sponsorContractValue", "sponsorsContractEnd"};
    public static final String INSERT_TABLE_SPONSORS = Queries
            .insertFieldsQuery(TABLE_SPONSORS, TABLE_SPONSORS_FIELDS);
    public static final String[] TABLE_SPONSORS_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "TEXT"};
    public static final String[] TABLE_SPONSORS_INDEX = null;
    public static final String CREATE_TABLE_SPONSORS = Queries
            .createTableQuery(TABLE_SPONSORS, TABLE_SPONSORS_FIELDS,
                    TABLE_SPONSORS_DATATYPE, TABLE_SPONSORS_INDEX);
    /* COMPETITION */
    public static final String TABLE_COMPETITION = "Competition";
    public static final String DROP_TABLE_COMPETITION = "DROP TABLE IF EXISTS "
            + TABLE_COMPETITION;
    public static final String[] TABLE_COMPETITION_FIELDS = {"id",
            "competitionName"};
    public static final String INSERT_TABLE_COMPETITION = Queries
            .insertFieldsQuery(TABLE_COMPETITION, TABLE_COMPETITION_FIELDS);
    public static final String[] TABLE_COMPETITION_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_COMPETITION_INDEX = null;
    public static final String CREATE_TABLE_COMPETITION = Queries
            .createTableQuery(TABLE_COMPETITION, TABLE_COMPETITION_FIELDS,
                    TABLE_COMPETITION_DATATYPE, TABLE_COMPETITION_INDEX);
    /* MATCH DAY */
    public static final String TABLE_MATCHDAY = "MatchDay";
    public static final String DROP_TABLE_MATCHDAY = "DROP TABLE IF EXISTS "
            + TABLE_MATCHDAY;
    public static final String[] TABLE_MATCHDAY_FIELDS = {"id", "idStadiumFk",
            "idClubFk", "idCompetitionFk", "matchDate", "golHTHome",
            "golHTAway", "golFTHome", "golFTAway", "golPenaltyHome",
            "golPenaltyAway", "matchCapacity"};

    /*
     * *************************************************
     * 
     * CREATE QUERIES
     * 
     * **************************************************
     */
    public static final String INSERT_TABLE_MATCHDAY = Queries
            .insertFieldsQuery(TABLE_MATCHDAY, TABLE_MATCHDAY_FIELDS);
    public static final String[] TABLE_MATCHDAY_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES Stadium",
            "INTEGER REFERENCES Club", "INTEGER REFERENCES Competition",
            "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER",
            "INTEGER", "INTEGER"};
    public static final String[] TABLE_MATCHDAY_INDEX = null;
    public static final String CREATE_TABLE_MATCHDAY = Queries
            .createTableQuery(TABLE_MATCHDAY, TABLE_MATCHDAY_FIELDS,
                    TABLE_MATCHDAY_DATATYPE, TABLE_MATCHDAY_INDEX);
    /* MATCH EVENT */
    public static final String TABLE_MATCH_EVENT = "MatchEvent";
    public static final String DROP_TABLE_MATCH_EVENT = "DROP TABLE IF EXISTS "
            + TABLE_MATCH_EVENT;
    public static final String[] TABLE_MATCH_EVENT_FIELDS = {"id",
            "idMatchDayFk", "idMatchEventTypeFk", "idPersonFk", "eventTime"};
    public static final String INSERT_TABLE_MATCH_EVENT = Queries
            .insertFieldsQuery(TABLE_MATCH_EVENT, TABLE_MATCH_EVENT_FIELDS);
    public static final String[] TABLE_MATCH_EVENT_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES MatchDay",
            "INTEGER REFERENCES MatchEventType", "INTEGER REFERENCES Person",
            "INTEGER"};
    public static final String[] TABLE_MATCH_EVENT_INDEX = null;
    public static final String CREATE_TABLE_MATCH_EVENT = Queries
            .createTableQuery(TABLE_MATCH_EVENT, TABLE_MATCH_EVENT_FIELDS,
                    TABLE_MATCH_EVENT_DATATYPE, TABLE_MATCH_EVENT_INDEX);
    /* MATCH EVENT TYPE */
    public static final String TABLE_MATCH_EVENT_TYPE = "MatchEventType";
    public static final String DROP_TABLE_MATCH_EVENT_TYPE = "DROP TABLE IF EXISTS "
            + TABLE_MATCH_EVENT_TYPE;
    public static final String[] TABLE_MATCH_EVENT_TYPE_FIELDS = {"id",
            "MatchEventTypeName"};
    public static final String INSERT_TABLE_MATCH_EVENT_TYPE = Queries
            .insertFieldsQuery(TABLE_MATCH_EVENT_TYPE,
                    TABLE_MATCH_EVENT_TYPE_FIELDS);
    public static final String[] TABLE_MATCH_EVENT_TYPE_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_MATCH_EVENT_TYPE_INDEX = null;
    public static final String CREATE_TABLE_MATCH_EVENT_TYPE = Queries
            .createTableQuery(TABLE_MATCH_EVENT_TYPE,
                    TABLE_MATCH_EVENT_TYPE_FIELDS,
                    TABLE_MATCH_EVENT_TYPE_DATATYPE,
                    TABLE_MATCH_EVENT_TYPE_INDEX);
    /* CLUB FIXTURES */
    public static final String TABLE_CLUB_FIXTURES = "ClubFixtures";
    public static final String DROP_TABLE_CLUB_FIXTURES = "DROP TABLE IF EXISTS "
            + TABLE_CLUB_FIXTURES;

    /*
     * *************************************************
     * 
     * INSERT QUERIES
     * 
     * **************************************************
     */
    public static final String[] TABLE_CLUB_FIXTURES_FIELDS = {"id",
            "idClubFk", "idSeasonFk", "idMatchDayFk"};
    public static final String INSERT_TABLE_CLUB_FIXTURES = Queries
            .insertFieldsQuery(TABLE_CLUB_FIXTURES, TABLE_CLUB_FIXTURES_FIELDS);
    public static final String[] TABLE_CLUB_FIXTURES_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES Club",
            "INTEGER REFERENCES Season", "INTEGER REFERENCES MatchDay"};
    public static final String[] TABLE_CLUB_FIXTURES_INDEX = null;
    public static final String CREATE_TABLE_CLUB_FIXTURES = Queries
            .createTableQuery(TABLE_CLUB_FIXTURES, TABLE_CLUB_FIXTURES_FIELDS,
                    TABLE_CLUB_FIXTURES_DATATYPE, TABLE_CLUB_FIXTURES_INDEX);
    /* SEASON */
    public static final String TABLE_SEASON = "Season";
    public static final String DROP_TABLE_SEASON = "DROP TABLE IF EXISTS "
            + TABLE_SEASON;
    public static final String[] TABLE_SEASON_FIELDS = {"id", "seasonName"};
    public static final String INSERT_TABLE_SEASON = Queries.insertFieldsQuery(
            TABLE_SEASON, TABLE_SEASON_FIELDS);
    public static final String[] TABLE_SEASON_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_SEASON_INDEX = null;
    public static final String CREATE_TABLE_SEASON = Queries.createTableQuery(
            TABLE_SEASON, TABLE_SEASON_FIELDS, TABLE_SEASON_DATATYPE,
            TABLE_SEASON_INDEX);
    /* MATCH COMMENT */
    public static final String TABLE_MATCH_COMMENT = "MatchComment";
    public static final String DROP_TABLE_MATCH_COMMENT = "DROP TABLE IF EXISTS "
            + TABLE_MATCH_COMMENT;
    public static final String[] TABLE_MATCH_COMMENT_FIELDS = {"id",
            "idMatchDayFk", "idCommentTypeFk", "time"};
    public static final String INSERT_TABLE_MATCH_COMMENT = Queries
            .insertFieldsQuery(TABLE_MATCH_COMMENT, TABLE_MATCH_COMMENT_FIELDS);
    public static final String[] TABLE_MATCH_COMMENT_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES MatchDay",
            "INTEGER REFERENCES CommentType", "INTEGER"};
    public static final String[] TABLE_MATCH_COMMENT_INDEX = null;
    public static final String CREATE_TABLE_MATCH_COMMENT = Queries
            .createTableQuery(TABLE_MATCH_COMMENT, TABLE_MATCH_COMMENT_FIELDS,
                    TABLE_MATCH_COMMENT_DATATYPE, TABLE_MATCH_COMMENT_INDEX);
    /* MATCH COMMENT TYPE */
    public static final String TABLE_COMMENT_TYPE = "CommentType";

    /*
     * *************************************************
     * 
     * DROP TABLE QUERY
     * 
     * **************************************************
     */
    public static final String DROP_TABLE_COMMENT_TYPE = "DROP TABLE IF EXISTS "
            + TABLE_COMMENT_TYPE;
    public static final String[] TABLE_COMMENT_TYPE_FIELDS = {"id", "comment"};
    public static final String INSERT_TABLE_COMMENT_TYPE = Queries
            .insertFieldsQuery(TABLE_COMMENT_TYPE, TABLE_COMMENT_TYPE_FIELDS);
    public static final String[] TABLE_COMMENT_TYPE_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_COMMENT_TYPE_INDEX = null;
    public static final String CREATE_TABLE_COMMENT_TYPE = Queries
            .createTableQuery(TABLE_COMMENT_TYPE, TABLE_COMMENT_TYPE_FIELDS,
                    TABLE_COMMENT_TYPE_DATATYPE, TABLE_COMMENT_TYPE_INDEX);
    /* MATCH SQUAD */
    public static final String TABLE_MATCH_SQUAD = "MatchSquad";
    public static final String DROP_TABLE_MATCH_SQUAD = "DROP TABLE IF EXISTS "
            + TABLE_MATCH_SQUAD;
    public static final String[] TABLE_MATCH_SQUAD_FIELDS = {"id",
            "idPlayerMatchPositionFk", "idClubFk", "idPersonFk", "idMatchDayFk"};
    public static final String INSERT_TABLE_MATCH_SQUAD = Queries
            .insertFieldsQuery(TABLE_MATCH_SQUAD, TABLE_MATCH_SQUAD_FIELDS);
    public static final String[] TABLE_MATCH_SQUAD_DATATYPE = {
            "INTEGER PRIMARY KEY", "INTEGER REFERENCES PlayerMatchPosition",
            "INTEGER REFERENCES Club", "INTEGER REFERENCES Person",
            "INTEGER REFERENCES MatchDay"};
    public static final String[] TABLE_MATCH_SQUAD_INDEX = null;
    public static final String CREATE_TABLE_MATCH_SQUAD = Queries
            .createTableQuery(TABLE_MATCH_SQUAD, TABLE_MATCH_SQUAD_FIELDS,
                    TABLE_MATCH_SQUAD_DATATYPE, TABLE_MATCH_SQUAD_INDEX);
    /* PLAYED MATCH POSITOIN */
    public static final String TABLE_PLAYER_MATCH_POSITION = "PlayerMatchPosition";
    public static final String DROP_TABLE_PLAYER_MATCH_POSITION = "DROP TABLE IF EXISTS "
            + TABLE_PLAYER_MATCH_POSITION;
    public static final String[] TABLE_PLAYER_MATCH_POSITION_FIELDS = {"id",
            "playerPosition"};
    public static final String INSERT_TABLE_PLAYER_MATCH_POSITION = Queries
            .insertFieldsQuery(TABLE_PLAYER_MATCH_POSITION,
                    TABLE_PLAYER_MATCH_POSITION_FIELDS);
    public static final String[] TABLE_PLAYER_MATCH_POSITION_DATATYPE = {
            "INTEGER PRIMARY KEY", "TEXT"};
    public static final String[] TABLE_PLAYER_MATCH_POSITION_INDEX = null;
    public static final String CREATE_TABLE_PLAYER_MATCH_POSITION = Queries
            .createTableQuery(TABLE_PLAYER_MATCH_POSITION,
                    TABLE_PLAYER_MATCH_POSITION_FIELDS,
                    TABLE_PLAYER_MATCH_POSITION_DATATYPE,
                    TABLE_PLAYER_MATCH_POSITION_INDEX);

    /*
     * *************************************************
     * 
     * ARRAYS
     * 
     * **************************************************
     */
    public static String[] JOBS = {"player", "coach", "physio", "scout"};
    public static String[] PLAYER_ATTRIBUTES = {"preferredPosition",
            "condition", "injury", "suspention"};
    public static String[] PLAYER_ATTRIBUTES_SKILLS = {"tackling", "heading",
            "marking", "crossing", "passing", "creativity", "technique",
            "finishing", "strenght", "jumping", "goalkeeping"};
    public static String[] LEAGUES = {"Premier League", "Championship",
            "League One", "League Two", "Conference"};
    public static String[] PREMIER_LEAGUE_CLUBS = {"Manchester City",
            "Liverpool", "Chelsea", "Arsenal", "Everton", "Tottenham",
            "Manchester Utd", "Southampton", "Newcastle", "Stoke ",
            "Crystal Palace", "West Ham", "Swansea", "Aston Villa", "Hull ",
            "West Brom", "Sunderland", "Norwich", "Fulham", "Cardiff"};

}
