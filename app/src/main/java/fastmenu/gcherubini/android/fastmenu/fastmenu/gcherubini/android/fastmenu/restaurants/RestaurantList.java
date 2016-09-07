package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by G.Cherubini on 03/09/2016.
 */
public class RestaurantList
{
    private static RestaurantList sRestaurantList;

    private List<Restaurant> mRestaurants;

    public static RestaurantList get(Context context)
    {
        if (sRestaurantList == null)
        {
            sRestaurantList = new RestaurantList(context);
        }
        return sRestaurantList;
    }

    private RestaurantList(Context context)
    {
        mRestaurants = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            Restaurant restaurant = new Restaurant();
            restaurant.setNome("Restaurante " + i);
            mRestaurants.add(restaurant);
        }

    }

    public List<Restaurant> getRestaurants()
    {
        return mRestaurants;
    }

    public Restaurant getRestaurant(UUID uuid)
    {
        for (Restaurant restaurant : mRestaurants)
        {
            if(restaurant.getUUID().equals(uuid))
            {
                return restaurant;
            }
        }
        return null; //TODO: retornando null (criar exceção)
    }


}
