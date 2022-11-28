package com.library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class viewbook extends JFrame {
    viewbook(){
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
        String sts="select * from Books";
        Connection con ;
        try {
            con = DriverManager.getConnection(url, uname, pass);
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery(sts);
            ResultSetMetaData rsme=rs.getMetaData();
            DefaultTableModel dft= (DefaultTableModel) table.getModel();
           int columnser =rsme.getColumnCount();
           String[] columnse=new String[columnser];
           for(int i=0;i<columnser;i++){
             columnse[i] = dft.getColumnName(i+1);
             dft.setColumnIdentifiers(columnse);
             String id,name,auth,bookref,comp,quantity,approved,date;
             while (rs.next()){
                 id=rs.getString(1);
                 bookref=rs.getString(2);
                 name=rs.getString(3);
                 auth=rs.getString(4);
                 comp=rs.getString(5);
                 quantity=rs.getString(6);
                 approved=rs.getString(7);
                 date=rs.getString(8);
                 String[] rowd={id,bookref,name,auth,comp,quantity,approved,date};
                 dft.addRow(rowd);

             }
           }

        }catch (SQLException sq){
            System.out.println(sq);
        }
    }

    public static void main(String[] args) {
        new viewbook();
    }
}
