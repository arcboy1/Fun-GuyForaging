package com.example.funguyzforaging.DataClass;

import android.os.Parcel;
import android.os.Parcelable;

public class Mushroom implements Parcelable {
    private String name;
    private int image;
    private String description;
    private String location;

    public Mushroom(String name, int image, String description, String location) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.location = location;
    }

    protected Mushroom(Parcel in) {
        name = in.readString();
        image = in.readInt();
        description = in.readString();
        location = in.readString();
    }

    public static final Creator<Mushroom> CREATOR = new Creator<Mushroom>() {
        @Override
        public Mushroom createFromParcel(Parcel in) {
            return new Mushroom(in);
        }

        @Override
        public Mushroom[] newArray(int size) {
            return new Mushroom[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(image);
        parcel.writeString(description);
        parcel.writeString(location);
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
}
