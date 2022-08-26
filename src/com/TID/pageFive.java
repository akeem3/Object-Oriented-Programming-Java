package com.TID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class pageFive extends JFrame implements ActionListener {
    private Label newMessageOne, newMessageTwo;
    private TextField input;
    private int newPayment = 300;

    public void setNewPayment(int x){
        newPayment = x;
    }
    public Label getNewMessageOne(){
        return newMessageOne;
    }
    public pageFive (){
        setSize(250,150);
        setLocation(500,400);
        setLayout(new FlowLayout());
        newMessageOne = new Label("Your new Registry ID is 20001.",Label.CENTER);
        newMessageOne.setFont(new Font(Font.SERIF,Font.BOLD,15));
        newMessageTwo = new Label("You Need to pay RM300.",Label.CENTER);
        newMessageTwo.setFont(new Font(Font.SERIF,Font.BOLD,15));
        input = new TextField(20);
        input.addActionListener(this);
        add(newMessageOne);
        add(newMessageTwo);
        add(input);
        //setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        try{
            String s = input.getText();
            input.setText("");
            int amount = Integer.parseInt(s);
            if(amount<1){
                throw new Exception();
            }
            if(amount >= newPayment){
                JOptionPane.showMessageDialog(input, "Payment done!\n"+
                        "Your changes is RM"+(amount-newPayment)+".");
                int size = RCSAS.current.getMyModifyRegistry().size();
                RCSAS.current.getMyModifyRegistry().get(size-1).setNewPaid(true);
                RCSAS.current = null;
                setVisible(false);
                RCSAS.userOne.setVisible(true);
                newMessageTwo.setText("You need to pay RM300.");
            } else{
                newPayment = newPayment-amount;
                newMessageTwo.setText("You need to pay RM"+newPayment+".");
                JOptionPane.showMessageDialog(newMessageTwo, "You must make full payment!");
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(input,"Wrong input!");
        }
    }
}


