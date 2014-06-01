package pl.arnea.footballadventuremanager.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.ui.CompetitionFragment;
import pl.arnea.footballadventuremanager.ui.StartGameMenuActivity;
import pl.arnea.footballadventuremanager.ui.TeamPlayerListActivity;
import pl.arnea.footballadventuremanager.ui.TeamTacticsActivity;


public class SlideMenuFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] colors = getResources().getStringArray(R.array.color_names);
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, colors);
        setListAdapter(colorAdapter);
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {
        Fragment newContent = null;
        switch (position) {
            case 0:
                newContent = new TeamPlayerListActivity();
                break;
            case 1:
                newContent = new TeamTacticsActivity();
                break;
            case 2:
                newContent = new CompetitionFragment();
                break;
            case 3:
                Intent intent = new Intent(getActivity(), StartGameMenuActivity.class);
                startActivity(intent);
                break;
            case 4:
                newContent = new ColorFragment(android.R.color.black);
                break;
        }
        if (newContent != null)
            switchFragment(newContent);
    }

    // the meat of switching the above fragment
    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        if (getActivity() instanceof FragmentChangeActivity) {
            FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
            fca.switchContent(fragment);

        }
    }


}
