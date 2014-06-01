package pl.arnea.footballadventuremanager.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.models.person.Player;
import pl.arnea.footballadventuremanager.models.person.PlayerPosition;
import pl.arnea.footballadventuremanager.vars.GlobalData;
import pl.arnea.footballadventuremanager.views.DragListView;

import java.util.List;

public class TeamPlayerListAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    List<PlayerPosition> tactics;
    Player tempValues;
    private Context activity;
    private List<Player> data;
    private LayoutInflater inflater;
    private Resources res;

    public TeamPlayerListAdapter(Context activity, List<Player> data, Resources res) {
        this.activity = activity;
        this.data = data;
        this.res = res;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Player> getAllList() {

        return this.data;
    }


    public void setAllList(List<Player> data) {
        this.data = data;

    }

    @Override
    public int getCount() {
        if (data.size() <= 0)
            return 1;
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        tactics = GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamTactics().getTactics();


        if (convertView == null) {
            view = inflater.inflate(R.layout.team_squad_player_list_row, null);

            holder = new ViewHolder();

            holder.textPos = (TextView) view.findViewById(R.id.textPos);
            holder.text = (TextView) view.findViewById(R.id.textDrag);
            holder.text1 = (TextView) view.findViewById(R.id.text1);
            view.setTag(holder);

        } else {

            if (view.getAlpha() == 0) {
                view.setAlpha(1);
            }
            if (position == DragListView.posChoosen) {
                if (view.getAlpha() == 1) {
                    view.setAlpha(0);
                }
            }

            holder = (ViewHolder) view.getTag();

        }

        if (data.size() <= 0) {
            holder.text.setText("No Data");

        } else {
            tempValues = null;
            tempValues = data.get(position);


            if (position < 11) {
                String pos1 = tactics.get(position).toString();
                String pos2 = tempValues.getPreferredPosition().toString();
                if (pos1.equals(pos2)) {
                    holder.textPos.setTextColor(Color.WHITE);
                    holder.textPos.setText(tactics.get(position).toString());
                } else {
                    holder.textPos.setTextColor(Color.RED);
                    holder.textPos.setText(tactics.get(position).toString());
                }
            } else {
                holder.textPos.setTextColor(Color.GREEN);
                holder.textPos.setText("RES");
            }

            holder.text.setText(tempValues.getName().toString());
            holder.text1.setText(tempValues.getPreferredPosition().toString());


            /******** Set Item Click Listner for LayoutInflater for each row *******/


        }
        return view;


    }

    public void swapItems() {

    }

    public static class ViewHolder {

        public TextView text;
        public TextView text1;
        public TextView textPos;
    }


}
