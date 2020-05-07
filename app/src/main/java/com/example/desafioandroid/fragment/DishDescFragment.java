package com.example.desafioandroid.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioandroid.MainScreen;
import com.example.desafioandroid.R;
import com.example.desafioandroid.model.Dishes;

public class DishDescFragment extends Fragment {

    View view;
    Context mContext;
    Activity activity;
    ImageView arrow, dishImage;
    TextView dishName, dishInfo;
    Dishes dish;

    public DishDescFragment() {
    }

    public static DishDescFragment newInstance(Bundle bundle) {
        DishDescFragment frag = new DishDescFragment();
        frag.setArguments(bundle);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = container;
        return inflater.inflate(R.layout.fragment_dish_info, container, false);


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
            dish = bundle.getParcelable("DISH");
        }
        findViews();
        setListeners();
        setFrag();
    }

    private void findViews(){
        arrow = view.findViewById(R.id.dish_arrow_back);
        dishImage = view.findViewById(R.id.dish_info_image);
        dishName = view.findViewById(R.id.dish_name);
        dishInfo = view.findViewById(R.id.dish_info);
    }

    private void setListeners(){
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainScreen)activity).getSupportFragmentManager().popBackStackImmediate();
            }
        });
    }

    private void setFrag(){
        dishName.setText(dish.getDishName());
        dishInfo.setText(dish.getDishInfo());
        dishImage.setImageResource(dish.getDishImage());
    }
}
