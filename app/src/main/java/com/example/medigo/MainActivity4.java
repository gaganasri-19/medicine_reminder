package com.example.medigo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity4 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{
    private static ArrayList<MedModel> mdataa;



    private RecyclerView rcv;
public static int count=0;
    static final int START_DATE = 1;
    static final int END_DATE = 2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_MEDTIME="medtime";
    int cur = 2;
    private ArrayList <MedicineModel> dataa;


    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fab=(FloatingActionButton) findViewById(R.id.fabb);




        ActionBar ab=getSupportActionBar();
        ab.setTitle("MY MEDICINE LIST");


            createExampleList();
            buildRecyclerView();

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String medtime = sharedPreferences.getString(KEY_MEDTIME, null);






      fab.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              count++;
              Dialog dialog=new Dialog(MainActivity4.this);
                 dialog.setContentView(R.layout.addmed);

              ImageButton fb = dialog.findViewById(R.id.futton);
              EditText etstart = dialog.findViewById(R.id.edit10);
              EditText etend = dialog.findViewById(R.id.editt20);

              TextView t1 = findViewById(R.id.textView3);
              TextView t4 = findViewById(R.id.textView4);
              TextView t2 = findViewById(R.id.textView5);




              EditText et1 = dialog.findViewById(R.id.editPersonName);







              EditText time_in =dialog. findViewById(R.id.editt4);

              EditText et2 = dialog.findViewById(R.id.editPersonName2);

              /*time_in.setInputType(InputType.TYPE_NULL);

              etstart.setInputType(InputType.TYPE_NULL);
              etend.setInputType(InputType.TYPE_NULL);*/

              Spinner sp1 =dialog. findViewById(R.id.spinner3);
              Spinner sp2 = dialog.findViewById(R.id.spinner4);



              String[] arraySpinner1 = new String[]{
                      "Tablets", "Capsules", "Injection", "Syrup", "Adhesive", "Cream", "Dressing", "Drops", "Lotion", "Powder", "Spray", "Other"
              };


              ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity4.this,
                      android.R.layout.simple_spinner_item, arraySpinner1);
              adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
              sp1.setAdapter(adapter1);

              String[] arraySpinner2 = new String[]{
                      "Once a day", "Twice a day", "3 times a day", "Custom"
              };


              ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity4.this,
                      android.R.layout.simple_spinner_item, arraySpinner2);
              adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
              sp2.setAdapter(adapter2);

              CheckBox cb=dialog.findViewById(R.id.every_day);
              CheckBox cb1=dialog.findViewById(R.id.dv_monday);
              CheckBox cb2=dialog.findViewById(R.id.dv_tuesday);
              CheckBox cb3=dialog.findViewById(R.id.dv_wednesday);
              CheckBox cb4=dialog.findViewById(R.id.dv_thursday);
              CheckBox cb5=dialog.findViewById(R.id.dv_friday);
              CheckBox cb6=dialog.findViewById(R.id.dv_saturday);
              CheckBox cb7=dialog.findViewById(R.id.dv_sunday);
              cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                      if (b) {
                          cb1.setChecked(true);
                          cb2.setChecked(true);
                          cb3.setChecked(true);
                          cb4.setChecked(true);
                          cb5.setChecked(true);
                          cb6.setChecked(true);
                          cb7.setChecked(true);

                      } else {
                          cb1.setChecked(false);
                          cb2.setChecked(false);
                          cb3.setChecked(false);
                          cb4.setChecked(false);
                          cb5.setChecked(false);
                          cb6.setChecked(false);
                          cb7.setChecked(false);
                      }
                  }
              });

              Date currentTime = Calendar.getInstance().getTime();
              DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
              Date date = new Date();
              etstart.setText(dateFormat.format(date));

              /*time_in.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                      DialogFragment timePicker = new TimePickerFragment();
                      timePicker.show(getFragmentManager(), "Time Picker");

                  }
              });

              etend.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Bundle bundle = new Bundle();
                      bundle.putInt("DATE", 2);
                      DialogFragment datePicker2 = new DatePickerFragment();
                      datePicker2.setArguments(bundle);
                      datePicker2.show(getFragmentManager(), "date picker");

                  }
              });*/


              fb.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      String medname = et1.getText().toString();
                      String medtype = sp1.getSelectedItem().toString();

                      String medtimes = sp2.getSelectedItem().toString();

                      String meddose = et2.getText().toString();

                      String time = time_in.getText().toString();

                      String startdate = etstart.getText().toString();
                      String enddate = etend.getText().toString();
                      RecyclerView.Adapter adapter;

                      if(medname.equals("") || medname.equals("") || time.equals("")  || enddate.equals("")){
                          Toast.makeText(getApplicationContext(), "Fill all the details", Toast.LENGTH_LONG).show();}
                      else{
                           ArrayList<MedModel> newd=new ArrayList();
                            mdataa.add(new MedModel(time,medname,medtype,meddose,startdate,enddate));


                            adapter= new Adapter(getApplicationContext(), mdataa) ;
                            adapter.notifyItemInserted(mdataa.size()-1);
                            rcv.scrollToPosition(mdataa.size()-1);
                            dialog.dismiss();



                      }
                  }
              });
              dialog.show();
              }

      });

    }


private void createNotificationChannel(){
        if(Build.VERSION_CODES.O <= Build.VERSION.SDK_INT){
            CharSequence name="LemubitReminderChannel";
            String description="Channel for Lemubit Reminder";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("notifyLemubit",name,importance);
            channel.setDescription(description);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

    }
}


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
        Dialog dialog=new Dialog(MainActivity4.this);
        dialog.setContentView(R.layout.addmed);
        EditText time_in = dialog.findViewById(R.id.editt4);
        String pa = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE,minutes);
        int hour = calendar.get(Calendar.HOUR);
        int minute=calendar.get(Calendar.MINUTE);
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
        Dialog dialog=new Dialog(MainActivity4.this);
        dialog.setContentView(R.layout.addmed);

            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, day);
            String currentDateString = DateFormat.getDateInstance(DateFormat.MEDIUM).format(c.getTime());
            EditText etend = dialog.findViewById(R.id.editt20);
            etend.setText(currentDateString);





    }
    public void insertItem(){

        mdataa.add(new MedModel("9:00 am","Dolo","Medicine","1.0","01-01-9090","10-10-8090"));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RecyclerView rcv=findViewById(R.id.medicine_list);
        RecyclerView.Adapter adapter=new Adapter(this,mdataa);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void createExampleList(){
        mdataa=new ArrayList<>();

        mdataa.add(new MedModel("9:00 am","Dolo","Medicine","1.0","01-01-9090","10-10-8090"));

    }
    public void buildRecyclerView(){
        rcv=findViewById(R.id.medicine_list);
        Adapter adapter=new Adapter(this,mdataa);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);


        long alatime=System.currentTimeMillis();
        long tens=1000*10;
        createNotificationChannel();
        Intent intent=new Intent(MainActivity4.this,ReminderBroadcast.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity4.this,0,intent,0);
        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,alatime+tens,pendingIntent);







    }
}