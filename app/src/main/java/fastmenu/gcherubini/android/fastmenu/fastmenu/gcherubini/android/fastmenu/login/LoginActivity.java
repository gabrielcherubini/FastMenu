package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.login;

import android.support.v4.app.Fragment;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.SingleFragmentActivity;

/**
 * Created by Gabriel on 19/08/2016.
 */
public class LoginActivity extends SingleFragmentActivity
{
    @Override
    public Fragment createFragment()
    {
        return new LoginFragment();
    }
}
