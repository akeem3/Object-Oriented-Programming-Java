package com.TID;


public class adminUsers {
    private String Name;
    private int Password;


    public adminUsers(String Name, int Password){
        this.Name = Name;
        this.Password = Password;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;

    }
    public int getPassword() {
        return Password;
    }
    public void setPassword(int Password) {
        this.Password = Password;

    }
}



