package TaxiATC;

//This is the part where I am importing all the java libraries needed
import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;//imports util package
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.String;

public class Main extends JFrame// this class extends a JFrame class
{
	
   // Container con;
   // These are the variables which I have added and will be using
	

  
    //button group for gender
    
    // These are giving properties to the JButtons, JLabels and JTextFields
    ButtonGroup genderButtonGroup; 


    
    JLabel customerLabel;
    JButton customerButton;
    JButton driverButton;
    JButton adminButton;
    JLabel adminLabel;
    // This is a variable that allows the text to be saved in a text file
    String Accountfilename = "InputAccountDetails.txt";
    
    
    
    /**
     * This is a Constructor
     */
    public Main()
    {
                super("ATC Taxi company Menu"); // this is the name of JFrame interface
                
             
                final Container con = getContentPane(); 
                
               /*
               * Create buttons, text fields and labels
                 */
            
                //This creates the gender button
                genderButtonGroup = new ButtonGroup();
                
                // these are the text fields where you enter details
 
                
                // These are the instructions which are written on the buttons
                customerLabel = new JLabel(" ");
                customerButton = new JButton("Customer");
                driverButton = new JButton("Driver");
                adminButton = new JButton("Admin");
                adminLabel = new JLabel(" ");
                // this will print to a writer
                PrintWriter myStream;
                
                

               
                
                
       
                // This sets the layout
                FlowLayout myLayout = new FlowLayout();
                con.setLayout(myLayout);
                


                con.add(customerLabel);
                con.add(customerButton);
                con.add(driverButton);
                con.add(adminLabel);
                con.add(adminButton);
                
            

                //this is the driver button that opens the next frame
                 driverButton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e)
                {
                   new DriverL();
                   dispose();
                }
             });        
                       
                 //this is the admin button that opens the next frame
        adminButton.addActionListener(new ActionListener()
               {
                   public void actionPerformed(ActionEvent e)
                {
                
                	   new AdminLogin();
                	   dispose();
           }
        });           
              
           
        //this is the customer button that opens the next frame
            customerButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	 new Customer();
                	 dispose();
                }
            });
            
            JPanel p = new JPanel();
            p.setBackground(Color.BLACK);

            
            
            /*
             * this set's the background picture
             */
    
            
            JLabel background=new JLabel(new ImageIcon("C:\\Users\\ACER\\Downloads\\images.jpg"));
   		 add(background);
   		 background.setLayout(new FlowLayout());
   		 this.add(background);
   		 //this set's the Jframe size and location
            pack();
            setLocation(350,100);
            setSize(450, 400);
            setVisible(true);
            setResizable(false);
            setBackground(Color.blue);
            
        }
        
    
        
        public static void main (String[] args)
       {
        	
            new Main();
            

       }
    }

