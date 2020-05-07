package com.example.desafioandroid.recycler;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioandroid.R;


class RestautantViewHolder extends RecyclerView.ViewHolder {
    TextView resName,info;
    ImageView image;
    CardView cardView;
    Activity activity;


    public RestautantViewHolder(View layout) {
        super(layout);
        activity = (Activity) layout.getContext();
        resName = layout.findViewById(R.id.res_name);
        info = layout.findViewById(R.id.res_address);
        image = layout.findViewById(R.id.res_imageView);
        cardView = layout.findViewById(R.id.res_cardView);
        image.setAdjustViewBounds(true);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
