package com.TID;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class pageThree extends JFrame implements ActionListener {

    private Button SportRegistry, RegistryPay, ViewDetails, ModifySelfRecord, NewRegistryPay, Feedback, Exit;

    public pageThree() {
        setSize(400, 150);
        setLocation(1000, 300);
        setLayout(new FlowLayout());

        SportRegistry = new Button("SportRegistry");
        RegistryPay = new Button("RegistryPay");
        ViewDetails = new Button("ViewDetails");
        ModifySelfRecord = new Button("ModifySelfRecord");
        NewRegistryPay = new Button("NewRegistryPay");
        Feedback = new Button("Feedback");
        Exit = new Button("Exit");

        SportRegistry.addActionListener(this);
        RegistryPay.addActionListener(this);
        ViewDetails.addActionListener(this);
        ModifySelfRecord.addActionListener(this);
        NewRegistryPay.addActionListener(this);
        Feedback.addActionListener(this);
        Exit.addActionListener(this);

        add(SportRegistry);
        add(RegistryPay);
        add(ViewDetails);
        add(ModifySelfRecord);
        add(NewRegistryPay);
        add(Feedback);
        add(Exit);

    }

    public void actionPerformed(ActionEvent e) {
        // Exit Button code
        if (e.getSource() == Exit) {
            setVisible(false);
            RCSAS.userOne.setVisible(true);
            RCSAS.current = null;
        // SportRegistry code
        } else if (e.getSource() == SportRegistry) {
            int size = RCSAS.current.getMySportRegistry().size();
            if (size == 0 || RCSAS.current.getMySportRegistry().get(size - 1).isPaid()) {
                int ID = 10001;
                int allSize = RCSAS.allSportRegistry.size();
                ID = ID + allSize;
                try {
                    String b = JOptionPane.showInputDialog("Enter SportOption:");
                    SportOptions b1 = SportOptions.valueOf(b);
                    String c = JOptionPane.showInputDialog("Enter Day");
                    Days c1 = Days.valueOf(c);
                    int d = Integer.parseInt(JOptionPane.showInputDialog("Enter Time:"));
                    if (d < 9 || d > 23) {
                        throw new Exception();
                    }
                    boolean flag = true;
                    for (int i = 0; i < RCSAS.allSportRegistry.size(); i++) {
                        SportRegistry z = RCSAS.allSportRegistry.get(i);
                        if (b.equals(z.getSportOptions().toString()) &&
                                c.equals(z.getDay().toString()) &&
                                d == z.getTime()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        SportRegistry y = new SportRegistry(ID, b1, c1, d, false, RCSAS.current);
                        RCSAS.current.getMySportRegistry().add(y);
                        RCSAS.allSportRegistry.add(y);
                        JOptionPane.showMessageDialog(RegistryPay, "ID: " + ID);
                    } else {
                        JOptionPane.showMessageDialog(RegistryPay, "Registration not available!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(RegistryPay, "Wrong input!");
                }
            } else {
                JOptionPane.showMessageDialog(RegistryPay, "You have unpaid Registration!");
            }
        // RegistryPay code
        } else if (e.getSource() == RegistryPay) {
            int size = RCSAS.current.getMySportRegistry().size();
            if (size == 0 || RCSAS.current.getMySportRegistry().get(size - 1).isPaid()) {
                JOptionPane.showMessageDialog(RegistryPay, "No Registration to be paid!");
            } else {
                RCSAS.userFourth.setPayment(300);
                int ID = RCSAS.current.getMySportRegistry().get(size - 1).getID();
                RCSAS.userFourth.getMessageOne().setText("Your Registration ID is " + ID + ".");
                setVisible(false);
                RCSAS.userFourth.setVisible(true);
            }
        // Feedbacks code
        } else if (e.getSource() == Feedback) {
            String a = JOptionPane.showInputDialog("Enter the CoachName and ID:");
            boolean flag = true;
            for (int i = 0; i < RCSAS.allFeedbacks.size(); i++) {
                Feedback d = RCSAS.allFeedbacks.get(i);
                if (Objects.equals(a, d.getCoachName())){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int b = Integer.parseInt(JOptionPane.showInputDialog("Enter your Rating:"));
                Feedback c = new Feedback(a,b);
                RCSAS.allFeedbacks.add(c);
            } else {
                JOptionPane.showMessageDialog(Feedback, "This CoachID Has Been Rated!");
            }

            // ModifySelfRecord code
        } else if (e.getSource() == ModifySelfRecord) {
            int size = RCSAS.current.getMyModifyRegistry().size();
            if (size == 0 || RCSAS.current.getMyModifyRegistry().get(size - 1).isNewPaid()) {
                int newID = 20001;
                int allSize = RCSAS.allModifyRegistry.size();
                newID = newID + allSize;
                try {
                    String b = JOptionPane.showInputDialog("Enter newSportOption:");
                    SportOptions b1 = SportOptions.valueOf(b);
                    String c = JOptionPane.showInputDialog("Enter newDay");
                    Days c1 = Days.valueOf(c);
                    int d = Integer.parseInt(JOptionPane.showInputDialog("Enter newTime:"));
                    if (d < 9 || d > 23) {
                        throw new Exception();
                    }
                    boolean flag = true;
                    for (int i = 0; i < RCSAS.allModifyRegistry.size(); i++) {
                        ModifyRegistry z = RCSAS.allModifyRegistry.get(i);
                        if (b.equals(z.getNewSportOptions().toString()) &&
                                c.equals(z.getNewDay().toString()) &&
                                d == z.getNewTime()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ModifyRegistry y = new ModifyRegistry(newID, b1, c1, d, false, RCSAS.current);
                        RCSAS.current.getMyModifyRegistry().add(y);
                        RCSAS.allModifyRegistry.add(y);
                        JOptionPane.showMessageDialog(NewRegistryPay, "ID: " + newID);
                    } else {
                        JOptionPane.showMessageDialog(NewRegistryPay, "New Registration not available!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(NewRegistryPay, "Wrong input!");
                }
            } else {
                JOptionPane.showMessageDialog(NewRegistryPay, "You have a new unpaid Registration!");
            }
        // NewRegistry code
        } else if (e.getSource() == NewRegistryPay) {
            int size = RCSAS.current.getMyModifyRegistry().size();
            if (size == 0 || RCSAS.current.getMyModifyRegistry().get(size - 1).isNewPaid()) {
                JOptionPane.showMessageDialog(NewRegistryPay, "No new Registration to be paid!");
            } else {
                RCSAS.userSixth.setNewPayment(300);
                int newID = RCSAS.current.getMyModifyRegistry().get(size - 1).getNewID();
                RCSAS.userSixth.getNewMessageOne().setText("Your new Registration ID is " + newID + ".");
                setVisible(false);
                RCSAS.userSixth.setVisible(true);
            }

        // View Details
        } else if (e.getSource() == ViewDetails){
            File file = new File("AdminAdd.txt");
            try {
                Scanner s = new Scanner(file);
                while (s.hasNextLine()){
                    System.out.println(s.nextLine());
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        }
    }

}





