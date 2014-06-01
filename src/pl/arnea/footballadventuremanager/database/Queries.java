package pl.arnea.footballadventuremanager.database;

import android.util.Log;

public class Queries {

    /*
     * *************************************************
     * 
     * CREATE_TABLE QUERY
     * 
     * **************************************************
     */

    public static String createTableQuery(String tableName,
                                          String[] tableFields, String[] tableFieldsDatatypes, String[] index) {
        StringBuffer query = new StringBuffer("CREATE TABLE ");
        query.append(tableName);
        query.append(" (");
        query.append(tableFields[0]);
        query.append(" ");
        query.append(tableFieldsDatatypes[0]);

        for (int i = 1; i < tableFields.length; i++) {
            query.append(", ");
            query.append(tableFields[i]);
            query.append(" ");
            query.append(tableFieldsDatatypes[i]);

        }

        if (index != null) {
            // TODO INDEX
        } else {
            query.append(");");
        }

        Log.i("FMA", "Create Query: " + query.toString());

        return query.toString();
    }

    /*
     * *************************************************
     * 
     * DATABASE INSERTS START DATA QUERY
     * 
     * **************************************************
     */

    public static String insertFieldsQuery(String tableName, String[] tableFields) {
        StringBuffer query = new StringBuffer("INSERT OR REPLACE INTO ");
        query.append(tableName);
        query.append(" (");
        if (tableFields[0].equals("id")) {
            query.append(tableFields[1]);

        } else {

            query.append(tableFields[0]);
            query.append(", ");
            query.append(tableFields[1]);

        }

        if (tableFields.length > 0) {
            for (int i = 2; i < tableFields.length; i++) {
                query.append(", ");
                query.append(tableFields[i]);

            }
        }
        query.append(")");
        query.append(" VALUES (");
        if (tableFields[0].equals("id")) {
            query.append("?");
        } else {
            query.append("?");
            query.append(", ");
            query.append("?");

        }

        for (int i = 2; i < tableFields.length; i++) {
            query.append(", ");
            query.append("?");

        }
        query.append(");");
        Log.i("FMA", "Insert Query: " + query.toString());

        return query.toString();

    }

}
