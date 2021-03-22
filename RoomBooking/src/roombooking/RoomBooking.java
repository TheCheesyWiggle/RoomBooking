
package roombooking;

import java.util.ArrayList;
import java.util.Scanner;


public class RoomBooking {

    public static ArrayList<Account> Accountlist = new ArrayList<>();
    public static ArrayList<Booking> Bookinglist = new ArrayList();
    public static Account LoggedInAcc;
    
    public static void main(String[] args) {
        Accountlist = fileHandling.readFileAccounts();
        Bookinglist = fileHandling.readFileBookings();
        entry();
    }
    
    //  login/signup
    public static void entry(){
        //login screen
        Scanner input = new Scanner(System.in);
        int ans = -1;
        while((ans<0)||(ans>6)){
            System.out.println("1)Login \n2)Sign up \n3)Quit\n4)Resources\n5)Quit");
            ans = input.nextInt();
        }
        switch(ans){
            case 1:
                if(LoginCode.login()==true){
                    System.out.println("Welcome");
                    Calendar.PreMenu();
                }
                else{
                    entry();
                }
                break;
            case 2:
                LoginCode.signup();
                entry();
                break;
            case 3:
                //cleaning schedule
                break;
            case 4:
                //order resources
                break;
            case 5:
                System.exit(0);
                break;
                
        }
    }
    
}
