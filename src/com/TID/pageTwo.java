package com.TID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class pageTwo extends JFrame implements ActionListener {

    private Button AddRecords, DisplayRecords, SearchRecords,Exit;


    public pageTwo () {
        setSize(400,150);
        setLocation(1000,300);
        setLayout(new FlowLayout());

        AddRecords = new Button("AddRecords");
        DisplayRecords = new Button("DisplayRecords");
        SearchRecords = new Button("SearchRecords");
        Exit = new Button("Exit");

        AddRecords.addActionListener(this);
        DisplayRecords.addActionListener(this);
        SearchRecords.addActionListener(this);
        Exit.addActionListener(this);

        add(AddRecords);
        add(DisplayRecords);
        add(SearchRecords);
        add(Exit);

    }
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == AddRecords) {
            setVisible(false);
            RCSAS.userFifth.setVisible(true);

        } else if (e.getSource() == Exit)
        {
            setVisible(false);
            RCSAS.userOne.setVisible(true);
        }


        if (e.getSource() == SearchRecords) {
            setVisible(false);
            RCSAS.userFifth.setVisible(true);
        }
        else if (e.getSource() == DisplayRecords) {

            try {
                FileReader fr = new FileReader("AdminAdd.txt");
                BufferedReader bf = new BufferedReader(fr);
                Vector<String> lines = new Vector<String>();
                String line;
                while ((line = bf.readLine()) != null) {
                    lines.add(line);

                }
                JOptionPane.showMessageDialog(null,
                        new JScrollPane(new JList<>(lines)));
                fr.close();
                RCSAS.userTwo.setVisible(true);


            } catch (IOException E) {
                E.printStackTrace();
            }

        }

    }
}

