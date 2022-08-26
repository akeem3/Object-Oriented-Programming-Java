package com.TID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pageFourth extends JFrame implements ActionListener {
    private Label messageOne, messageTwo;
    private TextField input;
    private int Payment = 300;

    public void setPayment(int x){
        Payment = x;
    }
    public Label getMessageOne(){
        return messageOne;
    }
    public pageFourth (){
        setSize(250,150);
        setLocation(500,400);
        setLayout(new FlowLayout());
        messageOne = new Label("Your Registry ID is 10001.",Label.CENTER);
        messageOne.setFont(new Font(Font.SERIF,Font.BOLD,15));
        messageTwo = new Label("You Need to pay RM300.",Label.CENTER);
        messageTwo.setFont(new Font(Font.SERIF,Font.BOLD,15));
        input = new TextField(20);
        input.addActionListener(this);
        add(messageOne);
        add(messageTwo);
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
            if(amount >= Payment){
                JOptionPane.showMessageDialog(input, "Payment done!\n"+
                        "Your changes is RM"+(amount-Payment)+".");
                int size = RCSAS.current.getMySportRegistry().size();
                RCSAS.current.getMySportRegistry().get(size-1).setPaid(true);
                RCSAS.current = null;
                setVisible(false);
                RCSAS.userOne.setVisible(true);
                messageTwo.setText("You need to pay RM300.");
            } else{
                Payment = Payment-amount;
                messageTwo.setText("You need to pay RM"+Payment+".");
                JOptionPane.showMessageDialog(messageTwo, "You must make full payment!");
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(input,"Wrong input!");
        }
    }
}



