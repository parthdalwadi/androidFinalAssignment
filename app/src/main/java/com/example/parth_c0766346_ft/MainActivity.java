package com.example.parth_c0766346_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    private boolean doubleScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View informationView = findViewById(R.id.f_profileInfo);
        doubleScreen = informationView != null && informationView.getVisibility() == View.VISIBLE;

    }

    @Override
    public void showProfile(int index) {

        if (doubleScreen){
            profileInfoFragment f_proInfo = (profileInfoFragment) getSupportFragmentManager().findFragmentById(R.id.f_profileInfo);
            f_proInfo.showDataforID(index);

        }
        else{

            Intent intent = new Intent(this, profileInfoActivity.class);
            intent.putExtra("selectedUser", index);
            startActivity(intent);
        }


    }
}
