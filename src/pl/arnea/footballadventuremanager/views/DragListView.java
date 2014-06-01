package pl.arnea.footballadventuremanager.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import pl.arnea.footballadventuremanager.adapters.TeamPlayerListAdapter;
import pl.arnea.footballadventuremanager.models.person.Player;
import pl.arnea.footballadventuremanager.ui.TeamPlayerDetailActivity;
import pl.arnea.footballadventuremanager.vars.GlobalData;

import java.util.Collections;
import java.util.List;

public class DragListView extends ListView {

    public static int posChoosen = -1;
    int relativePosition;
    int posCheck = -1;
    int checkEnabled;
    boolean dragable = false;
    private ImageView dragImageView;//?ImageView
    private int dragSrcPosition;//
    private int dragPosition;//?
    private int dragPoint;//
    private int dragOffset;//(y)
    private WindowManager windowManager;//windows
    private WindowManager.LayoutParams windowParams;//
    private int scaledTouchSlop;//
    private int upScrollBounce;//?
    private int downScrollBounce;//?

    public DragListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLongClickable(true);


        scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }


    @Override
    public boolean onInterceptTouchEvent(final MotionEvent ev) {


        setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view,
                                           int position, long id) {

                int x = (int) ev.getX();
                int y = (int) ev.getY() - 80;
                Log.d("test", "Position Y" + y);

                // dragSrcPosition = dragPosition = pointToPosition(x, y) - 1;
                dragSrcPosition = dragPosition = position;


                ViewGroup itemView = (ViewGroup) getChildAt(dragPosition - getFirstVisiblePosition());

                dragPoint = y - itemView.getTop();
                dragOffset = (int) (ev.getRawY() - y);
                Log.d("test", "GetRow Y" + ev.getRawY());

                //View dragger = itemView.findViewById(R.id.textDrag);

                itemView.destroyDrawingCache();

                upScrollBounce = Math.min(y - scaledTouchSlop, getHeight() / 3);
                downScrollBounce = Math.max(y + scaledTouchSlop, getHeight() * 2 / 3);

                itemView.setDrawingCacheEnabled(true);
                Bitmap bm = Bitmap.createBitmap(itemView.getDrawingCache());

                startDrag(bm, y);
                dragable = true;
                return true;


            }
        });

        setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("fam", "Pozycja" + position);
                Intent intent = new Intent(parent.getContext(), TeamPlayerDetailActivity.class);
                intent.putExtra("choosenPlayer", position);
                parent.getContext().startActivity(intent);

            }
        });

        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (dragImageView != null && dragPosition != INVALID_POSITION && dragable == true) {
            int moveY = 0;
            int action = ev.getAction();
            switch (action) {

                case MotionEvent.ACTION_UP:
                    int upY = (int) ev.getY();
                    stopDrag();
                    onDrop(upY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    moveY = (int) ev.getY();
                    onDrag(moveY);
                    break;
                default:
                    break;
            }

            int scrollHeight = 0;
            if (moveY < upScrollBounce) {
                scrollHeight = 8;//8?
            } else if (moveY > downScrollBounce) {
                scrollHeight = -8;//8??
            }

            if (scrollHeight != 0) {
                setSelectionFromTop(dragPosition, getChildAt(dragPosition - getFirstVisiblePosition()).getTop() + scrollHeight);
            }
            return true;
        }
        return super.onTouchEvent(ev);
    }


    public void startDrag(Bitmap bm, int y) {
        stopDrag();

        windowParams = new WindowManager.LayoutParams();
        windowParams.gravity = Gravity.TOP;
        windowParams.x = 0;
        windowParams.y = y - dragPoint + dragOffset;
        windowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        windowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        windowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        windowParams.format = PixelFormat.TRANSLUCENT;
        windowParams.windowAnimations = 0;

        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(bm);

        windowManager = (WindowManager) getContext().getSystemService("window");
        windowManager.addView(imageView, windowParams);
        dragImageView = imageView;
        int actual = dragSrcPosition - getFirstVisiblePosition();

        getChildAt(actual).setAlpha(0);
        posChoosen = dragSrcPosition;
        getChildAt(actual).invalidate();

    }

    public void stopDrag() {
        if (dragImageView != null) {
            windowManager.removeView(dragImageView);
            dragImageView = null;
            dragable = false;
        }
    }

    public void onDrag(int y) {

        if (dragImageView != null) {
            windowParams.alpha = 0.8f;
            windowParams.y = y - dragPoint + dragOffset;
            windowManager.updateViewLayout(dragImageView, windowParams);
        }

        int tempPosition = pointToPosition(0, y);
        if (tempPosition != INVALID_POSITION) {
            dragPosition = tempPosition;
        }
        Log.d("fam", "Drag position:" + dragPosition);


        int actual = dragPosition - getFirstVisiblePosition();


        if (posCheck != dragPosition) {

            if (posCheck > dragPosition) {
                getChildAt(actual).setBackgroundColor(0x60FFFF00);
                getChildAt(actual + 1).setBackgroundColor(0x00000000);
                checkEnabled = 1;

            }

            if (posCheck < dragPosition) {
                getChildAt(actual).setBackgroundColor(0x60FFFF00);
                getChildAt(actual - 1).setBackgroundColor(0x00000000);
                checkEnabled = 2;
            }
            posCheck = dragPosition;
        }

    }

    public void onDrop(int y) {

        if (dragImageView != null) {
            windowManager.removeView(dragImageView);
            dragImageView = null;
        }

        int tempPosition = pointToPosition(0, y);
        if (tempPosition != INVALID_POSITION) {
            dragPosition = tempPosition;
        }

        TeamPlayerListAdapter adapter = (TeamPlayerListAdapter) getAdapter();
        List<Player> list = adapter.getAllList();
        int spTemp = GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamPlayers().get(dragPosition).getSquadPosition();
        GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamPlayers().get(dragPosition).setSquadPosition(GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamPlayers().get(dragSrcPosition).getSquadPosition());
        GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().getTeamPlayers().get(dragSrcPosition).setSquadPosition(spTemp);

        Collections.swap(list, dragPosition, dragSrcPosition);
        adapter.setAllList(list);
        adapter.notifyDataSetChanged();

        GlobalData.allClubs.get(GlobalData.MYCLUBID).getFirstTeam().setTeamPlayers(list);
        posChoosen = -1;
        int actual = dragPosition - getFirstVisiblePosition();

        getChildAt(actual).setBackgroundColor(0x00000000);
        dragable = false;


    }


}
