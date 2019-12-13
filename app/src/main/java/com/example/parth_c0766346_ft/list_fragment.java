package com.example.parth_c0766346_ft;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.zip.Inflater;


interface FragmentListener{
    void showProfile(int index);
}

/**
 * A simple {@link Fragment} subclass.
 */
public class list_fragment extends Fragment {

    private Context context ;

    private FragmentListener listenerO;

    public list_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_fragment, container, false);
        this.context = inflater.getContext();
        listenerO = (FragmentListener) context;
        ProfileAdapter adapter = new ProfileAdapter(context, R.layout.layout_profile, Profile.AllProfiles);
        ListView list = v.findViewById(R.id.profileList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listenerO != null){
                    listenerO.showProfile(position);
                }
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view  = getView();
        if (view!= null){
            Button add = view.findViewById(R.id.addButton);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, UserForm.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                }
            });
        }
    }
}
