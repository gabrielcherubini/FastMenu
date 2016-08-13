package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import fastmenu.gcherubini.android.fastmenu.R;

/**
 * Created by G.Cherubini on 09/08/2016.
 */
public class RegistrarActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_registrar);

        if (fragment == null)
        {
            fragment = new RegistrarFragment();
            fm.beginTransaction().add(R.id.fragment_container_registrar, fragment).commit();
        }
    }
}
