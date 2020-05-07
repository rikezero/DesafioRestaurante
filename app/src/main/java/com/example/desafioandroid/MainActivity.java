package com.example.desafioandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.desafioandroid.custom.CustomSnackbar;

public class MainActivity extends AppCompatActivity {

    Button newAcc, login;
    TextView email, pass;
    CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        setListeners();
    }
    private void findViews() {
        setContentView(R.layout.activity_main);
        newAcc = findViewById(R.id.register_button);
        login = findViewById(R.id.login_button);
        email = findViewById(R.id.email_input);
        pass = findViewById(R.id.pass_input);
        layout = findViewById(R.id.coordinator_login);

    }

    private void setListeners() {
        newAcc.setOnClickListener(goTo(NewAccountActivity.class, new Bundle()));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                    new CustomSnackbar().makeSB(layout, getString(R.string.empty_fields_msg),15,15).show();
                }
                else {
                    Activity activity = (Activity) view.getContext();
                    activity.startActivity(new Intent(activity, MainScreen.class).putExtras(new Bundle()));
                }
            }
        });

    }

    private View.OnClickListener goTo(final Class umaClasse, final Bundle pacote) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = (Activity) view.getContext();
                activity.startActivity(new Intent(activity, umaClasse).putExtras(pacote));
            }
        };
    }

}