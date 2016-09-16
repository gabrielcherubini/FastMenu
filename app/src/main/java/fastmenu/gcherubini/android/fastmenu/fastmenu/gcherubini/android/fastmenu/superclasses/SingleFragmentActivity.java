package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fastmenu.gcherubini.android.fastmenu.R;

/**
 * Created by G.Cherubini on 09/08/2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity
{

    public abstract Fragment createFragment();

    @LayoutRes
    public int getLayoutResID()
    {
        return R.layout.activity_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
