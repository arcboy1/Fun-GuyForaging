package com.example.funguyzforaging.SharedPreferences;

import com.example.funguyzforaging.DataClass.Mushroom;

import java.util.ArrayList;
import java.util.List;

public class FavMushrooms {
    private static FavMushrooms instance;
    private ArrayList<Mushroom> favouriteMushrooms;
    private boolean isFavourite;

    private FavMushrooms(){
        favouriteMushrooms = new ArrayList<>();
        this.isFavourite=isFavourite;
    }

    public static FavMushrooms getInstance()
    {
        if (instance == null)
             instance= new FavMushrooms();

        return instance;
    }

    public List<Mushroom> getFavouriteMushroom(){
        return favouriteMushrooms;
    }

    public FavMushrooms setFavourite(boolean favourite) {
        isFavourite = favourite;
        return this;
    }

    public boolean isFavourite() {
        return isFavourite;
    }
}



