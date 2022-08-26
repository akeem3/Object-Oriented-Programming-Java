package com.TID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class pageOne extends JFrame implements ActionListener {

    // MenuCode
    private Button AdminRegistry, AdminLogin, StudentRegistry, StudentLogin, Exit;

    public pageOne() {
        setSize(250, 150);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        AdminRegistry = new Button("AdminRegistry");
        AdminLogin = new Button("AdminLogin");
        StudentRegistry = new Button("StudentRegistry");
        StudentLogin = new Button("StudentLogin");
        Exit = new Button("Exit");

        AdminRegistry.addActionListener(this);
        AdminLogin.addActionListener(this);
        StudentRegistry.addActionListener(this);
        StudentLogin.addActionListener(this);
        Exit.addActionListener(this);

        add(AdminRegistry);
        add(AdminLogin);
        add(StudentRegistry);
        add(StudentLogin);
        add(Exit);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    // Exit and TextFiles code
        if (e.getSource() == Exit) {
            String input = JOptionPane.showInputDialog("Enter the Exit Password: ");
            if (input.equals("45678")) {
                try {
                    // studentUsers TextFile
                    PrintWriter p = new PrintWriter("studentUsers.txt");
                    for (int i = 0; i < RCSAS.allstudentUsers.size(); i++) {
                        studentUsers d = RCSAS.allstudentUsers.get(i);
                        p.println(d.getName());
                        p.println(d.getPassword());
                        p.println();
                    }
                    p.close();

                    // adminUsers TextFile
                    p = new PrintWriter("adminUsers.txt");
                    for (int i = 0; i < RCSAS.alladminUsers.size(); i++) {
                        adminUsers c = RCSAS.alladminUsers.get(i);
                        p.println(c.getName());
                        p.println(c.getPassword());
                        p.println();
                    }
                    p.close();

                    // SportRegistry TextFile
                    p = new PrintWriter("SportRegistry.txt");
                    for (int i = 0; i < RCSAS.allSportRegistry.size(); i++) {
                        SportRegistry g = RCSAS.allSportRegistry.get(i);
                        p.println(g.getID());
                        p.println(g.getSportOptions());
                        p.println(g.getDay());
                        p.println(g.getTime());
                        p.println(g.isPaid());
                        p.println(g.getOwner() . getName());
                        p.println();
                    }
                    p.close();

                    // ModifyRegistry TextFile
                    p = new PrintWriter("ModifyRegistry.txt");
                    for (int i = 0; i < RCSAS.allModifyRegistry.size(); i++) {
                        ModifyRegistry g = RCSAS.allModifyRegistry.get(i);
                        p.println(g.getNewID());
                        p.println(g.getNewSportOptions());
                        p.println(g.getNewDay());
                        p.println(g.getNewTime());
                        p.println(g.isNewPaid());
                        p.println(g.getOwner() . getName());
                        p.println();
                    }
                    p.close();

                    // Feedbacks TextFile
                    p = new PrintWriter("Feedbacks.txt");
                    for (int i = 0; i <RCSAS.allFeedbacks.size(); i++){
                        Feedback c = RCSAS.allFeedbacks.get(i);
                        p.println(c.getCoachName());
                        p.println(c.getRating());
                        p.println();
                    }
                    p.close();
                    // AdminAdd TextFile
                    p = new PrintWriter("AdminAdd.txt");
                    for (int i = 0; i < RCSAS.allAdmin.size(); i++) {
                        AdminAdd cx = RCSAS.allAdmin.get(i);
                        p.println(cx.getID());
                        p.println(cx.getCoach());
                        p.println(cx.getSport());
                        p.println(cx.getSchedule());
                        p.println();
                    }
                    p.close();
                    System.exit(0);
                } catch (Exception ex) {
                    System.out.println("Wrong Output");
                }

            } else {
                JOptionPane.showMessageDialog(Exit, "Wrong Password");
            }

        // AdminRegister Code
        } else if (e.getSource() == AdminRegistry) {
            String a = JOptionPane.showInputDialog("Name:");
            boolean flag = true;
            for (int i = 0; i < RCSAS.alladminUsers.size(); i++) {
                adminUsers d = RCSAS.alladminUsers.get(i);
                if (a.equals(d.getName())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int b = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                adminUsers d = new adminUsers(a,b);
                RCSAS.alladminUsers.add(d);
            } else {
                JOptionPane.showMessageDialog(AdminRegistry, "Name Has Been Used!");
            }
        // StudentRegistry Code
        } else if (e.getSource() == StudentRegistry) {
            String a = JOptionPane.showInputDialog("Name:");
            boolean flag = true;
            for (int i = 0; i < RCSAS.allstudentUsers.size(); i++) {
                studentUsers d = RCSAS.allstudentUsers.get(i);
                if (a.equals(d.getName())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int b = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                studentUsers d = new studentUsers(a,b);
                RCSAS.allstudentUsers.add(d);
            } else {
                JOptionPane.showMessageDialog(StudentRegistry, "Name Has Been Used!");
            }

        // AdminLogin Code
        } else if (e.getSource() == AdminLogin){
            RCSAS.current0 = null;
            System.out.println("Testing");
            String input = JOptionPane.showInputDialog("Username:");
            for (int i = 0; i < RCSAS.alladminUsers.size(); i++) {
                adminUsers d = RCSAS.alladminUsers.get(i);
                if (input.equals(d.getName())) {
                    RCSAS.current0 = d;
                    break;
                }
            }
            if (RCSAS.current0 == null) {
                JOptionPane.showMessageDialog(AdminLogin, "Wrong Username!");
            } else {
                input = JOptionPane.showInputDialog("Pin:");
                if (Integer.parseInt(input) == RCSAS.current0.getPassword()) {
                    setVisible(false);
                    RCSAS.userTwo.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(AdminLogin, "Wrong Password!");
                    RCSAS.current0 = null;
                }
            }
        // StudentLogin Code
        } else if (e.getSource() == StudentLogin){
            RCSAS.current = null;
            System.out.println("Testing");
            String input = JOptionPane.showInputDialog("Username:");
            for (int i = 0; i < RCSAS.allstudentUsers.size(); i++) {
                studentUsers d = RCSAS.allstudentUsers.get(i);
                if (input.equals(d.getName())) {
                    RCSAS.current = d;
                    break;
                }
            }
            if (RCSAS.current == null) {
                JOptionPane.showMessageDialog(StudentLogin, "Wrong Username!");
            } else {
                input = JOptionPane.showInputDialog("Pin:");
                if (Integer.parseInt(input) == RCSAS.current.getPassword()) {

                    setVisible(false);
                    RCSAS.userThree.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(StudentLogin, "Wrong Password!");
                    RCSAS.current = null;
                }
            }

        }


    }
}

