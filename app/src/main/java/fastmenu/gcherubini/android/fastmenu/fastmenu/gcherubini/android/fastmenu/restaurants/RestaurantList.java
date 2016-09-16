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
            Restaurant restaurant = new Restaurant(i);
            restaurant.setID(i);
            restaurant.setNome("Restaurante " + i);
            restaurant.setEndereço("Av. Dummy, " + i);
            restaurant.setInfo("Restaurante teste (hardcoded - classe Restaurant");
            restaurant.setCNPJ("111111111111111");
            restaurant.setTelefone("(11)11111-1111");
            restaurant.setDistância(restaurant.calculateDistance(1.0, 1.0));
            mRestaurants.add(restaurant);
        }
    }

    public List<Restaurant> getRestaurants()
    {
        return mRestaurants;
    }

    public Restaurant getRestaurant(int id)
    {
        for (Restaurant restaurant : mRestaurants)
        {
            if(restaurant.getID() == id)
            {
                return restaurant;
            }
        }
        return null; //TODO: retornando null (criar tratamento quando aplicar este método)
    }


}
