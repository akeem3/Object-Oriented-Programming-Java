package com.TID;

import java.util.ArrayList;

public class studentUsers {
    private String Name;
    private int Password;
    private ArrayList<SportRegistry> MySportRegistry = new ArrayList<SportRegistry>();
    private ArrayList<ModifyRegistry> MyModifyRegistry = new ArrayList<ModifyRegistry>();

    public studentUsers (String Name, int Password){
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
    public ArrayList<SportRegistry> getMySportRegistry() {
        return MySportRegistry;
    }
    public void setMySportRegistry(ArrayList<SportRegistry> MySportRegistry) {
        this.MySportRegistry = MySportRegistry;
    }
    public ArrayList<ModifyRegistry> getMyModifyRegistry() {
        return MyModifyRegistry;
    }
    public void setMyModifyRegistry(ArrayList<ModifyRegistry> MyModifyRegistry) {
        this.MyModifyRegistry = MyModifyRegistry;
    }
}



