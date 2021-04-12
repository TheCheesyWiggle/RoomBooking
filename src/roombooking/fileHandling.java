
package roombooking;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class fileHandling {
    
    public static String folderDirectory = System.getProperty("user.dir");
    
    public static void writeFileAccounts(ArrayList<Account> Accountlist) {
        folderDirectory = System.getProperty("user.dir") + "\\Accountlist.txt";
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < Accountlist.size(); i++) {
                printToFile.println(Accountlist.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static ArrayList<Account> readFileAccounts() {
        
        folderDirectory = System.getProperty("user.dir") + "\\Accountlist.txt";
        ArrayList<Account> Accountlist = new ArrayList<>();
        String lineFromFile;
         
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] AccountDetails = lineFromFile.split(",");
                Account myAccount = new Account(AccountDetails[0],AccountDetails[1],AccountDetails[2],AccountDetails[3]);
                Accountlist.add(myAccount);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Accountlist;
    }
    
    public static void writeFileBookings(ArrayList<Booking> Bookinglist) {
        folderDirectory = System.getProperty("user.dir") + "\\Bookinglist.txt";
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < Bookinglist.size(); i++) {
                printToFile.println(Bookinglist.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static ArrayList<Booking> readFileBookings() {
        
        folderDirectory = System.getProperty("user.dir") + "\\Bookinglist.txt";
        ArrayList<Booking> Bookinglist = new ArrayList<>();
        String lineFromFile;
         
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] BookingDetails = lineFromFile.split(",");
                //create formatter to translate string into a date object
                SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                //creates booking object
                Booking myBooking = new Booking(BookingDetails[0],BookingDetails[1],Integer.parseInt(BookingDetails[2]),Integer.parseInt(BookingDetails[3]),formatter.parse(BookingDetails[4]));
                Bookinglist.add(myBooking);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Bookinglist;
    }
    
    public static void writeFileResources(ArrayList<Resources> Resourcelist) {
        folderDirectory = System.getProperty("user.dir") + "\\Resourcelist.txt";
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < Resourcelist.size(); i++) {
                printToFile.println(Resourcelist.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static ArrayList<Resources> readFileResources() {
        
        folderDirectory = System.getProperty("user.dir") + "\\Resourcelist.txt";
        ArrayList<Resources> Resourcelist = new ArrayList<>();
        String lineFromFile;
         
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] ResourceDetails = lineFromFile.split(",");

                //creates booking object
                Resources myResources = new Resources(1/*pens*/,1/*paper*/,1/*projector*/,1/*computer*/,1/*room*/,1/*slot*/);
                Resourcelist.add(myResources);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Resourcelist;
    }
}
