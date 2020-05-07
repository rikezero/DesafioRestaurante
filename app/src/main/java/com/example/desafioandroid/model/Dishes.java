package com.example.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

public class Dishes implements Parcelable {

    String dishName,dishInfo;
    Integer dishImage;

    public Dishes() {
    }

    public Dishes(String dishName, @Nullable String dishInfo, Integer dishImage) {
        this.dishName = dishName;
        this.dishImage = dishImage;
        this.dishInfo = dishInfo;
    }

    protected Dishes(Parcel in) {
        dishName = in.readString();
        dishInfo = in.readString();
        if (in.readByte() == 0) {
            dishImage = null;
        } else {
            dishImage = in.readInt();
        }
    }

    public static final Creator<Dishes> CREATOR = new Creator<Dishes>() {
        @Override
        public Dishes createFromParcel(Parcel in) {
            return new Dishes(in);
        }

        @Override
        public Dishes[] newArray(int size) {
            return new Dishes[size];
        }
    };

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishImage() {
        return dishImage;
    }

    public void setDishImage(Integer dishImage) {
        this.dishImage = dishImage;
    }

    public String getDishInfo() {
        return dishInfo;
    }

    public void setDishInfo(String dishInfo) {
        this.dishInfo = dishInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dishName);
        dest.writeString(dishInfo);
        if (dishImage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dishImage);
        }
    }
}
