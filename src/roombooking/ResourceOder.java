
package roombooking;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static roombooking.Cleaner.Date;
import static roombooking.Cleaner.DisplayCleaningSchedule;
import static roombooking.Cleaner.FillCleaningSchedule;
import static roombooking.Cleaner.SearchBoookings;
import static roombooking.Cleaner.SetupCleaningSchedule;
import static roombooking.RoomBooking.Bookinglist;


public class ResourceOder {
    
    private static ArrayList<Booking> DesiredDay = new ArrayList();
    private static ArrayList<String> ResourceSchedule = new ArrayList();
    
    public static void Menu(){
        System.out.println(">----------------------------<");
        System.out.println(">         Resources          <");
        System.out.println(">----------------------------<");
        System.out.println("Pens\nPaper\nProjectors\nComputers");
        System.out.println("Would you like to:\n1)View Resource orders\n2)Order Resources\n3)Quit");
        int choice = IntInput();
        switch(choice){
            case 1:
                viewResources();
                break;
            case 2:
                orderResources();
                break;
            case 3:
                RoomBooking.entry();
                break;        
        }
    }
    //get integer input
    public static int IntInput(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    } 
    
    //lets catring see 
}
