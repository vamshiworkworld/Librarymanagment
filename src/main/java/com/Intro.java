package com;

import com.admin.Adminlogin;
import com.library.Librarylogin;
import com.library.Librarymanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro  {
    String username;
    String pass;
    public static void main(String[] args) {
        JFrame jade=new JFrame();
        jade.setVisible(true);
        jade.setSize(400,400);
       jade.setLayout(null);
       jade.getContentPane().setBackground(Color.blue);
        jade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea txta=new JTextArea("welcome to our Libraray");
        jade.add(txta);
        txta.setBounds(90,20,150,20);
        txta.setCaretColor(Color.black);
        JButton button=new JButton("Administrator");
        button.setBounds(100,90,200,50);
        jade.add(button);
        button.setBackground(Color.MAGENTA);
        JButton button1=new JButton("Librarian");
        button1.setBounds(100,150,200,50);
        jade.add(button1);
        button1.setBackground(Color.MAGENTA);

button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

new Adminlogin().setVisible(true);

jade.dispose();
    }
});
button1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
new Librarylogin().setVisible(true);
jade.dispose();
    }
});
    }


}
