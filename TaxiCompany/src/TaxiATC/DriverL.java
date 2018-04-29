package TaxiATC;

import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;

import javax.swing.*;
import java.util.*;//imports util package
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.String;


public class DriverL extends JFrame// this class extends a JFrame class
{
   // Container con;
   // These are the variables which I have added and will be using
    private String username;
    private String password;
    private String save;
    private String clear;
    //button group for gender
    
    // These are giving properties to the JButtons, JLabels and JTextFields
    

    JLabel loginLabel;
    JButton loginButton;
    JButton returnButton;
    JButton registerButton;
    JLabel registerLabel;
    JLabel registerLabel1;
    // This is a variable that allows the text to be saved in a text file
    String Accountfilename = "InputAccountDetails.txt";
    
    
    
    /**
     * This is a Constructor
     */
    public DriverL()
    {
                super("Driver Page"); // this is the name of JFrame interface
                
               final Container con = getContentPane(); 


                // These are the instructions which are written on the buttons
                loginLabel = new JLabel("");
                loginButton = new JButton("Login");
                
               
                returnButton = new JButton("Back");
               
                // this will print to a writer
                PrintWriter myStream;
                

                
                
       
                // This sets the layout
                FlowLayout myLayout = new FlowLayout();
                con.setLayout(myLayout);
                
                                 
             
                con.add(loginLabel);
                con.add(loginButton);
              
                con.add(returnButton);
               

            
            

        
                //this is the return button that opens the previous frame

                 returnButton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e)
                {
                	 new Main();
                	dispose();
                }
             });        
 
              
                 //this is the login button that opens the next frame
            loginButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new DriverLogin();
                    dispose();

                }
            });
            
            
            // when you press the clear button all the text fields will be cleared 
             
             

            
            /*
             * this sets the JFrame size
             */
            
            pack();
            setLocation(210,150);
            setSize(300,200);
            setVisible(true);
            setResizable(false);


        }
        
    
		public static void main (String[] args)
       {
           DriverL myLogin = new DriverL();

       }
    }

