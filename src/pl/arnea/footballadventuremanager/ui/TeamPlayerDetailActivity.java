package pl.arnea.footballadventuremanager.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.vars.GlobalData;

/**
 * Created by Arnea on 19.05.14.
 */
public class TeamPlayerDetailActivity extends Activity {
    int ex;
    TextView playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_squad_player_detail_activity);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ex = extras.getInt("choosenPlayer");
        }


        String name = GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamPlayers().get(ex).getName().toString();
        playerName = (TextView) findViewById(R.id.playerName);
        playerName.setText(name);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_game_setup, menu);
        return true;
    }
}