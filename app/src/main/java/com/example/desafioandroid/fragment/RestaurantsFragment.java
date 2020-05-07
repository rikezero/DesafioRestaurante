package com.example.desafioandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desafioandroid.MainScreen;
import com.example.desafioandroid.R;
import com.example.desafioandroid.model.Dishes;
import com.example.desafioandroid.model.Restaurant;
import com.example.desafioandroid.recycler.AdapterRestaurant;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    RecyclerView recyclerRestaurant;
    RecyclerView.LayoutManager layoutManager;
    AdapterRestaurant adapterRes;
    View view;
    Context mContext;
    ArrayList<Restaurant> restaurants = new ArrayList<>();


    public RestaurantsFragment() {
    }

    public static RestaurantsFragment newInstance(Bundle bundle) {
        RestaurantsFragment frag = new RestaurantsFragment();
        frag.setArguments(bundle);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = container;
        return inflater.inflate(R.layout.fragment_restaurant, container, false);


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        loadArray();
        recyclerSetup();
    }

    private void findViews(){
        recyclerRestaurant = view.findViewById(R.id.recycler_restaurants);
    }

    private void recyclerSetup(){
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        adapterRes = new AdapterRestaurant(restaurants);
        recyclerRestaurant.setLayoutManager(layoutManager);
        recyclerRestaurant.setAdapter(adapterRes);
    }

    private void loadArray(){
        restaurants.add(new Restaurant("Quitanda do tio João", "Rua Santa Paula do Norte, 23",R.drawable.res1 ));
        restaurants.add(new Restaurant("Cabana da Pizza", "Rua Santa Paula do Norte, 123",R.drawable.res2 ));
        restaurants.add(new Restaurant("Jão Bar e Lanches", "Rua Ponte Norte, 333",R.drawable.res3 ));
        restaurants.add(new Restaurant("Bar do Gole Grande", "Rua Capixabas, 2000",R.drawable.res4 ));
        restaurants.add(new Restaurant("Tamo Junto Bar e Lanches", "Rua dos Orixás, 400",R.drawable.res5 ));
        restaurants.add(new Restaurant("Santo Espeto", "Rua Capinambabas, 301",R.drawable.res6 ));
        setDishes();

    }

    private void setDishes(){
        restaurants.get(5).addDish(new Dishes("Kebab do Chef",getString(R.string.kebab_info), R.drawable.kebab));
        restaurants.get(5).addDish(new Dishes("Kebab no Espeto",getString(R.string.kebab_info), R.drawable.kebab_espeto));
        restaurants.get(0).addDish(new Dishes("Franguinho Frito do tio João",getString(R.string.frango_frito), R.drawable.frango_frito));
        restaurants.get(0).addDish(new Dishes("Kebab do Chef Jaquinho",getString(R.string.kebab_info), R.drawable.kebab),
                new Dishes("Porção Grande Mista",getString(R.string.porcao_info), R.drawable.combinadao),
                new Dishes("Porção Pequena Mista",getString(R.string.porcao_info), R.drawable.combinadinho),
                new Dishes("Hamburguer da Casa",getString(R.string.hamb_info), R.drawable.mexican_chicken_burger),
                new Dishes("HotDog Gourmet",getString(R.string.dog_info), R.drawable.hotdog_gourmet));
        restaurants.get(2).addDish(new Dishes("Döner Kebab (Sanduiche)",getString(R.string.doner_info), R.drawable.doner_kebab));
        restaurants.get(3).addDish(new Dishes("Mussarela Empanada",getString(R.string.muzz_stick_info), R.drawable.mozzarella_sticks),
                new Dishes("Porção Grande Mista",getString(R.string.porcao_info), R.drawable.combinadao),
                new Dishes("Porção Pequena Mista",getString(R.string.porcao_info), R.drawable.combinadinho));
        restaurants.get(1).addDish(
                new Dishes("Pizza de Frango e Peperone",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Hamburguer",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Calacatu",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Calabresa",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Mussarela",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Peperone",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Frango",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Mussarela e Calabresa",getString(R.string.pizza_info), R.drawable.pizza),
                new Dishes("Pizza de Frango II",getString(R.string.pizza_info), R.drawable.pizza));
        restaurants.get(2).addDish(new Dishes("Döner Kebab (Sanduiche)",getString(R.string.doner_info), R.drawable.doner_kebab));
        restaurants.get(4).addDish(new Dishes("Combinadão do Cozinheiro",getString(R.string.porcao_info), R.drawable.combinadao),
                new Dishes("Combinadinho da Tia Nenê",getString(R.string.porcao_info), R.drawable.combinadinho));
    }

}
