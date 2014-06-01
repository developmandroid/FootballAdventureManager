package pl.arnea.footballadventuremanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import pl.arnea.footballadventuremanager.vars.DbVars;

public class DatabaseHandler extends SQLiteOpenHelper {

    protected static final String DATABASE_NAME = "ok";
    private static final int DATABASE_VERSION = 24;
    public static String TAG = "DatabaseHandler.java";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // creating table
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DbVars.CREATE_TABLE_PERSON);
        db.execSQL(DbVars.CREATE_TABLE_PERSON_JOB);
        db.execSQL(DbVars.CREATE_TABLE_SKILL_TYPE);
        db.execSQL(DbVars.CREATE_TABLE_PERSON_HAS_SKILL);

        db.execSQL(DbVars.CREATE_TABLE_MATCH_SQUAD);
        db.execSQL(DbVars.CREATE_TABLE_PLAYER_MATCH_POSITION);

        db.execSQL(DbVars.CREATE_TABLE_CLUB);
        db.execSQL(DbVars.CREATE_TABLE_STADIUM);
        db.execSQL(DbVars.CREATE_TABLE_CLUB_FACILITIES);
        db.execSQL(DbVars.CREATE_TABLE_CLUB_BUDGET);
        db.execSQL(DbVars.CREATE_TABLE_CLUB_BUDGET_TYPE);
        db.execSQL(DbVars.CREATE_TABLE_SPONSORS);

        db.execSQL(DbVars.CREATE_TABLE_MATCHDAY);
        db.execSQL(DbVars.CREATE_TABLE_MATCH_EVENT);
        db.execSQL(DbVars.CREATE_TABLE_MATCH_EVENT_TYPE);
        db.execSQL(DbVars.CREATE_TABLE_CLUB_FIXTURES);
        db.execSQL(DbVars.CREATE_TABLE_SEASON);
        db.execSQL(DbVars.CREATE_TABLE_MATCH_COMMENT);
        db.execSQL(DbVars.CREATE_TABLE_COMMENT_TYPE);

        db.execSQL(DbVars.CREATE_TABLE_COMPETITION);

    }

    // When upgrading the database, it will drop the current table and recreate.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DbVars.DROP_TABLE_PERSON);
        db.execSQL(DbVars.DROP_TABLE_PERSON_JOB);
        db.execSQL(DbVars.DROP_TABLE_PERSON_HAS_SKILL);
        db.execSQL(DbVars.DROP_TABLE_SKILL_TYPE);

        db.execSQL(DbVars.DROP_TABLE_MATCH_SQUAD);
        db.execSQL(DbVars.DROP_TABLE_PLAYER_MATCH_POSITION);

        db.execSQL(DbVars.DROP_TABLE_CLUB);
        db.execSQL(DbVars.DROP_TABLE_STADIUM);
        db.execSQL(DbVars.DROP_TABLE_CLUB_FACILITIES);
        db.execSQL(DbVars.DROP_TABLE_CLUB_BUDGET);
        db.execSQL(DbVars.DROP_TABLE_CLUB_BUDGET_TYPE);
        db.execSQL(DbVars.DROP_TABLE_SPONSORS);

        db.execSQL(DbVars.DROP_TABLE_MATCHDAY);
        db.execSQL(DbVars.DROP_TABLE_MATCH_EVENT);
        db.execSQL(DbVars.DROP_TABLE_MATCH_EVENT_TYPE);
        db.execSQL(DbVars.DROP_TABLE_CLUB_FIXTURES);
        db.execSQL(DbVars.DROP_TABLE_SEASON);
        db.execSQL(DbVars.DROP_TABLE_MATCH_COMMENT);
        db.execSQL(DbVars.DROP_TABLE_COMMENT_TYPE);

        db.execSQL(DbVars.DROP_TABLE_COMPETITION);

        onCreate(db);
    }

}