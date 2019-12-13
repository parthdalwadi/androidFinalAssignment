package com.example.parth_c0766346_ft;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class profileInfoFragment extends Fragment {


    public profileInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_info, container, false);
    }

    public void showDataforID(int index) {

        View v = getView();
        if (v != null) {

            TextView tv_name, tv_email, tv_phone;
            ImageView propic = v.findViewById(R.id.profilePic);
            tv_name = v.findViewById(R.id.p_name);
            tv_email = v.findViewById(R.id.p_email);
            tv_phone = v.findViewById(R.id.p_phone);

            Profile p = Profile.AllProfiles.get(index);

            tv_name.setText(p.name);
            tv_phone.setText(p.phone);
            tv_email.setText(p.email);



            int i = p.imageNo;
            String iname = String.format("icon01_%02d",i);

            int image_id = getResources().getIdentifier(iname, "drawable", getContext().getPackageName());
            propic.setImageResource(image_id);



        }
    }
}
