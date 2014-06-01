package pl.arnea.footballadventuremanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import pl.arnea.footballadventuremanager.vars.DbVars;

import java.util.Random;

public class GenerateNewData {

    DatabaseHandler dbHandler;
    SQLiteDatabase db;
    Random generator = new Random();

    public GenerateNewData(Context context) {
        dbHandler = new DatabaseHandler(context);

    }

    public void openTransaction() {
        db = dbHandler.getWritableDatabase();
        db.beginTransactionNonExclusive();

    }
/*
    public void generateClub(String[] club) {
	SQLiteStatement dbData = db.compileStatement(DbVars.INSERT_TABLE_CLUB);
	for (int i = 1; i < club.length; i++) {
	    dbData.bindString(i, CLUB_PROTOTYPE[i].toString());
	}
	
	dbData.execute();
	dbData.clearBindings();

    }
*/
    
    /*
     * *************************************************
     * 
     * CREATE PERSON
     * 
     * **************************************************
     */

    public void generatePerson(Integer idClub, Integer idPersonJob,
                               String firstName, String lastName, String nationality,
                               String birth, String endContract, Integer contractValue,
                               Integer morale, Integer reputation, Integer height, Integer weight) {

        SQLiteStatement dbData = db
                .compileStatement(DbVars.INSERT_TABLE_PERSON);

        dbData.bindString(1, idClub.toString());
        dbData.bindString(2, idPersonJob.toString());
        dbData.bindString(3, firstName);
        dbData.bindString(4, lastName);
        dbData.bindString(5, nationality);
        dbData.bindString(6, birth);
        dbData.bindString(7, endContract);
        dbData.bindString(8, contractValue.toString());
        dbData.bindString(9, morale.toString());
        dbData.bindString(10, reputation.toString());
        dbData.bindString(11, height.toString());
        dbData.bindString(12, weight.toString());
        dbData.execute();
        dbData.clearBindings();

    }

    public void generatePersonJob(String personJobType) {

        SQLiteStatement playerData = db
                .compileStatement(DbVars.INSERT_TABLE_PERSON_JOB);

        playerData.bindString(1, personJobType);
        playerData.execute();
        playerData.clearBindings();

    }

    public void generatePersonSkills(int idPerson, int idSkillType,
                                     int skillValue) {

        SQLiteStatement playerSkillsData = db
                .compileStatement(DbVars.INSERT_TABLE_PERSON_HAS_SKILL);

        playerSkillsData.bindString(1, Integer.toString(idPerson));
        playerSkillsData.bindString(2, Integer.toString(idSkillType));
        playerSkillsData.bindString(3, Integer.toString(skillValue));
        playerSkillsData.execute();
        playerSkillsData.clearBindings();

    }

    public void generateSkillType(String skillType) {

        SQLiteStatement skillTypeData = db
                .compileStatement(DbVars.INSERT_TABLE_SKILL_TYPE);

        skillTypeData.bindString(1, skillType);
        skillTypeData.execute();
        skillTypeData.clearBindings();

    }

    /*
     * *************************************************
     * 
     * GENERATE
     * 
     * **************************************************
     */

    public void generateNewData() {

        openTransaction();

	/*
     * GENERATE CLUBS
	 */

        //for (int i = 0; i < DbVars.CLUBS.length; i++) {
        //    generateClub(DbVars.CLUBS[i]);

        //}

        // generate jobs
        for (int i = 0; i < DbVars.JOBS.length; i++) {
            generatePersonJob(DbVars.JOBS[i]);
        }

        // generate skill type
        for (int i = 0; i < DbVars.PLAYER_ATTRIBUTES.length; i++) {
            generateSkillType(DbVars.PLAYER_ATTRIBUTES[i]);
        }

        int allPlayerNumber = 0;
        // generate Players
        for (int club = 1; club <= 20; club++) {
            for (int playerNr = 1; playerNr <= 20; playerNr++) {
                generatePerson(club, playerNr, "Lukaszek", "Smolarek #"
                                + playerNr, "Polska", "12-10-1982", "12-10-2018",
                        100000, 100, 20, 168, 79
                );
                allPlayerNumber++;

            }

        }

        for (int playerNr = 1; playerNr <= allPlayerNumber; playerNr++) {

            for (int skillNr = 0; skillNr <= DbVars.PLAYER_ATTRIBUTES.length; skillNr++) {
                int skill = generator.nextInt(100) + 1;
                generatePersonSkills(playerNr, skillNr, skill);
            }

        }

        db.setTransactionSuccessful();
        db.endTransaction();

        db.close();

    }

    public void deleteRecords() {

        SQLiteDatabase db = dbHandler.getWritableDatabase();

        // db.execSQL("delete from " + TABLE_PERSON);
        db.close();
    }

}
