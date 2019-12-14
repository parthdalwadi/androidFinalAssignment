package com.example.parth_c0766346_ft;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Verification extends AppCompatActivity {

    GridView gridView;
    Button verify;
    ImageView refreshI;
    CheckBox robotC;
    int[] AllImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
            R.drawable.img6,R.drawable.img7, R.drawable.img8, R.drawable.img9};

    int[] lightImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    int[] checked = {0, 0, 0, 0, 0, 0, 0, 0 , 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        gridView = findViewById(R.id.grid);
        verify = findViewById(R.id.verify_B);
        refreshI = findViewById(R.id.refresh);
        robotC = findViewById(R.id.robot);



        final GridAdaptor adaptor = new GridAdaptor(this, AllImages);
        gridView.setAdapter(adaptor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView iv = view.findViewById(R.id.trafficI);
                if (checked[position] == 0){
                iv.setImageResource(R.drawable.checked);
                checked[position] = 1;
                }
                else{
                    iv.setImageResource(0);
                    checked[position] = 0;
                }



            }
        });


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                
                
                int trueCount = 0;
                int checkedCount = 0;

                for (int i = 0; i < checked.length; i++){
                    
                    if(checked[i] == 1){
                        checkedCount = checkedCount + 1;
                        
                        for(int j = 0 ; j < lightImages.length; j++){
                            
                            if(AllImages[i] == lightImages[j]){
                                
                                trueCount = trueCount + 1;
                                
                            }
                            
                        }
                        
                    }
                    
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Verification.this);
                if(trueCount == 4 && checkedCount == 4 && robotC.isChecked() ){



                    alertDialog.setTitle("Varified");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent ir = getIntent();
                            Profile p = (Profile) ir.getSerializableExtra("object");

                            Profile.AllProfiles.add(p);

                            Intent i = new Intent(Verification.this, MainActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        }
                    });
                    alertDialog.show();



                    //Toast.makeText(Verification.this, "Profile Saved successfull", Toast.LENGTH_SHORT).show();

                }
                else {
                    alertDialog.setTitle("Not Varified");
                    alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(Verification.this, MainActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        }
                    });
                    alertDialog.show();
                    //Toast.makeText(Verification.this, "sorry !! something is wrong.", Toast.LENGTH_SHORT).show();

                }


            }


        });

        refreshI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0 ; i < AllImages.length - 3; i++){

                    int temp = AllImages[i];
                    AllImages[i] = AllImages[i+2];
                    AllImages[i+2] = temp;

                }


                gridView.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();




            }
        });
    }
}
