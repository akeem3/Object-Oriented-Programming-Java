package com.TID;

public class AdminAdd {
    private String ID, Coach, Sport,Schedule;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCoach() {
        return Coach;
    }

    public void setCoach(String coach) {
        Coach = coach;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public AdminAdd(String x, String x1, String x2, String x3 ){
        this.ID = x;
        this.Coach = x1;
        this.Sport = x2;
        this.Schedule = x3;

    }

}
