package TaxiATC;


import java.io.*;
import java.awt.*;
import java.awt.event.*; // in here i imported all the util packages 

import javax.swing.*;

import java.util.*;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.String;
public class Booking extends JFrame//declares Booking class
{
   protected static final JLabel FromText = null;
// this are the variables;
    private String BookingDate;
    private String BookingTime;
    private String From;
    private String To;
    private String FirstName;
    private String PhoneNumber;
    private String Back;
    
    String[] storeData;// this will hold the file lines
    
    
    
    
    JLabel BookingDateLabel;
    JTextField BookingDateText;
    JLabel BookingTimeLabel;
    JTextField BookingTimeText;
   
    
    JLabel FromLabel;
    JTextField fromText;
    JLabel ToLabel;
    JTextField ToText;
    JLabel FirstNameLabel;
    JTextField FirstNameText;
    JLabel PhoneNumberLabel;
    JTextField PhoneNumberText;
    JLabel submitLabel;
    JButton submitButton;
    JButton BackButton;
    JButton loadButton;
   
    
   
    
    
    JButton BackFieldsButton;
 
    
    
    /*
     * this is the Constructor
     */
    public Booking()
    {
        super("Booking Page");
        final Container con = getContentPane(); 
        
        
        // this will create the text fields,buttons and labels 
         
        
        
        
        
        BookingDateLabel = new JLabel("Booking Date:");
        BookingDateText = new JTextField(22);
        BookingTimeLabel = new JLabel("Booking Time:");
        BookingTimeText = new JTextField(22);
        
        FromLabel = new JLabel("From:");
        fromText = new JTextField(22);
        ToLabel = new JLabel("To:");
        ToText = new JTextField(22);
        FirstNameLabel = new JLabel ("First Name:");
        FirstNameText = new JTextField(22);
        PhoneNumberLabel = new JLabel ("Phone Number:");
        PhoneNumberText = new JTextField(22);
        submitLabel = new JLabel("Click Submit when done");
        submitButton = new JButton("Book");
        BackButton = new JButton("Back");
        
        
    
        
        
        
         // this will Sets the layout
         
        FlowLayout myLayout = new FlowLayout();
        con.setLayout(myLayout);
        
        
        con.add(FirstNameLabel);
        con.add(FirstNameText);
        
        con.add(FromLabel);
        con.add(fromText);
       
        con.add(ToLabel);
        con.add(ToText);
        
        
        con.add(BookingDateLabel);
        con.add(BookingDateText);
        con.add(BookingTimeLabel);
        con.add(BookingTimeText);
        
        con.add(PhoneNumberLabel);
        con.add(PhoneNumberText);
       
        con.add(submitLabel);
        con.add(submitButton);
        con.add(BackButton);
     
        

       
        submitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                // this will get the values form the text fields and then store it in a variables
                BookingDate = BookingDateText.getText();
                BookingTime = BookingTimeText.getText();
                From = fromText.getText();
                To = ToText.getText();
                FirstName = FirstNameText.getText();
                PhoneNumber = PhoneNumberText.getText();
                //this runs the method from the DatabaseConnection class
                DatabaseConnection.theQuery("insert into Trip (PickUp,DropOffAddress,PickUpTime,PickUpDate,Name,Telephone) values('"+fromText.getText()+"','"+ToText.getText()+"','"+BookingTimeText.getText()+"','"+BookingDateText.getText()+"','"+FirstNameText.getText()+"','"+PhoneNumberText.getText()+"')");
                JOptionPane.showMessageDialog(null, "Booking complete!!");
                // this will create new booking with the values typed in
             
                
               
            }
        });
        
        
       
        
        
       
      
        
    
        
       
   
          
                
                BackButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                      new CustomerOption();
                       dispose();
                    }
                });
        
       
        //this pack's the frame and set's is size ,background color and location
        pack();
        setLocation(210,150);
        setSize(270, 400);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main (String[] args) 
   {
       Booking myLogin = new Booking();
   }
}
 
