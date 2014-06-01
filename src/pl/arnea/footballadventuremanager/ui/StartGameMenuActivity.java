package pl.arnea.footballadventuremanager.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import pl.arnea.footballadventuremanager.R;

public class StartGameMenuActivity extends Activity implements OnClickListener {

    Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game_menu_activity);
        newGame = (Button) findViewById(R.id.btn_newGame);
        newGame.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg) {
        Intent intent = new Intent(this, NewGameDataActivity.class);
        startActivity(intent);
    }

}
