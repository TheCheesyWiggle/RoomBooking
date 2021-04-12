
package roombooking;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static roombooking.Calendar.Date;
import static roombooking.RoomBooking.Bookinglist;


public class Cleaner {
    
    private static ArrayList<String> CleaningSchedule = new ArrayList();
    private static ArrayList<Booking> DesiredDay = new ArrayList();
    
    public static void Menu(){
        //setups table
        SetupCleaningSchedule();
        //Searches booking from the desired date 
        SearchBoookings(Date());
        //fills the slots to display which are already booked
        FillCleaningSchedule();
        //outputs table
        DisplayCleaningSchedule();
        
        
    }
    
    //setups table for later use
    public static void SetupCleaningSchedule(){
        CleaningSchedule.add(">----------------------------<");
        CleaningSchedule.add("      Cleaning Schedule       ");
        CleaningSchedule.add(">----------------------------<");
        CleaningSchedule.add("     Time     |      Room    |");
        CleaningSchedule.add("------------------------------");
    }
        
    //displays the schedule to the user
    public static void DisplayCleaningSchedule(){
        //checks if arraylist is empty
        if(DesiredDay.isEmpty()){
            CleaningSchedule.add("     N\\A      |      N\\A     |");
            for (int i = 0; i < CleaningSchedule.size(); i++) {
                System.out.println(CleaningSchedule.get(i));
            }
        }
        if(!DesiredDay.isEmpty()){
            //loops through list if its not empty
            for (int i = 0; i < CleaningSchedule.size(); i++) {
                System.out.println(CleaningSchedule.get(i));
            }
        }
        System.out.println(">----------------------------<");
    }
    
    //fills the slots to display which are already booked
    public static void FillCleaningSchedule(){
        //checks if arraylist is empty
        if(!DesiredDay.isEmpty()){
            //loops through list if its not empty
            for (int i = 0; i < DesiredDay.size(); i++) {
                //gets room 
                int room = DesiredDay.get(i).getRoom();
                //gets slot
                int slot = DesiredDay.get(i).getSlot();
                //cadds to the schedule accordingly
                
                CleaningSchedule.add(SlotTranslation(slot,room)+RoomTranslation(room));  
            }
            
        }
        //clears array so it can be used again
        DesiredDay.clear(); 
        
    }  
            
    //searches bookings by date
    //and collects all bookings on desired date in an array
    public static void SearchBoookings(Date DesiredDate){
        //checks if arraylist is empty
        if(!Bookinglist.isEmpty()){
            //loops through the list
            for (int i = 0; i < Bookinglist.size(); i++) {
                //gets all bookings with the same date
                if(DesiredDate.equals(Bookinglist.get(i).getDate())){
                    //puts all bookings with the same date in a different array list
                    DesiredDay.add(Bookinglist.get(i));
                }
            }
        }
    }
    
        //get integer input
    public static int IntInput(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
    //gets users desired booking date
    public static Date Date(){
        //gets users desired booking date
        System.out.println("Enter the date you are looking for");
        System.out.println("Please enter year, month and day (format\"yyyy-MM-dd\") and press enter after each number: ");
        int year = IntInput();
        int month = IntInput();
        int day = IntInput();
        
        Date bookingDate = new Date(year-1900, month-1, day,0,0,0);   
        return bookingDate;
    }
    
    public static String SlotTranslation(int slot,int room){
        switch(room){
            case 1:
                switch(slot){
                    case 1:
                        return "    8-8.30    |";
                    case 2:
                        return "    9-11.30   |";
                    case 5:
                        return "    12-14.30  |";
                    case 4:
                        return "    15-17.30  |";
                }
            case 2:
                switch(slot){
                    case 1:
                        return "      8-9     |";
                    case 2:
                        return "    9.30-12   |";
                    case 5:
                        return "    12.30-15  |";
                    case 4:
                        return "    15.30-18  |";
                }
            case 3:
                switch(slot){
                    case 1:
                        return "    8-9.30    |";
                    case 2:
                        return "    10-13.30  |";
                    case 5:
                        return "    13-15.30  |";
                    case 4:
                        return "    16-18.30  |";
                }
            case 4:
                switch(slot){
                    case 1:
                        return "      8-10    |";
                    case 2:
                        return "    10.30-13  |";
                    case 5:
                        return "    13.30-16  |";
                    case 4:
                        return "    16.30-19  |";
                }
            case 5:
                switch(slot){
                    case 1:
                        return "    8-10.30   |";
                    case 2:
                        return "    11-13.30  |";
                    case 5:
                        return "    14-16.30  |";
                    case 4:
                        return "    17-19.30  |";
                }
        }
        return "Error";
    }
            
    public static String RoomTranslation(int room){
        switch(room){
            case 1:
                return "       1      |";
            case 2:
                return "       2      |";
            case 3:
                return "       3      |";
            case 4:
                return "       4      |";
            case 5:
                return "       5      |";
        }
        return "Error";
    }
}
