package com.TID;

public class ModifyRegistry {

    private int newID;
    private SportOptions newSportOptions;
    private Days newDay;
    private int newTime;
    private boolean newPaid;
    private studentUsers Owner;

    public ModifyRegistry (int newID, SportOptions newSportOptions, Days newDay, int newTime, boolean newP, studentUsers Owner) {
        this.newID = newID;
        this.newSportOptions = newSportOptions;
        this.newDay = newDay;
        this.newTime = newTime;
        this.newPaid = newP;
        this.Owner = Owner;

    }
    public int getNewID() {
        return newID;
    }
    public void setNewID(int newID) {
        this.newID = newID;

    }
    public SportOptions getNewSportOptions() {
        return newSportOptions;
    }
    public void setNewSportOptions(SportOptions newSportOptions) {
        this.newSportOptions = newSportOptions;

    }
    public Days getNewDay() {
        return newDay;
    }
    public void setNewDays(Days newDay) {
        this.newDay = newDay;
    }
    public int getNewTime() {
        return newTime;
    }
    public void setNewTime(int newTime) {
        this.newTime = newTime;
    }
    public boolean isNewPaid() {
        return newPaid;
    }
    public void setNewPaid(boolean newPaid) {
        this.newPaid = newPaid;
    }
    public studentUsers getOwner() {
        return Owner;
    }
    public void setOwner(studentUsers Owner) {
        this.Owner = Owner;
    }
}
