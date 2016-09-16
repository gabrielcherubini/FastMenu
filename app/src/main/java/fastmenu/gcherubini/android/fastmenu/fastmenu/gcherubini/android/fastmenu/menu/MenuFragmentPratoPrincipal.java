package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fastmenu.gcherubini.android.fastmenu.R;

/**
 * Created by G.Cherubini on 14/09/2016.
 */
public class MenuFragmentPratoPrincipal extends Fragment
{
    public MenuFragmentPratoPrincipal()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menulist, container, false);
    }
}