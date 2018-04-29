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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;


public class DeleteTrip extends JFrame {

	/**
	 * Launch the application.
	 */
	private String TripID;
	JLabel EnterLabel;
	    JButton EnterButton;
	    JLabel TripLabel;
	    JTextField TripIDText;
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
	public DeleteTrip() {
		final Container con = getContentPane(); 
		EnterLabel = new JLabel("Please enter your");
	    EnterButton = new JButton ("Enter");
	    TripLabel = new JLabel ("trip ID:");
	    TripIDText = new JTextField(22);

        PrintWriter myStream;
	    
	    FlowLayout myLayout = new FlowLayout();
	    con.setLayout(myLayout);
	    con.add(EnterLabel);
	    con.add(TripLabel);
        con.add(TripIDText);
	    con.add(EnterButton);
        
    	
        
        //this is the enter button that opens the next frame
        EnterButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
           TripID = TripIDText.getText();
           DatabaseConnection.theQuery("delete from Trip where TripID = '"+TripIDText.getText()+"'");
           JOptionPane.showMessageDialog(null, "Trip deleted!!"); 	
           dispose();

            	
            }
        });
        
        
        pack();
        setLocation(210,100);
        setSize(270, 180);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
	}
	


}



