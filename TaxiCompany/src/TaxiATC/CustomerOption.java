package TaxiATC;


//This is the part where I am importing all the java libraries needed
import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;//imports util package
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.String;

public class CustomerOption extends JFrame// this class extends a JFrame class
{
 // Container con;
 // These are the variables which I have added and will be using
	


  //button group for gender
  
  // These are giving properties to the JButtons, JLabels and JTextFields
  ButtonGroup genderButtonGroup; 


  
  JLabel booktripLabel;
  JButton booktripButton;
  JButton viewtripsButton;
  JButton canceltripButton;
  JLabel canceltripLabel;
  // This is a variable that allows the text to be saved in a text file
  String Accountfilename = "InputAccountDetails.txt";
  
  
  
  /**
   * This is a Constructor
   */
  public CustomerOption()
  {
              super("Customer Options Page"); // this is the name of JFrame interface
              
             final Container con = getContentPane(); 
              
             /*
             * Create buttons, text fields and labels
               */
          
              //This creates the gender button
              genderButtonGroup = new ButtonGroup();
              
              // these are the text fields where you enter details

              
              // These are the instructions which are written on the buttons
              booktripLabel = new JLabel(" ");
              booktripButton = new JButton("Book Trip");
              viewtripsButton = new JButton("View Trips");
              canceltripButton = new JButton("Cancel Trip");
              canceltripLabel = new JLabel(" ");
              // this will print to a writer
              PrintWriter myStream;
              
              

             
              
              
     
              // This sets the layout
              FlowLayout myLayout = new FlowLayout();
              con.setLayout(myLayout);
              


              con.add(booktripLabel);
              con.add(booktripButton);
              con.add(viewtripsButton);
              con.add(canceltripButton);
              con.add(canceltripLabel);
              
          

              //this is the book trip button that opens the next frame
              booktripButton.addActionListener(new ActionListener()
           {
              public void actionPerformed(ActionEvent e)
              {
                 new Booking();
                 dispose();
              }
           });        
                     
              //this is the view trips button that opens the next frame

              viewtripsButton.addActionListener(new ActionListener()
             {
                 public void actionPerformed(ActionEvent e)
              {
              new SearchTrips();
              	  
         }
      });           
            
         
              //this is the cancel trip button that opens the next frame
              canceltripButton.addActionListener(new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
              	 new DeleteTrip();
              	 
              }
          });
          
          JPanel p = new JPanel();
          p.setBackground(Color.BLACK);

          
          
          /*
           * this sets the JFrame size
           */
          
          
          pack();
          setLocation(500,350);
          setSize(300, 200);
          setVisible(true);
          setResizable(false);
          setBackground(Color.BLUE);

      }
      
  
      
      public static void main (String[] args)
     {
          new CustomerOption();

     }
  }

