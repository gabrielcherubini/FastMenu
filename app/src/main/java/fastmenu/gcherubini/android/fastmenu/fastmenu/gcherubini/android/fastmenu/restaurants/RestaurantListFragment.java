package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fastmenu.gcherubini.android.fastmenu.R;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu.MenuActivity;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.MyLocation;

/**
 * Created by Gabriel on 19/08/2016.
 */
public class RestaurantListFragment extends Fragment
{
    private RecyclerView mRestaurantRecyclerView;
    private RestaurantAdapter mAdapter;
    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_restaurant_list, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_restaurantlist, container, false);



        mRestaurantRecyclerView = (RecyclerView)v.findViewById(R.id.fragment_restaurantlist_recyclerview);
        mRestaurantRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI()
    {
        RestaurantList restaurantList = RestaurantList.get(getActivity());
        List<Restaurant> restaurants = restaurantList.getRestaurants();

        mAdapter = new RestaurantAdapter(restaurants);
        mRestaurantRecyclerView.setAdapter(mAdapter);
    }

    //Holder do view definido pelo res/layout list_restaurant.xml
    private class RestaurantHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView mNomeListRestauranteTextView;
        private TextView mEndereçoListRestauranteTextView;
        private TextView mlabelDistanciaListRestauranteTextView;
        private TextView mDistanciaListRestauranteTextView;
        private Button mInfoListRestauranteButton;
        private Restaurant mRestaurant;

        public RestaurantHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            mNomeListRestauranteTextView = (TextView)itemView.findViewById(R.id.nomeListRestaurante_textView);
            mEndereçoListRestauranteTextView = (TextView)itemView.findViewById(R.id.endereçoListRestaurante_textView);
            mlabelDistanciaListRestauranteTextView = (TextView)itemView.findViewById(R.id.labelDistanciaListRestaurante_textView);
            mDistanciaListRestauranteTextView = (TextView)itemView.findViewById(R.id.distanciaListRestaurante_textView);
            mInfoListRestauranteButton = (Button)itemView.findViewById(R.id.infoListRestaurante_button);
        }

        public void bindRestaurant(Restaurant restaurant)
        {
            mRestaurant = restaurant;
            mNomeListRestauranteTextView.setText(restaurant.getNome());
            mEndereçoListRestauranteTextView.setText(restaurant.getEndereço());
            mlabelDistanciaListRestauranteTextView.setText(R.string.distanciaLabel_string);
            mDistanciaListRestauranteTextView.setText(restaurant.getDistância());
            mInfoListRestauranteButton.setText(R.string.informações_string);
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = MenuActivity.newIntent(getActivity(), mRestaurant.getID());
            startActivity(intent);
        }
    }

    private class RestaurantAdapter extends RecyclerView.Adapter<RestaurantHolder>
    {

        private List<Restaurant> mRestaurants;

        public RestaurantAdapter(List<Restaurant> restaurants)
        {
            mRestaurants = restaurants;
        }

        @Override
        public RestaurantHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_restaurant, parent, false);

            return new RestaurantHolder(view);
        }

        @Override
        public void onBindViewHolder(RestaurantHolder holder, int position)
        {
            Restaurant restaurant = mRestaurants.get(position);
            holder.bindRestaurant(restaurant);
        }

        @Override
        public int getItemCount()
        {
            return mRestaurants.size();
        }
    }
}
