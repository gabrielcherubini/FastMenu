package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fastmenu.gcherubini.android.fastmenu.R;

/**
 * Created by Gabriel on 19/08/2016.
 */
public class RestaurantListFragment extends Fragment
{
    private RecyclerView mRestaurantRecyclerView;
    private RestaurantAdapter mAdapter;


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

    private class RestaurantHolder extends RecyclerView.ViewHolder
    {
        public TextView mNomeRestaurantTextView;

        public RestaurantHolder(View itemView)
        {
            super(itemView);
            mNomeRestaurantTextView = (TextView)itemView;
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
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);

            return new RestaurantHolder(view);
        }

        @Override
        public void onBindViewHolder(RestaurantHolder holder, int position)
        {
            Restaurant restaurant = mRestaurants.get(position);
            holder.mNomeRestaurantTextView.setText(restaurant.getNome());
        }

        @Override
        public int getItemCount()
        {
            return mRestaurants.size();
        }
    }
}
