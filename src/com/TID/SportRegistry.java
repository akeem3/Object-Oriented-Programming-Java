package com.TID;

public class SportRegistry {
    private int ID;
    private SportOptions SportOptions;
    private Days Day;
    private int Time;
    private boolean Paid;
    private studentUsers Owner;

    public SportRegistry (int ID, SportOptions SportOptions, Days Day, int Time, boolean p, studentUsers Owner) {
        this.ID = ID;
        this.SportOptions = SportOptions;
        this.Day = Day;
        this.Time = Time;
        this.Paid = p;
        this.Owner = Owner;

    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;

    }
    public SportOptions getSportOptions() {
        return SportOptions;
    }
    public void setSportOptions(SportOptions SportOptions) {
        this.SportOptions = SportOptions;

    }
    public Days getDay() {
        return Day;
    }
    public void setDay(Days Day) {
        this.Day = Day;
    }
    public int getTime() {
        return Time;
    }
    public void setTime(int Time) {
        this.Time = Time;
    }
    public boolean isPaid() {
        return Paid;
    }
    public void setPaid(boolean Paid) {
        this.Paid = Paid;
    }
    public studentUsers getOwner() {
        return Owner;
    }
    public void setOwner(studentUsers Owner) {
        this.Owner = Owner;
    }

}
