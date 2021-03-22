
package roombooking;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import static roombooking.RoomBooking.Bookinglist;

public class Calendar {
    
    private static String[][] BookingTable = new String[5][6];
    private static ArrayList<Booking> DesiredDay = new ArrayList();
    
   
    //setups variables for later use
    public static void SetupBookingTable(){
        
        //creates the labels so the user knows what they are booking
        BookingTable[0][0]="    Room >>>  |";
        
        BookingTable[1][0]="      8-10    |";
        BookingTable[2][0]="  10.30-12.30 |";
        BookingTable[3][0]="     13-15    |";
        BookingTable[4][0]="  15.30-17.30 |";
        
        BookingTable[0][1]="      1       |";
        BookingTable[0][2]="      2       |";
        BookingTable[0][3]="      3       |";
        BookingTable[0][4]="      4       |";
        BookingTable[0][5]="      5       |";
        
        //loops through to create the rest of the table
        for(int slot = 1;slot<5;slot++){
            for(int room = 1;room<6;room++){
                BookingTable[slot][room] = "     free     |";
            }
        }
        
        
    }
    
    //displays the booking table to the user
    public static void DisplayBookingTable(){
        //loops through array
        //looops through slots first
        for(int slot = 0;slot<5;slot++){
            //loops through rooms second
            for(int room = 0;room<6;room++){
                //outputs the values
                System.out.print(BookingTable[slot][room]);
            }
            System.out.println();
        }
    }
    
    //fills the slots to display which are already booked
    public static void FillBookingTable(){
        //checks if arraylist is empty
        if(!DesiredDay.isEmpty()){
            //loops through list if its not empty
            for (int i = 0; i < DesiredDay.size(); i++) {
                //gets room 
                int room = DesiredDay.get(i).getRoom();
                //gets slot
                int slot = DesiredDay.get(i).getSlot();
                //changes the booking table accordingly
                BookingTable[slot][room]="    taken     |";
            }
            
        }
        //clears array so it can be used again
        DesiredDay.clear(); 
        
    }  
            
    //searches bookings by date
    //and collects all bookings on dired ddate in an array
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
    
    //creates the booking for the user
    public static void CreateBooking(Date DesiredDate){
        //get room number
        System.out.println("Please enter the number of the room you would like to book");
        int room = IntInput();
        
        //gets slot number
        System.out.println("Please enter the number of the slot you would like to book");
        System.out.println("Slot 1: 8-10\nSlot 2: 10:30-12:30\nSlot 3: 13-15\nSlot 4: 15.30-17.30");
        int slot = IntInput();
        
        //gets firtsname and username
        String name = RoomBooking.LoggedInAcc.getFullName();
        String username =RoomBooking.LoggedInAcc.getUsername();
        
        //checks if booking is valid
        if(ValidBooking(username,room,slot,DesiredDate) == false){
            //tells user and error has occurred
            System.out.println("Error: Something when wrong please try again");
            //suggest what its could be
            System.out.println("Please make sure this booking slot is avaible and that you havent booked any other rooms for this time slot");
            PreMenu();
        }
        
        //registers booking
        Booking myBooking = new Booking(name,username,room,slot,DesiredDate);
        Bookinglist.add(myBooking);
        fileHandling.writeFileBookings(Bookinglist);
        
    }
    
    //validates booking
    public static boolean ValidBooking(String username,int room,int slot,Date DesiredDate){
        SearchBoookings(DesiredDate);
        if(!DesiredDay.isEmpty()){
            //loops through list if its not empty
            for (int i = 0; i < DesiredDay.size(); i++) {
                //gets desired room 
                int DesiredRoom = DesiredDay.get(i).getRoom();
                //gets desired slot
                int DesiredSlot = DesiredDay.get(i).getSlot();
                //gets slot holder username
                String SlotUsername = DesiredDay.get(i).getUsername();
                //checks if someone else has already book this slot afor this room
                if((DesiredRoom == room)&&(DesiredSlot == slot)){
                    //clears array list so it can be used again
                    DesiredDay.clear();
                    return false;
                }
                //cheecks if the user already has a different room booked at this slot
                if((DesiredSlot == slot)&&(SlotUsername.equals(username))){
                    //clears array list so it can be used again
                    DesiredDay.clear();
                    return false;
                }
            }
        }
        //clears array list so it can be used again
        DesiredDay.clear();
        
        return true;
    }
    
    //get integer input
    public static int IntInput(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
    //gets users desired booking date
    public static Date Date(){
        //gets users desired booking date
        System.out.println("Please enter year, month and day (format\"yyyy-MM-dd\") and press enter after each number: ");
        int year = IntInput();
        int month = IntInput();
        int day = IntInput();
        
        Date bookingDate = new Date(year-1900, month-1, day,0,0,0);   
        return bookingDate;
    }
    
    //displays menu
    public static void MenuOut(){
        System.out.println(">--------------------------------<\n         Room Reservations         \n----------------------------------");
        System.out.println("Room | Capacity | Wheelchair Acess\n----------------------------------");
        System.out.println("  1  |    2     |        no\n  2  |    4     |        no\n  3  |    8     |        no\n  4  |    15    |        yes\n  5  |    50    |        no");
        System.out.println("Please enter the date you would like to book");
    }
    
    //extension of the menu with the desired date
    public static void PreMenu(){
        //displays menu
        MenuOut();
        //gets users desired date and runs  it throught the availability method
        Menu(Date());
    }    
    
    //show user availability on their desired date and creates the booking
    public static void Menu(Date DesiredDate){
        //setups variables
        SetupBookingTable();
        //searches bookings by date
        //and collects all bookings on dired ddate in an array
        SearchBoookings(DesiredDate);
        //fills the slots to display which are already booked
        FillBookingTable();
        //displays the booking table to the user
        DisplayBookingTable();
        //creates booking
        CreateBooking(DesiredDate);
        
        
    }
    
    
    //edit bookings
    //delete bookings
    //clean up add bookings
}
