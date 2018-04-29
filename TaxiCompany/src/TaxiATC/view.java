package TaxiATC;

import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class view{
public static void main(String[] args){
	Connection con = null;
	   Statement st = null;
	   ResultSet rs = null;
}
   public static void theView(String s){
	Connection con = null;
   Statement st = null;
   ResultSet rs = null;
   

//connect your app to mysql database
   try{
       con = DriverManager.getConnection("jdbc:mysql://10.1.63.200/Group 24","1516627","1516627");
       st = con.createStatement();
       
       rs = st.executeQuery(s);
//get's data from mysql database and put's it in a jtable       
       ResultSetMetaData rsmt = rs.getMetaData();      
       int c = rsmt.getColumnCount();
       Vector column = new Vector(c);
       for(int i = 1; i <= c; i++)
       {
           column.add(rsmt.getColumnName(i));
       } 
       Vector data = new Vector();
       Vector row = new Vector();
       while(rs.next())
       {
           row = new Vector(c);
           for(int i = 1; i <= c; i++){
               row.add(rs.getString(i));
           }
           data.add(row);
       }
       JFrame frame = new JFrame();
       frame.setSize(500,150);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JTable table = new JTable(data,column);
        JScrollPane jsp = new JScrollPane(table);
        panel.setLayout(new BorderLayout());
        panel.add(jsp,BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setVisible(true);
               
               
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "ERROR");
   }finally{
       try{
       st.close();
       rs.close();
       con.close();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "ERROR CLOSE");
       }
   }
      
  }
}


