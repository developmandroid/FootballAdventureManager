package pl.arnea.footballadventuremanager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import pl.arnea.footballadventuremanager.R;
import pl.arnea.footballadventuremanager.ui.BaseActivity;
import pl.arnea.footballadventuremanager.ui.MainFragment;

public class FragmentChangeActivity extends BaseActivity {

    private Fragment mContent;

    public FragmentChangeActivity() {
        super(R.string.changing_fragments);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the Above View
        if (savedInstanceState != null)
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        if (mContent == null)
            mContent = new MainFragment();

        // set the Above View
        setContentView(R.layout.content_frame);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, mContent)
                .commit();

        // set the Behind View
        setBehindContentView(R.layout.menu_frame);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, new SlideMenuFragment())
                .commit();


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", mContent);
    }

    public void switchContent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        getSlidingMenu().showContent();
    }

}
