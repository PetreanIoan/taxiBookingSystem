package TaxiATC;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.*;

public class Customer extends JFrame {
	
    JLabel loginLabel;
    JButton loginButton;
    JLabel registerLabel;
    JButton registerButton;
    JButton returnButton;
    
    public Customer(){
    	super("Customer Page"); // this is the name of JFrame interface
        
        final Container con = getContentPane();
        //this set's the label's and buttons
        loginLabel = new JLabel("");
        loginButton = new JButton("Login");
        registerLabel = new JLabel("");
        registerButton = new JButton("Register");
        returnButton = new JButton("Back");
        
   
        // this will Sets the layout
        FlowLayout myLayout = new FlowLayout();
        con.setLayout(myLayout);
        
        con.add(loginLabel);
        con.add(loginButton);
        con.add(registerLabel);
        con.add(registerButton);
        con.add(returnButton);
        
        //this is the login button that opens the next frame
        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	String first = e.getActionCommand();
            	
            		new Login();
            		dispose();
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
        //this is the return button that opens the previous frame
        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	 new Main();
            	dispose();
            }
        });
       
        
        pack();
        setLocation(210,150);
        setSize(400,200);
        setVisible(true);
        setResizable(false);

    }
    public static void main (String[] args)
   {
       Customer myLogin = new Customer();
       
   
   }
	
}

