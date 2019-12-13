package com.example.parth_c0766346_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProfileAdapter extends ArrayAdapter {

    private ArrayList<Profile> profiles;
    private final LayoutInflater layoutInflater;
    private final int resource;

    Context context;

    public ProfileAdapter(@NonNull Context context, int resource, ArrayList<Profile> profiles) {
        super(context, resource);
        this.profiles = profiles;
        this.layoutInflater = LayoutInflater.from(context);
        this.resource = resource;
        this.context = context;
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

        ImageView proImage = v.findViewById(R.id.photo);
        TextView nameT = v.findViewById(R.id.name);
        TextView numberT = v.findViewById(R.id.number);
        TextView emailT = v.findViewById(R.id.email);



        Profile p = Profile.AllProfiles.get(position);
        int image_id = context.getResources().getIdentifier(String.format("icon01_%02d",p.imageNo),
                "drawable", context.getPackageName());
        proImage.setImageResource(image_id);
        nameT.setText(p.name);
        emailT.setText(p.email);
        numberT.setText(p.phone);
        return v;
    }
}
