package com.example.parth_c0766346_ft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Profile implements Serializable {

    String name, email, phone;
    int imageNo;

    public Profile(String name, String email, String phone, int imageNo) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.imageNo = imageNo;
    }



    public static ArrayList<Profile> AllProfiles = new ArrayList<>();

}
