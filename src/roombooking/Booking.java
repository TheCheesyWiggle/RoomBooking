
package roombooking;

import java.util.Date;


public class Booking {
    
    private String name;
    private String username;
    private int room;
    private int slot;
    private Date date;

    
    public String toString() {
        return name + "," + username + "," + room + "," + slot + "," + date;
    }

    public Booking(String name, String username, int room, int slot, Date date) {
        this.name = name;
        this.username = username;
        this.room = room;
        this.slot = slot;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    
    
}
