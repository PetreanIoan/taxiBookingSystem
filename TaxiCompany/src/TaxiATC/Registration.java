package TaxiATC;

import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*; // in here i imported all the util packages 
import javax.swing.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.String;

public class Registration extends JFrame//declares Registration class
{
   // this is the Container con;
    private String username;
    private String password;
    private String confirmpassword;
    private String LastName;
    private String FirstName;
    private String Address;
    private String PhoneNumber;
    private String Email;
    private String clear;
    private String CardNumber;
    private String ExpiryDate;
    private String SecurityCode;

    
    
    String[] storeData;// this will hold the file lines
    
    //this well be the button group for gender
    ButtonGroup genderButtonGroup; 
    
    
    JLabel usernameLabel;
    JTextField usernameText;
    JLabel passwordLabel;
    JTextField passwordText;
   
    
    JLabel confirmpasswordLabel;
    JTextField confirmpasswordText;
    JLabel LastNameLabel;
    JTextField LastNameText;
    JLabel FirstNameLabel;
    JTextField FirstNameText;
    JLabel AddressLabel;
    JTextField AddressText;
    JLabel PhoneNumberLabel;
    JTextField PhoneNumberText;
    JLabel EmailLabel;
    JTextField EmailText;
    JLabel CardNumberLabel;
    JTextField CardNumberText;
    JLabel ExpiryDateLabel;
    JTextField ExpiryDateText;
    JLabel SecurityCodeLabel;
    JTextField SecurityCodeText;
    JLabel submitLabel;
    JButton submitButton;
    JButton clearButton;
    JButton loadButton;
   
    
   
    
    
    JButton clearFieldsButton;
 
   
    /*
     * this is the Constructor
     */
    public Registration()
    {
        super("Registration Form");
        final Container con = getContentPane(); 
        
        
        // this will create the text fields,buttons and labels 
         
        
        
        
        
        usernameLabel = new JLabel("Username:");
        usernameText = new JTextField(22);
        passwordLabel = new JLabel("password:");
        passwordText = new JPasswordField(22);
        
        confirmpasswordLabel = new JLabel("Confirm Password:");
        confirmpasswordText = new JPasswordField(22);
        LastNameLabel = new JLabel ("Last Name:");
        LastNameText = new JTextField(22);
        FirstNameLabel = new JLabel ("First Name:");
        FirstNameText = new JTextField(22);
        AddressLabel = new JLabel("Address:");
        AddressText = new JTextField(22);        
        PhoneNumberLabel = new JLabel ("Phone Number:");
        PhoneNumberText = new JTextField(22);
        EmailLabel = new JLabel ("Email:");
        EmailText = new JTextField(22);
        CardNumberLabel = new JLabel("Card Number:");
        CardNumberText = new JTextField(22);        
        SecurityCodeLabel = new JLabel ("Security Code:");
        SecurityCodeText = new JTextField(22);
        ExpiryDateLabel = new JLabel ("Expiry Date:");
        ExpiryDateText = new JTextField(22);
        submitLabel = new JLabel("Click Submit when done");
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        
        
    
        
        
        
         // this will Sets the layout
         
        FlowLayout myLayout = new FlowLayout();
        //BoxLayout myLayout = new BoxLayout(con, BoxLayout.PAGE_AXIS);
        con.setLayout(myLayout);
        
        
        con.add(usernameLabel);
        con.add(usernameText);
        con.add(passwordLabel);
        con.add(passwordText);
        
        con.add(confirmpasswordLabel);
        con.add(confirmpasswordText);
        con.add(LastNameLabel);
        con.add(LastNameText);
        
        con.add(FirstNameLabel);
        con.add(FirstNameText);
        con.add(AddressLabel);
        con.add(AddressText);
        con.add(PhoneNumberLabel);
        con.add(PhoneNumberText);
        con.add(EmailLabel);
        con.add(EmailText);
        con.add(CardNumberLabel);
        con.add(CardNumberText);
        con.add(ExpiryDateLabel);
        con.add(ExpiryDateText);
        con.add(SecurityCodeLabel);
        con.add(SecurityCodeText);
        con.add(submitLabel);
        con.add(submitButton);
        con.add(clearButton);
     
        

        //this is the submit button that opens the next frame
        submitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                // this will get the values form the text fields and then store it in a variables
                username = usernameText.getText();
                password = passwordText.getText();
                confirmpassword = (confirmpasswordText.getText());
                LastName = LastNameText.getText();
                FirstName = FirstNameText.getText();
                Address = AddressText.getText();
                PhoneNumber = PhoneNumberText.getText();
                Email = EmailText.getText();
                CardNumber = CardNumberText.getText();
                ExpiryDate = ExpiryDateText.getText();
                SecurityCode= SecurityCodeText.getText();
           //this runs two method's from other classes
                DatabaseConnection.theQuery("insert into CustomerLogin (USERNAME,PASSWORD) values('"+usernameText.getText()+"','"+passwordText.getText()+"')");
                DatabaseConnection.theQuery("insert into Customer (FirstName,Surname,Address,Email,TelephoneNumber,CreditCard,ExpiryDate,CCV) values('"+FirstNameText.getText()+"','"+LastNameText.getText()+"','"+AddressText.getText()+"','"+EmailText.getText()+"','"+PhoneNumberText.getText()+"','"+CardNumberText.getText()+"','"+ExpiryDateText.getText()+"','"+SecurityCodeText.getText()+"')");
                JOptionPane.showMessageDialog(null, "Registration complete!!");
                new CustomerOption();
                dispose();
                
             
                
               
            }
        });
        

        //this is the clear button that cleans all that was typed in

                clearButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        usernameText.setText("");
                        passwordText.setText("");
                        confirmpasswordText.setText("");
                        LastNameText.setText("");
                        FirstNameText.setText("");
                        AddressText.setText("");
                        PhoneNumberText.setText("");
                        EmailText.setText("");
                        CardNumberText.setText("");
                        ExpiryDateText.setText("");
                        SecurityCodeText.setText("");
                       
                    }
                });
        
       
        //this set's the Jframe size and location
        pack();
        setLocation(210,150);
        setSize(270, 600);
        setVisible(true);
        setResizable(false);

    }
    
    
    public static void main (String[] args) 
   {
       Registration myLogin = new Registration();
   }
} 

