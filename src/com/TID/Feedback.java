package com.TID;

public class Feedback {
    private String CoachName;
    private int Rating;

    public Feedback (String CoachName,int Rating){
        this.CoachName = CoachName;
        this.Rating = Rating;
    }

    public String getCoachName() {
        return CoachName;
    }
    public void setCoachname(String CoachName) {
        this.CoachName = CoachName;
    }

    public int getRating() {
        return Rating;
    }
    public void setRating(int Rating) {
        this.Rating = Rating;
    }
}
