package com.library;

import javax.swing.*;
import java.awt.*;

public class Librarymanager extends JFrame {
    public Librarymanager(){
        setVisible(true);
        setSize(400, 600);
        setLayout(null);
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea txta = new JTextArea("welcome to our LIBRARY section");
        add(txta);
        txta.setBounds(100, 20, 240, 20);
        txta.setCaretColor(Color.black);
        JButton button = new JButton("ADD BOOK");
        button.setBounds(100, 90, 200, 50);
        add(button);
        button.setBackground(Color.MAGENTA);
        JButton button1 = new JButton("VIEW BOOK");
        button1.setBounds(100, 150, 200, 50);
        add(button1);
        button1.setBackground(Color.MAGENTA);
        JButton button2 = new JButton("ISSUE BOOK");
        button2.setBounds(100, 210, 200, 50);
        add(button2);
        button1.setBackground(Color.MAGENTA);
        JButton button3 = new JButton(" VIEW ISSUED BOOK");
        button3.setBounds(100, 270, 200, 50);
        add(button3);
        button3.setBackground(Color.MAGENTA);
        JButton button4 = new JButton(" RETURN BOOK");
        button4.setBounds(100, 270, 200, 50);
        add(button4);
        button4.setBackground(Color.MAGENTA);
        JButton button5 = new JButton(" LOGOUT");
        button5.setBounds(100, 270, 200, 50);
        add(button3);
        button5.setBackground(Color.MAGENTA);

    }

}
