package com.app.salpo.skillzapp.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.salpo.skillzapp.R;

public class HomeActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences("basicPref",
                Context.MODE_PRIVATE);
        if (sharedPreferences.contains("token")) {
            //send token via api calls & get data
            //display data in recycler view
            mToken = sharedPreferences.getString("token", "");
        }
    }
}
