
package roombooking;

import java.util.Date;


public class Resources {
    private int pens;
    private int paper;
    private int projector;
    private int computer;
    private int room;
    private int slot;

    
    public String toString() {
        return pens + "," + paper + "," +projector+"," + computer+"," +room + "," + slot ;
    }

    public Resources(int pens, int paper, int projector, int computer, int room, int slot) {
        this.pens = pens;
        this.paper = paper;
        this.projector = projector;
        this.computer = computer;
        this.room = room;
        this.slot = slot;
    }

    public int getPens() {
        return pens;
    }

    public void setPens(int pens) {
        this.pens = pens;
    }

    public int getPaper() {
        return paper;
    }

    public void setPaper(int paper) {
        this.paper = paper;
    }

    public int getProjector() {
        return projector;
    }

    public void setProjector(int projector) {
        this.projector = projector;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
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
    

    
    
}
