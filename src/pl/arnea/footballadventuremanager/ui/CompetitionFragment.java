package pl.arnea.footballadventuremanager.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import pl.arnea.footballadventuremanager.R;

public class CompetitionFragment extends Fragment {

    Button fixtures;
    Button leagueTable;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.competition_fragment, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        //get the button view
        fixtures = (Button) getView().findViewById(R.id.fixture);
        //set a onclick listener for when the button gets clicked
        fixtures.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(), CompetitionFixtureListActivity.class);
                startActivity(mainIntent);
            }
        });

    }


}