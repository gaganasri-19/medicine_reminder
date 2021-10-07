package com.example.medigo;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;




public class DatePickerFragment extends DialogFragment  {

    static final int START_DATE=1;
    static final int END_DATE=2;
    static final int CURRENT_DATE=3;
    static int cur=0;

    private int mChosenDate;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd=new DatePickerDialog(getActivity(),R.style.AppDialogTheme,(DatePickerDialog.OnDateSetListener)getActivity(),year,month,day);
        dpd.getDatePicker().setMinDate(c.getTimeInMillis());
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            mChosenDate=bundle.getInt("DATE",1);
        }
        switch(mChosenDate){
            case START_DATE:
                cur=START_DATE;
                return dpd;

            case END_DATE:
                cur=END_DATE;
                return dpd;

            case CURRENT_DATE:
                cur=CURRENT_DATE;
                return dpd;
        }
        return null;

    }





    }



