package com.example.funguyzforaging.DataClass;

import android.os.Parcel;
import android.os.Parcelable;
//mushroom pojo defines what Mushroom object will be

public class Mushroom{
    private String name;
    private int image;
    private String description;
    private String location;
    private boolean isFavorite;

    public Mushroom(String name, int image, String description, String location) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.location = location;
        this.isFavorite=false;
    }

    public Mushroom(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Mushroom setName(String name) {
        this.name = name;
        return this;
    }

    public int getImage() {
        return image;
    }

    public Mushroom setImage(int image) {
        this.image = image;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Mushroom setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Mushroom setLocation(String location) {
        this.location = location;
        return this;
    }
    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
