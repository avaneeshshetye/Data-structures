package com.Avaneesh;
import java.time.LocalTime;


public class AppointmentDetails {



    private String visitor_name;
    private int appointment_type;
    private  LocalTime appointment_time;

    AppointmentDetails(String v, int an, int hours, int min)
    {
         visitor_name = v;
         appointment_type = an;
         appointment_time = LocalTime.of(hours, min);

    }
    int compareTo(LocalTime objTime){
        int retVal = appointment_time.compareTo(objTime);
        return retVal;

    }
    int compareTo(int hours, int min){
        LocalTime objTime = LocalTime.of(hours, min);
        return appointment_time.compareTo(objTime);

    }


    void dump(){
        String sApptType = "Invalid";
        if(appointment_type == 1)
        {
            sApptType = "OPD";
        }
        else if(appointment_type == 2)
        {
            sApptType = "Emergency";

        }
        else if(appointment_type == 3)
        {
            sApptType = "MR";
        }
        System.out.println("Visitor name: " + visitor_name + " Type: " + sApptType + "   Time: " + appointment_time.toString());
    }




}
