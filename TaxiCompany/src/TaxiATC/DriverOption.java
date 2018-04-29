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
public class DriverOption extends JFrame//declares AccountDemo class
{
   // this is the Container con;

   
    
    String[] storeData;// this will hold the file lines
    

    JButton ViewJobsButton;
    JButton LogOutButton;
    
   
    
   
    
    
    JButton AssignDriversFieldsButton;
 
    
    /*
    * this is stream it will write to file 
    */
    PrintWriter myStream;
    /*
     * this stream is to read from file 
     */
    BufferedReader inputStream;
    String Accountfilename = "saved.txt";
    
    /*
     * this is the Constructor
     */
    public DriverOption()
    {
        super("Driver Option Page");
        final Container con = getContentPane(); 
        
        
        // this will create the text fields,buttons and labels 
         
        
     
        ViewJobsButton = new JButton("View jobs");
        LogOutButton = new JButton("Log out");
        
        
    
        
        
        
         // this will Sets the layout
         
        FlowLayout myLayout = new FlowLayout();
        //BoxLayout myLayout = new BoxLayout(con, BoxLayout.PAGE_AXIS);
        con.setLayout(myLayout);
        
        
  

        con.add(ViewJobsButton);
        con.add(LogOutButton);
        
     
        

        //this is view button that opens the next frame

        ViewJobsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                view.theView("select * from Trip where Status = 'pending'");
             
                
               
            }
        });
        
        
       
        
        
       
      
        
    
        
       
   
          
        //this is the logout button that opens the main frame
        LogOutButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                   new Main();
                   dispose();
                       
                    }
                });
        
       
        //this set's the Jframe size and location
        pack();
        setLocation(210,150);
        setSize(290, 250);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main (String[] args) 
   {
         new DriverOption();
   }
}

