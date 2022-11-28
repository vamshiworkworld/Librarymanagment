package com.library;

import com.admin.Adminlogin;
import com.admin.Adminmanger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Librarylogin extends JFrame {
        public Librarylogin(){
            setVisible(true);
            setSize(600, 400);
            setLayout(null);
            getContentPane().setBackground(Color.blue);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea txta = new JTextArea("Enter name");
            add(txta);
            txta.setBounds(20, 50, 100, 50);
            txta.setCaretColor(Color.black);
            JTextArea txta1 = new JTextArea("Enter pass");
            add(txta1);
            txta1.setBounds(20, 100, 150, 50);
            txta1.setCaretColor(Color.black);
            JTextField jtf=new JTextField();
            add(jtf);
            jtf.setBounds(100,50,200,50);
            JTextField jtf1=new JTextField();
            add(jtf1);
            jtf1.setBounds(100,100,200,50);

            JButton button = new JButton("Login");
            button.setBounds(100, 180, 200, 50);
            add(button);
            button.setBackground(Color.MAGENTA);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String t1=jtf.getText();
                    String t2=jtf1.getText();
                    if((t1.equals("admin"))&&(t2.equals("vamshi"))){
                        new Librarymanager ().setVisible(true);
                        dispose();
                    }
                    else{
                        System.out.println("enter vaild login,pass");
                    }



                }
            });

        }

        public static void main(String[] args) {

            new Librarylogin();
        }
    }


