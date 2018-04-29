package TaxiATC;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;


public class SearchTrips extends JFrame {

	/**
	 * Launch the application.
	 */
	private String Phone;
	JLabel EnterLabel;
	    JButton EnterButton;
	    JLabel PhoneLabel;
	    JTextField PhoneText;
	    String Accountfilename = "InputAccountDetails.txt";
	    
	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchTrips frame = new SearchTrips();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchTrips() {
		final Container con = getContentPane(); 
		EnterLabel = new JLabel("Please enter your");
	    EnterButton = new JButton ("Enter");
	    PhoneLabel = new JLabel ("phone number:");
        PhoneText = new JTextField(22);

//this creates the layout	    
	    FlowLayout myLayout = new FlowLayout();
	    con.setLayout(myLayout);
	    con.add(EnterLabel);
	    con.add(PhoneLabel);
        con.add(PhoneText);
	    con.add(EnterButton);
        
    	
        
        //this is the enter button that opens the next frame
        EnterButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
           Phone = PhoneText.getText();
           //this runs the method view from an other class
           view.theView("select * from Trip where Telephone = '"+PhoneText.getText()+"'");
            	

            	
            }
        });
        
        // this set's the Jframe size and location
        pack();
        setLocation(210,100);
        setSize(270, 180);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
	}
	


}



