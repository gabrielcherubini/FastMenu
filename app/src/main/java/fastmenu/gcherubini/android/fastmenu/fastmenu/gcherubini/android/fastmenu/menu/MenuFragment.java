package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import fastmenu.gcherubini.android.fastmenu.R;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants.Restaurant;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants.RestaurantList;

/**
 * Created by G.Cherubini on 06/09/2016.
 */
public class MenuFragment extends Fragment
{
    //Instancia do restaurante a partir da ID passada pelo argumento
    private Restaurant mRestaurant;

    //Argumento para passar a id do restaurante quando for
    //clicado na lista de restaurantes do RestaurantListFragment
    private static final String ARG_RESTAURANT_ID = "restaurant_id";

    public static MenuFragment newInstance(int restaurantID)
    {
        Bundle args = new Bundle();
        args.putInt(ARG_RESTAURANT_ID, restaurantID);

        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        int restaurantID = (int)getArguments().getInt(ARG_RESTAURANT_ID);

        //TODO: Passo intermediário entre clicar no restaurante da lista e exibir tela com informações do restaurante e menu
        //Cria instância do restaurante a partir da ID, puxando-o da lista RestaurantList
        mRestaurant = RestaurantList.get(getActivity()).getRestaurant(restaurantID);
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_menu_list, menu);
    }
}
