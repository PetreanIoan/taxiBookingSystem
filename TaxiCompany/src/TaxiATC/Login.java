package TaxiATC;

import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;

import javax.swing.*;
import java.util.*;//imports util package
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame// this class extends a JFrame class
{
   // Container con;
   // These are the variables which I have added and will be using
    private String username;
    private String password;
    private String save;
    private String clear;
    //button group for gender
    
    // These are giving properties to the JButtons, JLabels and JTextFields
    
    JLabel usernameLabel;
    JTextField usernameText;
    JLabel passwordLabel;
    JPasswordField passwordText;
    
    JLabel loginLabel;
    JButton loginButton;
    JButton returnButton;
    JButton registerButton;
    JLabel registerLabel;

    // This is a variable that allows the text to be saved in a text file
    String Accountfilename = "InputAccountDetails.txt";
    
    
    
    /**
     * This is a Constructor
     */
    public Login()
    {
                super("Login"); // this is the name of JFrame interface
                
               final Container con = getContentPane(); 
                
               /*
               * Create buttons, text fields and labels
                 */
            
                //This creates the gender button

                
                // these are the text fields where you enter details
                usernameLabel = new JLabel("Please enter your username: ");
                usernameText = new JTextField(22);
                passwordLabel = new JLabel("Enter your password:" );
                passwordText = new JPasswordField(22);


                // These are the instructions which are written on the buttons
                loginLabel = new JLabel("");
                loginButton = new JButton("Login");
                registerLabel = new JLabel("Forgot to Register?");
                returnButton = new JButton("Back");
                registerButton = new JButton("Register Now!");
                // this will print to a writer
                PrintWriter myStream;
                

                
                
       
                // This sets the layout
                FlowLayout myLayout = new FlowLayout();
                con.setLayout(myLayout);
                
               
                /*
                 * Add all created GUI elements to our content pane
                 */
                // These are the actual buttons added to the content pane
                con.add(usernameLabel);
                con.add(usernameText);
                con.add(passwordLabel);
                con.add(passwordText);
                
                
                con.add(loginLabel);
                con.add(loginButton);
                con.add(registerButton);
                con.add(returnButton);
                con.add(registerLabel);

            
            

        
                //this is the return button that opens the previous frame
                 returnButton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e)
                {
                	new Main();
                	dispose();
                }
             });        
 
              
           
            /*
             * What happens when we press the "Submit" button? 
             * when you press the submit button the text entered will come up in a JFrame interface
             */
            loginButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //these are the variables that get values from text fields
                  username = usernameText.getText();
                  password = passwordText.getText();
                  Connection connection;
                  PreparedStatement ps;
                  try {
                	  //this set's the database connection and runs an sql query
                      connection = DriverManager.getConnection("jdbc:mysql://10.1.63.200/Group 24", "1516627", "1516627");
                      ps = connection.prepareStatement("SELECT `USERNAME`, `PASSWORD` FROM `CustomerLogin` WHERE `username` = ? AND `password` = ?");
                      ps.setString(1, usernameText.getText());
                      ps.setString(2, String.valueOf(passwordText.getText()));
                      ResultSet result = ps.executeQuery();
                      if(result.next()){
                          new CustomerOption();
                          dispose();
                      }
                      else{
                    	  JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    	  
                      }
                  } catch (SQLException ex) {
                      Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                  }
                    
                    

                }
            });
            
            
            
            //this is the register button that opens the next frame

             registerButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                   new Registration();
                  dispose();
                }
            });
             

            
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
           Login myLogin = new Login();

       }
    }

