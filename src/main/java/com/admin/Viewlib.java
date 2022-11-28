package com.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.sql.*;

public class Viewlib extends JFrame {
    Viewlib(){

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTable table = new JTable();

        JScrollPane tableContainer = new JScrollPane(table);

        panel.add(tableContainer, BorderLayout.CENTER);
        getContentPane().add(panel);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String url = "jdbc:mysql://localhost:3306/librarymanage";
        String pass = "error";
        String uname = "root";
        String sts="select * from librarian";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, uname, pass);
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery(sts);
            ResultSetMetaData rsm=rs.getMetaData();
            DefaultTableModel dft= (DefaultTableModel) table.getModel();
            int cunt=rsm.getColumnCount();
            String [] columnse=new String[cunt];
            for(int i=0;i< cunt;i++)
                columnse[i]=rsm.getColumnName(i+1);
                dft.setColumnIdentifiers(columnse);

String myvalue,name,email,street,city,phnumber;
                while (rs.next()){
                   myvalue=rs.getString(1);
                    name=rs.getString(2);
                    email=rs.getString(3);
                    street=rs.getString(4);
                    city=rs.getString(5);
                    phnumber=rs.getString(6);
                String[] rows={myvalue,name,email,street,city,phnumber};
                dft.addRow(rows);
//
            }
                statement.close();
con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

           }

    public static void main(String[] args) {
        new Viewlib();
    }
    }




