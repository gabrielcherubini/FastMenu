package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import fastmenu.gcherubini.android.fastmenu.R;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.SingleFragmentActivity;

/**
 * Created by G.Cherubini on 06/09/2016.
 */
public class MenuActivity extends SingleFragmentActivity
{
    private static final String EXTRA_RESTAURANT_ID = "fastmenu.gcherubini.android.fastmenu.restaurant_id";

    public static Intent newIntent(Context packageContext, int restaurantID) {
        Intent intent = new Intent(packageContext, MenuActivity.class);
        intent.putExtra(EXTRA_RESTAURANT_ID, restaurantID);
        return intent;
    }

    @Override
    public Fragment createFragment()
    {
        int restaurantID = (int)getIntent().getIntExtra(EXTRA_RESTAURANT_ID,0);
        return MenuFragment.newInstance(restaurantID);
    }
}
