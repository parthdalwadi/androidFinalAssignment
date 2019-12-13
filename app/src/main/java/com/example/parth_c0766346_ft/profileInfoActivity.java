package com.example.parth_c0766346_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class profileInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);

        profileInfoFragment f_proInfo = (profileInfoFragment) getSupportFragmentManager().findFragmentById(R.id.f_profileInfo);

        Intent intent = getIntent();
        int index = intent.getExtras().getInt("selectedUser");
        f_proInfo.showDataforID(index);
    }
}
