package com.example.desafioandroid.recycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desafioandroid.MainScreen;
import com.example.desafioandroid.R;
import com.example.desafioandroid.fragment.DishDescFragment;
import com.example.desafioandroid.fragment.RestaurantFragment;
import com.example.desafioandroid.model.Dishes;

import java.util.ArrayList;

public class AdapterDishes extends RecyclerView.Adapter<DishesViewHolder> {

    public AdapterDishes (){

    }
    private ArrayList<Dishes> dataSet;
    Activity activity;

    public AdapterDishes(ArrayList<Dishes> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public DishesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        activity =(Activity) viewGroup.getContext();
        View layout = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.dishes_viewholder, viewGroup, false);
        return new DishesViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull final DishesViewHolder ViewHolder, int position) {
        final Dishes dish = dataSet.get(position);
        ViewHolder.dishName.setText(dish.getDishName());
        ViewHolder.image.setImageResource(dish.getDishImage());
        ViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("DISH",dish);
                ((MainScreen)activity).fragLoad(DishDescFragment.newInstance(bundle));

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

