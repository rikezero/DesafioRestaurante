package com.example.desafioandroid.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioandroid.MainScreen;
import com.example.desafioandroid.R;

import com.example.desafioandroid.model.Dishes;
import com.example.desafioandroid.model.Restaurant;
import com.example.desafioandroid.recycler.AdapterDishes;

import java.util.ArrayList;


public class RestaurantFragment extends Fragment {

    View view;
    Context mContext;
    Activity activity;
    ImageView arrow, resImage;
    TextView resName;
    RecyclerView recyclerDishes;
    RecyclerView.LayoutManager layoutManager;
    AdapterDishes adapterDishes;
    Restaurant restaurant;
    ArrayList<Dishes> dishes;



    public RestaurantFragment() {
    }

    public static RestaurantFragment newInstance(Bundle bundle) {
        RestaurantFragment frag = new RestaurantFragment();
        frag.setArguments(bundle);
        return frag;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = container;
        return inflater.inflate(R.layout.fragment_res_info, container, false);


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (Activity) mContext;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            restaurant = bundle.getParcelable("RES");
        }
        System.out.println(restaurant);
        findViews();
        setListeners();
        setupFragment();
        recyclerSetup();
    }

    private void findViews(){
        arrow = view.findViewById(R.id.arrow_back);
        recyclerDishes = view.findViewById(R.id.dishes);
        resImage = view.findViewById(R.id.res_info_image);
        resName = view.findViewById(R.id.resName);
    }

    private void setListeners(){
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 activity.onBackPressed();
            }
        });
    }
    private void setupFragment(){
        resImage.setImageResource(restaurant.getImage());
        resName.setText(restaurant.getName());
        this.dishes = restaurant.getDishes();
    }

    private void recyclerSetup(){
        layoutManager = new GridLayoutManager(mContext,2);
        adapterDishes = new AdapterDishes(dishes);
        recyclerDishes.setLayoutManager(layoutManager);
        recyclerDishes.setAdapter(adapterDishes);

    }



}
