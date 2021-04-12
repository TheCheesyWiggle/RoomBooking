
package roombooking;

import java.util.Scanner;
import java.util.ArrayList;


public class LoginCode {
    
    public static boolean login(){  
        //add try catch
        Scanner input = new Scanner(System.in);
        //gets username and password
        System.out.println("Please enter username");
        String username = input.next();
        System.out.println("Please enter password");
        String password = input.next();

        
        int index = UsernameSearch(username);
        if(!(index == -1)){
            String realPassword = RoomBooking.Accountlist.get(index).getPassword();

            if(password.equals(realPassword)){
                RoomBooking.LoggedInAcc = RoomBooking.Accountlist.get(index);
                return true;
            }
        }
            
        System.out.println("Incorrect Username or Password");
        
        return false;
    }
    
    public static void signup(){
        //add try catch
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter username");
        String username = input.next();
        //makes sure no 2 the same usernames are used
        while(!(UsernameSearch(username)==-1)){
            System.out.println("Username taken please enter new username");
            username = input.next();
        }

        System.out.println("Please enter password");
        String password = input.next();
        
        System.out.println("Please enter email");
        String email = input.next().toLowerCase();
        
        //makes sure the email address isnt taken 
        //also checks if email has an @ in it
        while(validEmail(email)==false){
            System.out.println("Invalid email please enter new email");
            validEmail(username = input.next());
        }
        
        System.out.println("Please enter fullname");
        String fullName = input.next();

        //registers account
        Account myAccount = new Account(username,password,email,fullName);
        RoomBooking.Accountlist.add(myAccount);
        fileHandling.writeFileAccounts(RoomBooking.Accountlist);
    }
    
    public static int UsernameSearch(String username){
       //loops through accounts to make sure the name isnt taken
        if(!RoomBooking.Accountlist.isEmpty()){
            for (int i = 0; i < RoomBooking.Accountlist.size(); i++) {
                if(username.equals(RoomBooking.Accountlist.get(i).getUsername())){
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static boolean validEmail(String email){
        //loops through accounts to make sure the email isnt taken
        if(!RoomBooking.Accountlist.isEmpty()){
            for (int i = 0; i < RoomBooking.Accountlist.size(); i++) {
                if(email.equals(RoomBooking.Accountlist.get(i).getEmail())){
                    return false;
                }
            }
        }
        //regex check
        return (!email.contains(" "))&& email.contains("@");
    }

//gui
    
}
