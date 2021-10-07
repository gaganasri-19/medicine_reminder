package com.example.medigo;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity2 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener {
    private String buttonText;

    static Calendar calendar;
    static final int START_DATE = 1;
    static final int END_DATE = 2;
    int cur = 2;
    static int count = 0;

    JSONObject saved = new JSONObject();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_MEDTIME = "medtime";
    private static final String KEY_MEDNAME = "medname";
    private static final String KEY_MEDTYPE = "medtype";
    private static final String KEY_MEDDOSE = "meddose";
    private static final String KEY_STARTDATE = "startdate";
    private static final String KEY_ENDDATE = "enddate";


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main2);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        AppBarLayout abl = findViewById(R.id.appbar);
        TextView t = findViewById(R.id.textView2);
        TextView t2 = findViewById(R.id.textView5);
        TextView t3 = findViewById(R.id.textView6);
        TextView t7 = findViewById(R.id.textView7);
        TextView t8 = findViewById(R.id.textView8);
        TextView t9 = findViewById(R.id.textView9);
        String a = "date";
        FloatingActionButton fb = findViewById(R.id.floatingActionButton);
        ImageButton b = findViewById(R.id.button3);

        EditText etstart = findViewById(R.id.edit10);
        EditText etend = findViewById(R.id.edit20);

        EditText time_in = findViewById(R.id.edit4);
        time_in.setInputType(InputType.TYPE_NULL);

        etstart.setInputType(InputType.TYPE_NULL);
        etend.setInputType(InputType.TYPE_NULL);

        TextView t1 = findViewById(R.id.textView3);
        TextView t4 = findViewById(R.id.textView4);

        CheckBox c10 = findViewById(R.id.textView10);
        CheckBox c11 = findViewById(R.id.textView11);
        CheckBox c12 = findViewById(R.id.textView12);
        CheckBox c13 = findViewById(R.id.textView13);
        CheckBox c14 = findViewById(R.id.textView14);
        CheckBox c15 = findViewById(R.id.textView15);
        CheckBox c16 = findViewById(R.id.textView16);

        CheckBox c1 = findViewById(R.id.checkBox8);

        TextView t17 = findViewById(R.id.textView17);

        EditText et2 = findViewById(R.id.editPersonName2);


        Typeface typeface = Typeface.createFromAsset(
                getAssets(),
                "NunitoSans-Regular.ttf");
        t1.setTypeface(typeface);

        EditText et1 = findViewById(R.id.editPersonName);
        Typeface typeface2 = Typeface.createFromAsset(
                getAssets(),
                "NunitoSans-Regular.ttf");
        et1.setTypeface(typeface2);


        Typeface typeface3 = Typeface.createFromAsset(
                getAssets(),
                "NunitoSans-Regular.ttf");
        t2.setTypeface(typeface3);

        Typeface typeface4 = Typeface.createFromAsset(
                getAssets(),
                "NunitoSans-Regular.ttf");
        t4.setTypeface(typeface4);


       /* b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity1.class);
                startActivity(intent);
            }
        });*/

        Spinner sp1 = findViewById(R.id.spinner3);
        Spinner sp2 = findViewById(R.id.spinner4);


        String[] arraySpinner1 = new String[]{
                "Tablets", "Capsules", "Injection", "Syrup", "Adhesive", "Cream", "Dressing", "Drops", "Lotion", "Powder", "Spray", "Other"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);


        String[] arraySpinner2 = new String[]{
                "Once a day", "Twice a day", "3 times a day", "Custom"
        };


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                String medname = et1.getText().toString();

                String medtype = sp1.getSelectedItem().toString();

                String medtimes = sp2.getSelectedItem().toString();

                String meddose = et2.getText().toString();

                String time = time_in.getText().toString();

                String startdate = etstart.getText().toString();
                String enddate = etend.getText().toString();

                /*Intent intent=new Intent(MainActivity2.this,MedicineDisplay.class);
                intent.putExtra("medtime",time);
                intent.putExtra("medname",medname);
                intent.putExtra("meddose",meddose);
                startActivity(intent);




                List<String> dayslist = new ArrayList<String>();

                if (c10.isChecked()) {
                    dayslist.add("Monday");
                }
                if (c11.isChecked()) {
                    dayslist.add("Tuesday");
                }
                if (c12.isChecked()) {
                    dayslist.add("Wednesday");
                }
                if (c13.isChecked()) {
                    dayslist.add("Thursday");
                }
                if (c14.isChecked()) {
                    dayslist.add("Friday");
                }
                if (c15.isChecked()) {
                    dayslist.add("Saturday");
                }
                if (c16.isChecked()) {
                    dayslist.add("Sunday");
                } else {
                }


                Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
                finish();*/

                if (medname.equals("") || medname.equals("") || time.equals("") || enddate.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill all the details", Toast.LENGTH_LONG).show();
                } else {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_MEDTIME, time_in.getText().toString());
                    editor.putString(KEY_MEDNAME, et1.getText().toString());
                    editor.putString(KEY_MEDTYPE, sp1.getSelectedItem().toString());
                    editor.putString(KEY_MEDDOSE, et2.getText().toString());
                    editor.putString(KEY_STARTDATE, etstart.getText().toString());
                    editor.putString(KEY_ENDDATE, etend.getText().toString());
                    editor.apply();


                    Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity2.this,MedicineDisplay.class);
                    startActivity(intent);
                    finish();


                }


            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert();

            }
        });

        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();

        time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getFragmentManager(), "Time Picker");
            }
        });


        etstart.setText(dateFormat.format(date));
        /*etstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putInt("DATE",1);
                DialogFragment datePicker1=new DatePickerFragment();
                datePicker1.setArguments(bundle);
                datePicker1.show(getFragmentManager(),"date picker");

            }
        });*/

        etend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("DATE", 2);
                DialogFragment datePicker2 = new DatePickerFragment();
                datePicker2.setArguments(bundle);
                datePicker2.show(getFragmentManager(), "date picker");
            }
        });


        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    c10.setChecked(true);
                    c11.setChecked(true);
                    c12.setChecked(true);
                    c13.setChecked(true);
                    c14.setChecked(true);
                    c15.setChecked(true);
                    c16.setChecked(true);

                } else {
                    c10.setChecked(false);
                    c11.setChecked(false);
                    c12.setChecked(false);
                    c13.setChecked(false);
                    c14.setChecked(false);
                    c15.setChecked(false);
                    c16.setChecked(false);
                }
            }
        });


    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
        EditText time_in = findViewById(R.id.edit4);
        String pa = "";
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minutes);



        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int ap = calendar.get(Calendar.AM_PM);
        if (ap == 0) {
            pa = "AM";
        } else {
            pa = "PM";
        }

        time_in.setText(hour + ":" + minute + " " + pa);



    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        if (cur == START_DATE) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, day);
            String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
            EditText etstart = findViewById(R.id.edit10);
            etstart.setText(currentDateString);
        } else {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, day);
            String currentDateString = DateFormat.getDateInstance(DateFormat.MEDIUM).format(c.getTime());
            EditText etend = findViewById(R.id.edit20);
            etend.setText(currentDateString);


        }


    }

    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Are you sure you want to go back without saving?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
                finish();
            }
        })
                .setNegativeButton("No", null)
                .show();
    }

    public void alert() {
        new AlertDialog.Builder(this).setMessage("Are you sure you want to go back without saving?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
                finish();
            }
        })
                .setNegativeButton("No", null).show();
    }
}















