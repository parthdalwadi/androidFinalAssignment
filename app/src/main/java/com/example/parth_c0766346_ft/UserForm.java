package com.example.parth_c0766346_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class UserForm extends AppCompatActivity {

    EditText u_name, u_email, u_phone;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        u_name = findViewById(R.id.name);
        u_email = findViewById(R.id.email);
        u_phone = findViewById(R.id.phone);

        saveBtn = findViewById(R.id.save);

    }

    public void saveUserdata(View v){

        Profile p = new Profile(u_name.getText().toString(), u_email.getText().toString(), u_phone.getText().toString(),1);

        Profile.AllProfiles.add(p);

        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);


    }


}
