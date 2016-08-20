package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fastmenu.gcherubini.android.fastmenu.R;

/**
 * Created by Gabriel on 19/08/2016.
 */
public class RestaurantListFragment extends Fragment
{
    public RecyclerView mRestaurantList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_restaurantlist, container, false);

        mRestaurantList = (RecyclerView)v.findViewById(R.id.fragment_restaurantlist_recyclerview);
        mRestaurantList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    private class restaurantHolder extends RecyclerView.ViewHolder
    {
        public TextView mNomeRestauranteTextView;

        //public ImageView mLogoRestauranteImageView;

        public restaurantHolder(View itemView)
        {
            super(itemView);
            mNomeRestauranteTextView = (TextView)itemView;
        }
    }
}
