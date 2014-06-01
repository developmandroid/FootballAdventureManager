package pl.arnea.footballadventuremanager.ui;


import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.models.club.Team;
import pl.arnea.footballadventuremanager.models.person.Player;
import pl.arnea.footballadventuremanager.models.person.PlayerPosition;
import pl.arnea.footballadventuremanager.vars.GlobalData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamTacticsActivity extends Fragment {

    List<Player> teamPlayers = GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamPlayers();
    List<LinearLayout> positions = new ArrayList<LinearLayout>();
    List<Player> tacticsPosition = new ArrayList<Player>();
    int dragTeamId;
    int dropTeamId;
    Team firstTeam;
    List<PlayerPosition> firstTeamTactics;
    private LinearLayout gk, def1, def2, def3, def4, def5, midDef1, midDef2, midDef3, midDef4, midDef5,
            mid1, mid2, mid3, mid4, mid5, attMid1, attMid2, attMid3, attMid4, attMid5, att1, att2, att3, att4, att5,
            res1, res2, res3, res4, res5, res6;
    private TextView text1, text2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        return inflater.inflate(R.layout.team_tactics_activity, container, false);
    }


    public void onStart() {
        super.onStart();
        firstTeam = GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam();
        firstTeamTactics = GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamTactics().getTactics();


        //views to drag
        gk = (LinearLayout) getView().findViewById(R.id.gk);
        positions.add(gk);
        def1 = (LinearLayout) getView().findViewById(R.id.def1);
        positions.add(def1);
        def2 = (LinearLayout) getView().findViewById(R.id.def2);
        positions.add(def2);
        def3 = (LinearLayout) getView().findViewById(R.id.def3);
        positions.add(def3);
        def4 = (LinearLayout) getView().findViewById(R.id.def4);
        positions.add(def4);
        def5 = (LinearLayout) getView().findViewById(R.id.def5);
        positions.add(def5);

        midDef1 = (LinearLayout) getView().findViewById(R.id.mdef1);
        positions.add(midDef1);
        midDef2 = (LinearLayout) getView().findViewById(R.id.mdef2);
        positions.add(midDef2);
        midDef3 = (LinearLayout) getView().findViewById(R.id.mdef3);
        positions.add(midDef3);
        midDef4 = (LinearLayout) getView().findViewById(R.id.mdef4);
        positions.add(midDef4);
        midDef5 = (LinearLayout) getView().findViewById(R.id.mdef5);
        positions.add(midDef5);

        mid1 = (LinearLayout) getView().findViewById(R.id.mid1);
        positions.add(mid1);
        mid2 = (LinearLayout) getView().findViewById(R.id.mid2);
        positions.add(mid2);
        mid3 = (LinearLayout) getView().findViewById(R.id.mid3);
        positions.add(mid3);
        mid4 = (LinearLayout) getView().findViewById(R.id.mid4);
        positions.add(mid4);
        mid5 = (LinearLayout) getView().findViewById(R.id.mid5);
        positions.add(mid5);

        attMid1 = (LinearLayout) getView().findViewById(R.id.amid1);
        positions.add(attMid1);
        attMid2 = (LinearLayout) getView().findViewById(R.id.amid2);
        positions.add(attMid2);
        attMid3 = (LinearLayout) getView().findViewById(R.id.amid3);
        positions.add(attMid3);
        attMid4 = (LinearLayout) getView().findViewById(R.id.amid4);
        positions.add(attMid4);
        attMid5 = (LinearLayout) getView().findViewById(R.id.amid5);
        positions.add(attMid5);

        att1 = (LinearLayout) getView().findViewById(R.id.att1);
        positions.add(att1);
        att2 = (LinearLayout) getView().findViewById(R.id.att2);
        positions.add(att2);
        att3 = (LinearLayout) getView().findViewById(R.id.att3);
        positions.add(att3);
        att4 = (LinearLayout) getView().findViewById(R.id.att4);
        positions.add(att4);
        att5 = (LinearLayout) getView().findViewById(R.id.att5);
        positions.add(att5);

        res1 = (LinearLayout) getView().findViewById(R.id.res1);
        positions.add(res1);
        res2 = (LinearLayout) getView().findViewById(R.id.res2);
        positions.add(res2);
        res3 = (LinearLayout) getView().findViewById(R.id.res3);
        positions.add(res3);
        res4 = (LinearLayout) getView().findViewById(R.id.res4);
        positions.add(res4);
        res5 = (LinearLayout) getView().findViewById(R.id.res5);
        positions.add(res5);
        res6 = (LinearLayout) getView().findViewById(R.id.res6);
        positions.add(res6);

        //set listeners
        for (LinearLayout layout : positions) {
            layout.setOnTouchListener(new ChoiceTouchListener());
            layout.setOnDragListener(new ChoiceDragListener());
        }


        fillTacticsPositions();
    }

    public void fillTacticsPositions() {

        //set default
        for (int i = 0; i < 32; i++) {
            positions.get(i).getChildAt(0).setVisibility(View.VISIBLE);
            positions.get(i).getChildAt(1).setVisibility(View.VISIBLE);
            tacticsPosition.add(GlobalData.tempPlayer);
        }


        for (int i = 0; i < 17; i++) {
            tacticsPosition.set(firstTeam.getTeamPlayers().get(i).getSquadPosition(), firstTeam.getTeamPlayers().get(i));


        }


        for (int i = 0; i < 32; i++) {
            if (tacticsPosition.get(i).getId() == -1) {
                positions.get(i).getChildAt(0).setVisibility(View.INVISIBLE);
                positions.get(i).getChildAt(1).setVisibility(View.INVISIBLE);
            }
            TextView textTemp = (TextView) positions.get(i).getChildAt(1);
            textTemp.setText(tacticsPosition.get(i).getName().getLastName().toString());
        }

    }

    public void updateTacticsPositions() {

        for (int i = 0; i < 32; i++) {
            positions.get(i).getChildAt(0).setVisibility(View.VISIBLE);
            positions.get(i).getChildAt(1).setVisibility(View.VISIBLE);
            tacticsPosition.set(i, GlobalData.tempPlayer);
        }


        for (int i = 0; i < 17; i++) {
            tacticsPosition.set(firstTeam.getTeamPlayers().get(i).getSquadPosition(), firstTeam.getTeamPlayers().get(i));


        }


        for (int i = 0; i < 32; i++) {
            if (tacticsPosition.get(i).getId() == -1) {
                positions.get(i).getChildAt(0).setVisibility(View.INVISIBLE);
                positions.get(i).getChildAt(1).setVisibility(View.INVISIBLE);
            }
            TextView textTemp = (TextView) positions.get(i).getChildAt(1);
            textTemp.setText(tacticsPosition.get(i).getName().getLastName().toString());
        }

    }

    public int identyfyPositionId(View v) {

        int temp = 0;
        int positionID = -1;
        for (LinearLayout layout : positions) {
            if (layout.getId() == v.getId()) {
                positionID = temp;
            }

            temp++;
        }


        return positionID;


    }

    public void updateTeamTactics(int dragTeamIdP, int targetIdP) {
        PlayerPosition position = null;

        Log.d("fam", "Position: " + targetIdP);
        if (targetIdP == 0) {
            position = new PlayerPosition(GlobalData.goalkeeperPosName);
        }
        if (targetIdP == 1) {
            position = new PlayerPosition(GlobalData.defPosName, GlobalData.leftSideName);
        }

        if (targetIdP > 1 && targetIdP < 5) {
            position = new PlayerPosition(GlobalData.defPosName, GlobalData.centerSideName);
        }

        if (targetIdP == 5) {
            position = new PlayerPosition(GlobalData.defPosName, GlobalData.rightSideName);
        }

        if (targetIdP == 6) {
            position = new PlayerPosition(GlobalData.defMidPosName, GlobalData.leftSideName);
        }

        if (targetIdP > 6 && targetIdP < 10) {
            position = new PlayerPosition(GlobalData.defMidPosName, GlobalData.centerSideName);
        }

        if (targetIdP == 10) {
            position = new PlayerPosition(GlobalData.defMidPosName, GlobalData.rightSideName);
        }

        if (targetIdP == 11) {
            position = new PlayerPosition(GlobalData.midPosName, GlobalData.leftSideName);
        }

        if (targetIdP > 11 && targetIdP < 15) {
            position = new PlayerPosition(GlobalData.midPosName, GlobalData.centerSideName);
        }

        if (targetIdP == 15) {
            position = new PlayerPosition(GlobalData.midPosName, GlobalData.rightSideName);
        }

        if (targetIdP == 16) {
            position = new PlayerPosition(GlobalData.attMidPosName, GlobalData.leftSideName);
        }

        if (targetIdP > 16 && targetIdP < 20) {
            position = new PlayerPosition(GlobalData.attMidPosName, GlobalData.centerSideName);
        }

        if (targetIdP == 20) {
            position = new PlayerPosition(GlobalData.attMidPosName, GlobalData.rightSideName);
        }

        if (targetIdP == 21) {
            position = new PlayerPosition(GlobalData.forwardPosName, GlobalData.leftSideName);
        }

        if (targetIdP > 21 && targetIdP < 25) {
            position = new PlayerPosition(GlobalData.forwardPosName, GlobalData.centerSideName);
        }

        if (targetIdP == 25) {
            position = new PlayerPosition(GlobalData.forwardPosName, GlobalData.rightSideName);
        }


        firstTeamTactics.set(dragTeamIdP, position);

    }

    private final class ChoiceTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);


                for (int i = 0; i < 32; i++) {
                    positions.get(i).setBackgroundColor(Color.BLUE);
                }

                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {

                return false;
            }


        }
    }

    private class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:
                    //handle the dragged view being dropped over a drop view
                    LinearLayout dragView = (LinearLayout) event.getLocalState();
                    LinearLayout targetView = (LinearLayout) v;

                    Log.d("fam", "ID TARGET: " + identyfyPositionId(dragView));
                    Log.d("fam", "ID DRAG: " + identyfyPositionId(targetView));

                    int dragId = identyfyPositionId(dragView);
                    int targetId = identyfyPositionId(targetView);


                    Player playerDrag = tacticsPosition.get(dragId);
                    Player playerTarget = tacticsPosition.get(targetId);

                    Log.d("fam", "DragedID: " + playerTarget.getId());

                    if (playerTarget.getId() == -1) {

                        for (int i = 0; i < 17; i++) {
                            if (firstTeam.getTeamPlayers().get(i).getId() == playerDrag.getId()) {
                                dragTeamId = i;
                            }
                        }
                        if (dragTeamId < 11) {

                            Log.d("fam", "tacktics droped: " + dragId + " Tactics target: " + targetId);


                            firstTeam.getTeamPlayers().get(dragTeamId).setSquadPosition(targetId);


                            Collections.swap(tacticsPosition, dragId, targetId);
                            updateTeamTactics(dragTeamId, targetId);
                        }


                    } else {

                        for (int i = 0; i < 17; i++) {
                            if (firstTeam.getTeamPlayers().get(i).getId() == playerTarget.getId()) {
                                dropTeamId = i;
                            }

                        }

                        for (int i = 0; i < 17; i++) {
                            if (firstTeam.getTeamPlayers().get(i).getId() == playerDrag.getId()) {
                                dragTeamId = i;
                            }
                        }


                        int spTemp = firstTeam.getTeamPlayers().get(dragTeamId).getSquadPosition();
                        firstTeam.getTeamPlayers().get(dragTeamId).setSquadPosition(firstTeam.getTeamPlayers().get(dropTeamId).getSquadPosition());
                        firstTeam.getTeamPlayers().get(dropTeamId).setSquadPosition(spTemp);

                        Log.d("fam", "tacktics droped: " + dragTeamId + " Tactics target: " + dropTeamId);

                        Collections.swap(firstTeam.getTeamPlayers(), dragTeamId, dropTeamId);


                    }

                    //TextView dropped = (TextView) droppedView.getChildAt(1);
                    // TextView dropTarget = (TextView) dropTagetView.getChildAt(1);

                    // update the text in the target view to reflect the data being dropped
                    // String temp = dropTarget.getText().toString();
                    // dropTarget.setText(dropped.getText());
                    // dropped.setText(temp);


                    updateTacticsPositions();

                    for (int i = 0; i < 32; i++) {
                        positions.get(i).setBackgroundColor(Color.TRANSPARENT);
                    }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }

            return true;
        }

    }


}

