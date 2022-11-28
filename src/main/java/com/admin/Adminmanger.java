package com.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.*;
public class Adminmanger extends JFrame {
    Adminmanger(){
        setVisible(true);
        setSize(400, 600);
        setLayout(null);
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea txta = new JTextArea("welcome to our Admin section");
        add(txta);
        txta.setBounds(100, 20, 200, 20);
        txta.setCaretColor(Color.black);
        JButton button = new JButton("ADD LIBRARIAN");
        button.setBounds(100, 90, 200, 50);
        add(button);
        button.setBackground(Color.MAGENTA);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Accountscreate().setVisible(true);
            dispose();
            }
        });
        JButton button1 = new JButton("DELETE LIBRARIAN");
        button1.setBounds(100, 150, 200, 50);
        add(button1);
        button1.setBackground(Color.MAGENTA);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Deletelibrarian().setVisible(true);
                dispose();
            }
        });
        JButton button2 = new JButton("VIEW LIBRARIAN");
        button2.setBounds(100, 210, 200, 50);
        add(button2);
        button2.setBackground(Color.MAGENTA);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Viewlib().setVisible(true);
                dispose();
            }
        });
        JButton button3 = new JButton(" LOGOUT");
        button3.setBounds(100, 270, 200, 50);
        add(button3);
        button3.setBackground(Color.MAGENTA);
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new Intro();
    }
});
    }
    public static void main(String[] args) {
new Adminmanger();


    }

}