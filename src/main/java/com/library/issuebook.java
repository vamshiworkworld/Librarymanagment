package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class issuebook extends JFrame {
    public issuebook()  {
        setVisible(true);
        setSize(400, 500);
        setLayout(null);
        getContentPane().setBackground(Color.green);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea txta = new JTextArea("call no");
        add(txta);
        txta.setBounds(20, 30, 80, 20);
        txta.setCaretColor(Color.black);
        JTextArea txta1 = new JTextArea("student name");
        add(txta1);
        txta1.setBounds(20, 70, 80, 20);
        txta1.setCaretColor(Color.black);
        JTextField jtf = new JTextField();
        add(jtf);
        jtf.setBounds(150, 30, 200, 20);
        JTextField jtf1 = new JTextField();
        add(jtf1);
        jtf1.setBounds(150, 70, 200, 20);
        JTextArea txta2 = new JTextArea("studentid");
        add(txta2);
        txta2.setBounds(20, 110, 80, 20);
        txta2.setCaretColor(Color.black);
        JTextArea txta3 = new JTextArea("studentphono");
        add(txta3);
        txta3.setBounds(20, 150, 80, 20);
        txta3.setCaretColor(Color.black);
        JTextField jtf2 = new JTextField();
        add(jtf2);
        jtf2.setBounds(150, 110, 200, 20);
        JTextField jtf3 = new JTextField();
        add(jtf3);
        jtf3.setBounds(150, 150, 200, 20);
        jtf3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                String champ =jtf3.getText();
                int val=champ.length();
                if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){

                    jtf3.setEditable(true);

                }else {
                    jtf3.setEditable(false);
                }
            }
        });

        JButton button = new JButton("View Issued Book");
        button.setBounds(130, 190, 200, 20);
        add(button);
        TextArea ta11=new TextArea("NOTE:please look Student id carefully");
        ta11.setBounds(40,280,300,20);
        ta11.setBackground(Color.RED);
        add(ta11);
        JButton button11 = new JButton("Back");
        button11.setBounds(130, 230, 100, 20);
        add(button11);
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Librarymanager().setVisible(true);

            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf != null && jtf1 != null && jtf2 != null && jtf3 != null) {
                    String url = "jdbc:mysql://localhost:3306/librarymanage";
                    String pass = "error";
                    String name = "root";
                    try {
                        Connection con = DriverManager.getConnection(url, name, pass);
                        PreparedStatement pst = con.prepareStatement("insert into Students values(?,?,?,?,?,?,?,?)");
                        String str0 = jtf.getText();
                        String str1 = jtf1.getText();
                        String str2 = jtf2.getText();
                        String str3 = jtf3.getText();


                        pst.setString(1, null);
                        pst.setString(2, str0);
                        pst.setString(3, str1);
                        pst.setString(4, str2);
                        pst.setString(5, str3);
                        LocalDate dt=LocalDate.now();
                        pst.setString(6, String.valueOf(dt));
                        int item = pst.executeUpdate();
                        System.out.println(item + " records inserted");
                        con.close();
                    } catch (SQLException se) {
                        System.out.println(se);
                    }

                    JOptionPane.showMessageDialog(null, "Book issued sucessfully");
                    dispose();
                }
            }
        });

    }

    public static void main(String[] args) {
        new issuebook();
    }


}

