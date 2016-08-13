package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import fastmenu.gcherubini.android.fastmenu.R;

/**
 * Created by G.Cherubini on 09/08/2016.
 */

public class LoginActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_login);

        if (fragment == null)
        {
            fragment = new LoginFragment();
            fm.beginTransaction().add(R.id.fragment_container_login, fragment).commit();
        }
    }
}
