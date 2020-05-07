package com.example.desafioandroid.recycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.desafioandroid.MainActivity;
import com.example.desafioandroid.MainScreen;
import com.example.desafioandroid.R;
import com.example.desafioandroid.fragment.RestaurantFragment;
import com.example.desafioandroid.fragment.RestaurantsFragment;
import com.example.desafioandroid.model.Restaurant;

import java.util.ArrayList;


public class AdapterRestaurant extends RecyclerView.Adapter<RestautantViewHolder> {
    ArrayList<Restaurant> dataSet;
    Activity activity;

    public AdapterRestaurant(ArrayList<Restaurant> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public RestautantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        activity =(Activity) viewGroup.getContext();
        View layout = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurant_viewholder, viewGroup, false);
        return new RestautantViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull final RestautantViewHolder ViewHolder, final int position) {
        final Restaurant res = dataSet.get(position);
        ViewHolder.resName.setText(res.getName());
        ViewHolder.info.setText(res.getInfo());
        ViewHolder.image.setImageResource(res.getImage());
        ViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("RES", dataSet.get(position));
                ((MainScreen)activity).fragLoad(RestaurantFragment.newInstance(bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
