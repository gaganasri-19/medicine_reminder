package com.example.medigo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.Viewholder>{
        private LayoutInflater layoutInflater;

        private Context context;
        private ArrayList<MedModel> data;
        int lastpos=0;

        public Adapter(Context context, ArrayList<MedModel> data){
            this.context=context;

            this.data=data;
        }

    public void replaceData(ArrayList<MedModel> data){
        this.data=data;
        notifyDataSetChanged();
    }
        @NonNull
        @Override
        public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_medicine_display,parent,false);
            return new Viewholder(view);
        }




        @Override
        public void onBindViewHolder(@NonNull Adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {

                      Log.d("onBindViewHolder",data.size()+"");
                      final MedModel model = data.get(position);
                      if(model==null){return;}
                      holder.medtime.setText(model.gettime());
            MedModel model2 = data.get(position);
                      holder.medname.setText(model2.getname());
            MedModel model3 = data.get(position);
                      holder.medtype.setText(model3.gettype());
            MedModel model4 = data.get(position);
                      holder.dosedetails.setText(model4.getdose());
            MedModel model5 = data.get(position);
                      holder.startdate.setText(model5.getstartdate());
            MedModel model6 = data.get(position);
                      holder.enddate.setText(model6.getenddate());
                      lastpos=position;

        }






        @Override
        public int getItemCount() {
            return (null!=data && !data.isEmpty())?data.size():0;
        }


    public void notifyData(ArrayList<MedModel> data) {
        Log.d("notifyData ", data.size() + "");
        this.data = data;
        notifyDataSetChanged();
    }

        public class Viewholder extends RecyclerView.ViewHolder{

            private TextView medtime,medname,medtype,dosedetails,startdate,enddate;
            public Viewholder(@NonNull View itemView) {
                super(itemView);
                medtime=itemView.findViewById(R.id.tv_med_time);
                medname=itemView.findViewById(R.id.tv_medicine_name);
                medtype=itemView.findViewById(R.id.tv_medicine_type);
                dosedetails=itemView.findViewById(R.id.tv_dose_details);
                startdate=itemView.findViewById(R.id.tv_startdate);
                enddate=itemView.findViewById(R.id.tv_enddate);


            }
        }

    }
