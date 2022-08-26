package com.TID;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class RCSAS {

    public static pageOne userOne = new pageOne();
    public static pageTwo userTwo = new pageTwo();
    public static pageThree userThree = new pageThree();
    public static pageFourth userFourth = new pageFourth();
    public static AdminAddRec userFifth = new AdminAddRec();
    public static pageFive userSixth = new pageFive();



    public static studentUsers current;
    public static adminUsers current0;
    public static ArrayList<studentUsers> allstudentUsers = new ArrayList<studentUsers>();
    public static ArrayList<adminUsers> alladminUsers = new ArrayList<adminUsers>();
    public static ArrayList<SportRegistry> allSportRegistry = new ArrayList<SportRegistry>();
    public static ArrayList<Feedback> allFeedbacks = new ArrayList<Feedback>();
    public static ArrayList<AdminAdd> allAdmin = new ArrayList<AdminAdd>();
    public static ArrayList<ModifyRegistry> allModifyRegistry = new ArrayList<ModifyRegistry>();


    public static void main(String[] args) {

        // TextFiles Creation Code
        // studentusers TextFiles
        try {
            // studentUsers TextFile
            Scanner s = new Scanner(new File("studentUsers.txt"));
            while (s.hasNext()) {
                String a = s.nextLine();
                int b = Integer.parseInt(s.nextLine());
                s.nextLine();
                studentUsers d = new studentUsers(a,b);
                allstudentUsers.add(d);

            }
            // adminUsers TextFile
            s = new Scanner(new File("adminUsers.txt"));
            while (s.hasNext()) {
                String a = s.nextLine();
                int b = Integer.parseInt(s.nextLine());
                s.nextLine();
                adminUsers c = new adminUsers(a,b);
                alladminUsers.add(c);


                // SportRegistry Text File
                s = new Scanner(new File("SportRegistry.txt"));
                while (s.hasNext()) {
                    int a1 = Integer.parseInt(s.nextLine());
                    String b1 = s.nextLine();
                    String c1 = s.nextLine();
                    int d1 = Integer.parseInt(s.nextLine());
                    boolean e = Boolean.parseBoolean(s.nextLine());
                    String f = s.nextLine();
                    s.nextLine();
                    for (studentUsers x : allstudentUsers) {
                        if (f.equals(x.getName())) {
                            SportRegistry y = new SportRegistry(a1, SportOptions.valueOf(b1), Days.valueOf(c1), d1, e, x);
                            allSportRegistry.add(y);
                            x.getMySportRegistry().add(y);
                        }

                    }

                }
                // ModifyRegistry Text File
                s = new Scanner(new File("ModifyRegistry.txt"));
                while (s.hasNext()) {
                    int a2 = Integer.parseInt(s.nextLine());
                    String b2 = s.nextLine();
                    String c2 = s.nextLine();
                    int d2 = Integer.parseInt(s.nextLine());
                    boolean e = Boolean.parseBoolean(s.nextLine());
                    String f = s.nextLine();
                    s.nextLine();
                    for (studentUsers x : allstudentUsers) {
                        if (f.equals(x.getName())) {
                            ModifyRegistry y = new ModifyRegistry(a2, SportOptions.valueOf(b2), Days.valueOf(c2), d2, e, x);
                            allModifyRegistry.add(y);
                            x.getMyModifyRegistry().add(y);
                        }

                    }

                }

                // Feedbacks Text File
                s = new Scanner(new File("Feedbacks.txt"));
                while (s.hasNext()) {
                    String a3 = s.nextLine();
                    int b3 = Integer.parseInt(s.nextLine());
                    Feedback c3 = new Feedback(a3, b3);
                    allFeedbacks.add(c3);

                    s.nextLine();
                }
                // AdminAdd Text File
                s = new Scanner(new File("AdminAdd.txt"));
                while (s.hasNext()) {
                    String ab = s.nextLine();
                    String ac = s.nextLine();
                    String ad = s.nextLine();
                    String ae = s.nextLine();
                    s.nextLine();
                    AdminAdd cd = new AdminAdd(ab, ac, ad, ae);
                    allAdmin.add(cd);
                }
            }

        } catch (Exception ex) {
            System.out.println("Wrong Output");
        }
    }

}
