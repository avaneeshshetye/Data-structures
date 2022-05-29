package com.Avaneesh;

import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Scanner;


public class testapplication {

    public static void main(String[] args) {

        LinkedPositionalList<com.Avaneesh.AppointmentDetails> myAppts = new LinkedPositionalList <com.Avaneesh.AppointmentDetails> ();
        System.out.println(myAppts.isEmpty());
        //myAppts.dump();


        com.Avaneesh.AppointmentDetails obj_app1 = new com.Avaneesh.AppointmentDetails( "Prashant", 1,15,10);
        Position<com.Avaneesh.AppointmentDetails> firstPos1 = myAppts.addFirst(obj_app1); //Adding first element
        //myAppts.dump();


        com.Avaneesh.AppointmentDetails obj_app2 = new com.Avaneesh.AppointmentDetails( "Avaneesh", 3,9,20);
        Position<com.Avaneesh.AppointmentDetails> firstPos2 = myAppts.addFirst(obj_app2); //Adding first element
        myAppts.dump();

        // create Scanner class object to take input from the user for initializing LocalTime
        Scanner sc = new Scanner(System.in);

        do {


            // get input from used for initializing time1
            System.out.println("Enter appointment details:");
            Boolean type_done = false;
            int appointment_type = 0;
            do {
                System.out.println("Enter Appointment type(0 for exit/ 1 for OPD/2 for Emergency/3 for MR):");

                appointment_type = sc.nextInt();

                if (appointment_type == 0) {
                    System.out.println("Thank you for using appointment manager. Have a good day!");
                    break;
                } else if (appointment_type == 1) {
                    System.out.println("You chose OPD");
                    type_done = true;
                } else if (appointment_type == 2) {
                    System.out.println("You chose Emergency!");
                    type_done = true;
                } else if (appointment_type == 3) {
                    System.out.println("You chose MR");
                    type_done = true;
                } else {
                    System.out.println("Try again");
                }
                //System.out.println("Value of done: " + type_done);
            } while (type_done == false);

            if (appointment_type == 0) {
                break;
            }
            System.out.println("Enter visitor name:");
            String visitor_name = sc.nextLine();
            System.out.println(visitor_name);

            Boolean hour = true;
            int hour1;
            do {
                System.out.println("Enter hours:");
                hour1 = sc.nextInt();
                if (hour1 >= 9 && hour1 < 18) {
                    hour = true;

                } else if (hour1<9){
                    System.out.println("Please pick a slot between our working hours 9 to 18");
                    hour = false;
                }
                else if(hour1 > 18 && hour1 < 24){
                    System.out.println("Please pick a slot between our working hours 9 to 18");
                    hour = false;
                }
                else if(hour1 > 24){
                    System.out.println("Please enter a valid hour ");
                }
                else {
                    System.out.println("Slot not available, Please try again");
                    hour = false;


                }
            } while (hour == false);

            Boolean min = false;
            int min1;
            do {
                System.out.println("Enter minutes:");
                min1 = sc.nextInt();


                if (min1 > 0 && min1 < 60) {
                    min = true;
                } else  {
                    System.out.println("Invalid minute, try again");
                    min = false;
                }
            } while (min == false);

            //System.out.println("Visitor name: " + visitor_name + "Appointment type: " + "" + appointment_type + " " + "Hours: " + " " + hour1 + " " + "Minutes: " + min);
           if( myAppts.addAppointment(visitor_name, appointment_type, hour1, min1) == null){
               System.out.println("Appointment exists");
           }
            myAppts.dump();
        }while(true);
        // close scanner class object

    }
}
