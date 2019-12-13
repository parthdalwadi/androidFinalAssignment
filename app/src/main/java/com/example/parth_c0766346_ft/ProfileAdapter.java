package com.example.parth_c0766346_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProfileAdapter extends ArrayAdapter {

    private ArrayList<Profile> profiles;
    private final LayoutInflater layoutInflater;
    private final int resource;


    public ProfileAdapter(@NonNull Context context, int resource, ArrayList<Profile> profiles) {
        super(context, resource);
        this.profiles = profiles;
        this.layoutInflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return profiles.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null){

            v = layoutInflater.inflate(resource, parent, false);

        }




        return v;
    }
}
