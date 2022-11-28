package com.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.PreparedStatement;
public class Accountscreate extends JFrame {
    Accountscreate(){
        setVisible(true);
        setSize(600, 600);
        setLayout(null);
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea txta = new JTextArea("Enter name");
        add(txta);
        txta.setBounds(20, 30, 80, 20);
        txta.setCaretColor(Color.black);
        JTextArea txta1 = new JTextArea("Enter pass");
        add(txta1);
        txta1.setBounds(20, 70, 80, 20);
        txta1.setCaretColor(Color.black);
        JTextField jtf=new JTextField();
        add(jtf);
        jtf.setBounds(150,30,200,20);
        JTextField jtf1=new JTextField();
        add(jtf1);
        jtf1.setBounds(150,70,200,20);
        JTextArea txta2 = new JTextArea("Enter Email");
        add(txta2);
        txta2.setBounds(20, 110, 80, 20);
        txta2.setCaretColor(Color.black);
        JTextArea txta3= new JTextArea("Enter Adress");
        add(txta3);
        txta3.setBounds(20, 150, 80, 20);
        txta3.setCaretColor(Color.black);
        JTextField jtf2=new JTextField();
        add(jtf2);
        jtf2.setBounds(150,110,200,20);
        JTextField jtf3=new JTextField();
        add(jtf3);
        jtf3.setBounds(150,150,200,20);
        JTextArea txta4 = new JTextArea("Enter City");
        add(txta4);
        txta4.setBounds(20, 190, 80, 20);
        txta4.setCaretColor(Color.black);
        JTextArea txta5= new JTextArea("Enter PhNUMBER");
        add(txta5);
        txta5.setBounds(20, 230, 80, 20);
        txta5.setCaretColor(Color.black);
        JTextField jtf4=new JTextField();
        add(jtf4);
        jtf4.setBounds(150,190,200,20);
        JTextField jtf5=new JTextField();
        add(jtf5);
        jtf5.setBounds(150,230,200,20);
        jtf5.addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyPressed(KeyEvent e) {
                                    String value=jtf5.getText();
                                    int l=value.length();
                                    if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                        jtf5.setEditable(true);
                                    } else {
                                        jtf5.setEditable(false);
                                    }
                                }
        });



                JButton button = new JButton("ADD LIBRARIAN");
        button.setBounds(130, 280, 200, 20);
        add(button);
        JButton button11 = new JButton("Back");
        button11.setBounds(130, 320, 100, 20);
        add(button11);
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Adminmanger().setVisible(true);

            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtf!=null&&jtf1!=null&&jtf2!=null&&jtf3!=null&&jtf4!=null&&jtf5!=null) {
                    String url = "jdbc:mysql://localhost:3306/librarymanage";
                    String pass = "error";
                    String name = "root";
                    try {
                        Connection con = DriverManager.getConnection(url, name, pass);
                        PreparedStatement pst =con.prepareStatement("insert into Librarian values(?,?,?,?,?,?)");
String str1=jtf.getText();
                        String str2=jtf2.getText();
                        String str3=jtf3.getText();
                        String str4=jtf4.getText();
                        String str5=jtf5.getText();
                    pst.setString(1, null);
                        pst.setString(2, str1);
                        pst.setString(3, str2);
                        pst.setString(4, str3);

                        pst.setString(5,
                                str4);
                        pst.setString(6,
                                str5);

                        int item=pst.executeUpdate();
                        System.out.println(item+" records inserted");
                        con.close();
                    }catch (SQLException se){
System.out.println(se);
                    }

                    JOptionPane.showMessageDialog(null,"Account created");
dispose();
                }
            }
        });

    }
    public static void main(String[] args) {
new Accountscreate();
    }
}
