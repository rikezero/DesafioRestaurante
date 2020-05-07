package com.example.desafioandroid.recycler;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioandroid.R;

class DishesViewHolder extends RecyclerView.ViewHolder{
    TextView dishName;
    ImageView image;
    CardView cardView;
    Activity activity;


    public DishesViewHolder(View layout) {
        super(layout);
        activity = (Activity) layout.getContext();
        dishName = layout.findViewById(R.id.dish_text);
        image = layout.findViewById(R.id.dish_image);
        cardView = layout.findViewById(R.id.dish_cardView);
        image.setAdjustViewBounds(true);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
