package com.example.medigo;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Toolbar tb;

    ImageView i1;
    TextView t1,dt;
    ImageButton ib1,ib2;

    FloatingActionButton fb;
    DatePicker cv;
    CollapsingToolbarLayout ctb;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd", Locale.getDefault());





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tb = findViewById(R.id.toolbar);
        dt=findViewById(R.id.datetext);
        
        i1 = findViewById(R.id.medimage);
        t1 = findViewById(R.id.textnomed);

        ib2 = findViewById(R.id.imagebutton2);
        fb = findViewById(R.id.floatadd);



        Date current = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM d");

        String formattedDate = dateFormat.format(current);
        tb.setTitle(formattedDate);
        dt.setText(formattedDate);

        Typeface typeface3 = Typeface.createFromAsset(
                getAssets(),
                "NunitoSans-Regular.ttf");
        dt.setTypeface(typeface3);


        Date date = new Date();









        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putInt("DATE", 2);
                DialogFragment datePicker3 = new DatePickerFragment();
                datePicker3.setArguments(bundle);
                datePicker3.show(getFragmentManager(), "date picker");
            }
        });




          fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);finish();
            }
        });


    }

    public void onDateSet(DatePicker datePicker, int year, int month, int day){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        String currentDateString = dateFormat.format(c.getTime());
        tb = findViewById(R.id.toolbar);
        tb.setTitle(currentDateString);
    }


}

