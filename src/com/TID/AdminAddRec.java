package com.TID;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class AdminAddRec extends JFrame implements ActionListener {
    private  Button Enter;
    private Button Back;
    private Button Edit;
    private Button Search;
    private JTextField ID, Coach, Sport, SportSchedule;


    public AdminAddRec() {


        setSize(500, 200);
        setLocation(1000, 300);
        setLayout(new FlowLayout());


        Enter = new Button("Enter");
        Back = new Button("Back");
        Edit = new Button("Edit");
        Search = new Button("Search");


        ID = new JTextField("ID: ", 30);
        Coach = new JTextField("Coach: ", 30);
        Sport = new JTextField("Sport: ", 30);
        SportSchedule = new JTextField("SportSchedule: ", 30);



        Enter.addActionListener(this);
        Back.addActionListener(this);
        ID.addActionListener(this);
        Coach.addActionListener(this);
        Sport.addActionListener(this);
        SportSchedule.addActionListener(this);
        Edit.addActionListener(this);
        Search.addActionListener(this);



        add(Enter);
        add(Back);
        add(ID);
        add(Coach);
        add(Sport);
        add(SportSchedule);
        add(Edit);
        add(Search);



    }


    public void actionPerformed(ActionEvent actionEvent) {
        try {
            String in1 = ID.getText();
            String in2 = Sport.getText();
            String in3 = Coach.getText();
            String in4 = SportSchedule.getText();

            if (actionEvent.getSource() == Enter){
                AdminAdd ad = new AdminAdd(in1,in3,in2,in4);
                RCSAS.allAdmin.add(ad);
                JOptionPane.showMessageDialog(Enter,"Successfully Added");
            }

            //Add records
            else if (actionEvent.getSource() == Back) {
                setVisible(false);
                RCSAS.userTwo.setVisible(true);
            }
            //search records
            if (actionEvent.getSource() == Search) {

                for (int ii = 0; ii < RCSAS.allAdmin.size(); ii++) {
                    AdminAdd a = RCSAS.allAdmin.get(ii);
                    String id = a.getID();
                    String c = a.getCoach();
                    String sp = a.getSport();
                    String sc = a.getSchedule();


                    if (in1.equals(id)) {
                        System.out.println(id + "\n" + sp + "\n" + c + "\n" + sc);

                        ID.setText(id);
                        Coach.setText(c);
                        Sport.setText(sp);
                        SportSchedule.setText(sc);
                    }


                }


            }
            //Edit Details code
            else if (actionEvent.getSource() == Edit){

                AdminAdd current = null;
                AdminAdd current2 = null;
                AdminAdd current1 = null;
                String name = JOptionPane.showInputDialog("Enter: ");
                boolean found = false;
                int i;
                for(i=0; i<RCSAS.allAdmin.size(); i++){
                    AdminAdd a = RCSAS.allAdmin.get(i);
                    if(name.equals(a.getCoach())){
                        found = true;
                        current = a;
                        break;
                    }
                }
                if(found){
                    String neww = JOptionPane.showInputDialog("Enter New Coach: ");
                    current.setCoach(neww);
                } else{
                    int ii = 0;
                    for(ii=0; ii<RCSAS.allAdmin.size(); ii++){
                        AdminAdd aa = RCSAS.allAdmin.get(ii);
                        if(name.equals(aa.getSport())){
                            found = true;
                            current1 = aa;
                            break;
                        }
                    }
                    if(found){
                        String neww = JOptionPane.showInputDialog("Enter New Sport: ");
                        current1.setSport(neww);
                    } else{

                        int iii = 0;
                        for(iii=0; iii<RCSAS.allAdmin.size(); iii++){
                            AdminAdd aaa = RCSAS.allAdmin.get(iii);
                            if(name.equals(aaa.getSchedule())){
                                found = true;
                                current2 = aaa;
                                break;
                            }
                        }
                        if(found){
                            String neww = JOptionPane.showInputDialog("Enter New Schedule: ");
                            current2.setSchedule(neww);
                        } else{

                            JOptionPane.showMessageDialog(this.Edit,"Detail does not exists!");
                        }

                    }

                }
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}



