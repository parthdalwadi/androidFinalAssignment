package com.example.parth_c0766346_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean doubleScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View informationView = findViewById(R.id.f_profileInfo);
        doubleScreen = informationView != null && informationView.getVisibility() == View.VISIBLE;

    }
}
