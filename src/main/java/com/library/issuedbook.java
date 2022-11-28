package com.library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class issuedbook extends JFrame {
    issuedbook(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTable table = new JTable();

        JScrollPane tableContainer = new JScrollPane(table);

        panel.add(tableContainer, BorderLayout.CENTER);
        getContentPane().add(panel);
        setVisible(true);
        setSize(600, 600);
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
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel defaultTableModel= (DefaultTableModel) table.getModel();
           int  adt =rsmd.getColumnCount();
           String [] admdt=new String[adt];
          int value= admdt.length;
          for (int i=0;i<adt;i++){
              admdt[i]=rsmd.getColumnName(i+1);
              defaultTableModel.setColumnIdentifiers(admdt);
String id,bookref,name,auth,publ,sdate,squantity,sissued;
while (rs.next()){
    id=rs.getString(1);
    bookref=rs.getString(2);
    name=rs.getString(3);
    auth=rs.getString(4);
    publ=rs.getString(5);
    squantity=rs.getString(7);

    sissued=rs.getString(8);
    sdate=rs.getString(6);
    String[] rowd={id,bookref,name,auth,publ,sdate,squantity,sissued};
    defaultTableModel.addRow(rowd);
}
          }

        }catch (Exception e){
        System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new issuedbook();
    }
}
