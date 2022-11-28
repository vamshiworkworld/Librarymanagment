package com.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class Deletelibrarian extends JFrame {


    Deletelibrarian() {
        setVisible(true);
        setSize(300, 300);
        setLayout(null);
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JTextArea jt=new JTextArea("Enter ID");
add(jt);
jt.setBounds(10,20,70,30);
JTextField tf=new JTextField();
add(tf);
tf.setBounds(90,20,100,30);
tf.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        String value=tf.getText();
        int l=value.length();
        if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
            tf.setEditable(true);
        } else {
            tf.setEditable(false);
        }
    }
});
JButton jb=new JButton("Delete");
add(jb);
jb.setBounds(60,70,100,50);
jb.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://localhost:3306/librarymanage";
        String pass = "error";
        String name = "root";

        String spen="Delete from Librarian where ID=?";
        try {
            Connection con = DriverManager.getConnection(url, name, pass);
           PreparedStatement pt=con.prepareStatement(spen);
          pt.setString(1,tf.getText());
           pt.execute();
JOptionPane.showMessageDialog(null,"deleted");
           }catch (SQLException se){
            System.out.println(se);
        }

    }
});
    }

    public static void main(String[] args) {
        new Deletelibrarian();
    }
}