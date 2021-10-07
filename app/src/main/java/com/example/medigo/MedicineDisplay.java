package com.example.medigo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicineDisplay extends AppCompatActivity {
     TextView textView_medtime,textView_medname,textView_medtype,textView_meddose,textView_startdate,textView_enddate;
     ImageButton imageButton_delete,imageButton_edit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_MEDTIME="medtime";
    private static final String KEY_MEDNAME="medname";
    private static final String KEY_MEDTYPE="medtype";
    private static final String KEY_MEDDOSE="meddose";
    private static final String KEY_STARTDATE="startdate";
    private static final String KEY_ENDDATE="enddate";
    static List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_display);

        textView_medtime = findViewById(R.id.tv_med_time);
        textView_medname = findViewById(R.id.tv_medicine_name);
        textView_medtype = findViewById(R.id.tv_medicine_type);
        textView_meddose = findViewById(R.id.tv_dose_details);
        textView_startdate = findViewById(R.id.tv_startdate);
        textView_enddate = findViewById(R.id.tv_enddate);

        imageButton_delete = findViewById(R.id.iv_delete_med);


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String medtime = sharedPreferences.getString(KEY_MEDTIME, null);
        String medname = sharedPreferences.getString(KEY_MEDNAME, null);
        String medtype = sharedPreferences.getString(KEY_MEDTYPE, null);
        String meddose = sharedPreferences.getString(KEY_MEDDOSE, null);
        String startdate = sharedPreferences.getString(KEY_STARTDATE, null);
        String enddate = sharedPreferences.getString(KEY_ENDDATE, null);

        if (medtime != null || medname != null || medtype != null || meddose != null || startdate != null || enddate != null) {



            textView_medtime.setText(medtime);
            textView_medname.setText(medname);
            textView_medtype.setText(medtype);
            textView_meddose.setText(meddose);
            textView_startdate.setText(startdate);
            textView_enddate.setText(enddate);
        }

            data = new ArrayList<String>();
            data.add(medtime);
            data.add(medname);
            data.add(medtype);
            data.add(meddose);
            data.add(startdate);
            data.add(enddate);



      /*  imageButton_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();


            }
        });*/



            Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(intent);
            finish();

    }


}
