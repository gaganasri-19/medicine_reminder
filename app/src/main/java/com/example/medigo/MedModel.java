package com.example.medigo;

import java.util.ArrayList;

public class MedModel {
     String medtime,medname,medtype,meddose,startdate,enddate;

    public MedModel(String medtime,String medname,String medtype,String meddose,String startdate,String enddate){
        this.medtime=medtime;
        this.medname=medname;
        this.medtype=medtype;
        this.meddose=meddose;
        this.startdate=startdate;
        this.enddate=enddate;
    }

    public String gettime(){
        if(MainActivity4.count==0){return MedicineDisplay.data.get(0);}
        return medtime;
    }

    public void settime(String medtime){
        this.medtime=medtime;
    }

    public String getname(){
        if(MainActivity4.count==0){return MedicineDisplay.data.get(1);}
        return medname;
    }

    public void setname(String medname){
        this.medname=medname;
    }


    public String gettype(){
        if(MainActivity4.count==0){return MedicineDisplay.data.get(2);}
        return medtype;
    }

    public void settype(String medtype){
        this.medtype=medtype;
    }


    public String getdose(){
        if(MainActivity4.count==0){return MedicineDisplay.data.get(3);}
        return meddose;
    }

    public void setdose(String meddose){
        this.meddose=meddose;
    }


    public String getstartdate(){
        if(MainActivity4.count==0){return MedicineDisplay.data.get(4);}
        return startdate;
    }

    public void setstartdate(String startdate){
        this.startdate=startdate;
    }


   /* public String getenddate(){
        return MedicineDisplay.data.get(5);
    }*/
    public String getenddate(){
        if(MainActivity4.count==0){return MedicineDisplay.data.get(5);}
        return enddate;
    }

    public void setenddate(String enddate){
        this.enddate=enddate;
    }





}
