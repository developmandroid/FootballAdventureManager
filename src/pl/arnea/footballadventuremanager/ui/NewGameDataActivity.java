package pl.arnea.footballadventuremanager.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.gen.NewGameCreator;

public class NewGameDataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_data_activity);
        NewGameCreator newGame = new NewGameCreator();
        newGame.createNewClubs();
        newGame.createNewLeagues();
        newGame.createNewLeagueFixtures();

        Intent intent = new Intent(this, NewGameWizardActivity.class);
        startActivity(intent);


    }


}
