package pl.arnea.footballadventuremanager.ui;

import android.app.ListActivity;
import android.os.Bundle;
import pl.arnea.footballadventuremanager.adapters.FixtureListAdapter;
import pl.arnea.footballadventuremanager.vars.GlobalData;

public class CompetitionFixtureListActivity extends ListActivity {

    String homeTeam;
    String awayTeam;
    int item = 0;
    private FixtureListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mAdapter = new FixtureListAdapter(this);

        for (int l = 1; l <= 34; l++) {
            for (int x = 0; x < 8; x++) {
                if (item % 8 == 0) {
                    mAdapter.addSectionHeaderItem("Round nr. " + l);
                }
                homeTeam = GlobalData.fixtures.get(item).getHomeTeam().getName().toString();
                awayTeam = GlobalData.fixtures.get(item).getAwayTeam().getName().toString();
                mAdapter.addItem(homeTeam + " - " + awayTeam);

                item++;
            }
        }
        setListAdapter(mAdapter);
    }

}
