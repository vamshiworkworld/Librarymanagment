package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class returnbook extends JFrame {
    returnbook(){
        setSize(600, 600);
        setLayout(null);
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea txta = new JTextArea("call no");
        add(txta);
        txta.setBounds(20, 30, 80, 20);
        txta.setCaretColor(Color.black);
        JTextArea txta1 = new JTextArea("Book name");
        add(txta1);
        txta1.setBounds(20, 70, 80, 20);
        txta1.setCaretColor(Color.black);
        JTextField jtf = new JTextField();
        add(jtf);
        jtf.setBounds(150, 30, 200, 20);
        JTextField jtf1 = new JTextField();
        add(jtf1);
        jtf1.setBounds(150, 70, 200, 20);
        JButton button11 = new JButton("Back");
        button11.setBounds(130, 230, 100, 20);
        add(button11);
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Librarymanager().setVisible(true);

            }
        });
        JButton button = new JButton("returnbook");
        button11.setBounds(130, 230, 100, 20);
        add(button11);
TextArea ta=new TextArea("Please check boook properly");
ta.setBounds(70,260,150,20);
ta.setBackground(Color.RED);
add(ta);
    }

    public static void main(String[] args) {

        new returnbook();
    }
}
