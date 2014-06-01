package pl.arnea.footballadventuremanager.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.database.DatabaseHandler;
import pl.arnea.footballadventuremanager.database.GenerateNewData;

public class DBTEST extends Activity {

    final String TAG = "MainActivityNavi.java";
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbtest_activity);

        tvStatus = (TextView) findViewById(R.id.textViewStatus);
        new AsyncInsertData().execute();

    }

    // we used AsyncTask so it won't block the UI thread during inserts.
    class AsyncInsertData extends AsyncTask<String, String, String> {

        DatabaseHandler databaseHandler;
        GenerateNewData pa;

        long timeElapsed;

        protected AsyncInsertData() {
            this.databaseHandler = new DatabaseHandler(DBTEST.this);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvStatus.setText("Creating new game... please wait.");
        }

        @Override
        protected String doInBackground(String... aurl) {

            try {
                pa = new GenerateNewData(DBTEST.this);
                pa.generateNewData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String unused) {
            tvStatus.setText("Done inserting records.");
        }

    }

}