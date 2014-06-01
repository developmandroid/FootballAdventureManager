package pl.arnea.footballadventuremanager.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.adapters.TeamPlayerListAdapter;
import pl.arnea.footballadventuremanager.vars.GlobalData;
import pl.arnea.footballadventuremanager.views.DragListView;

public class TeamPlayerListActivity extends Fragment {

    DragListView list;
    TeamPlayerListAdapter playerListAdapter;

    public TeamPlayerListActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        return inflater.inflate(R.layout.team_squad_player_list_activity, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        Resources res = getResources();
        list = (DragListView) getView().findViewById(R.id.playerList);
        playerListAdapter = new TeamPlayerListAdapter(getActivity(), GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamPlayers(), res);
        list.setLongClickable(true);
        list.setAdapter(playerListAdapter);

    }


}
