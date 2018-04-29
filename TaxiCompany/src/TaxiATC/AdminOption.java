package TaxiATC;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminOption extends JFrame {

	private JPanel Content;
	private String driver;
	private String order;

//	this are the connection statements
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
    

	
// here there are all the variables declared
	   String query;
	   private JTable Table1;
	   private JLabel orders;
	   private JTable Table2;
	   private JLabel drivers;
	   private JButton ViewDrivers;
	   private JButton Button;
	   private JButton Button2;
	   private JScrollPane Pane;
	   private JScrollPane Pane2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					AdminOption frame = new AdminOption();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This is the constructor that create's the frame and set the frame's size
	 * and location
	 */
	public AdminOption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(680, 500);
	    this.setLocationRelativeTo(null);
	 	this.setResizable(false);
	 	Content = new JPanel();
	 	Content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Content);
			
		//this is the view order's button that loads all the orders from the database
		JButton Button = new JButton("View Orders");
		Button.setBounds(220, 400, 135, 53);
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retrieveOrders();
				
			}
		});
		Content.setLayout(null);
			
		//this is the view driver's button that loads all the available drivers from the database
		ViewDrivers = new JButton("View Drivers");
		ViewDrivers.setBounds(80, 400, 135, 53);
		Content.add(ViewDrivers);
		
		ViewDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retrieveDrivers();
				
			}
		});
		Content.add(Button);
		
		Pane = new JScrollPane();
		Pane.setBounds(10, 31, 660, 149);
		Content.add(Pane);
		//this statement is creating the first Jtable
		Table1 = new JTable();
		
		Table1.setRowSelectionAllowed(true);
		Table1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	 if (Table1.getSelectedRow() > -1) {
	        		 order = Table1.getValueAt(Table1.getSelectedRow(), 0).toString();
	 	            System.out.println(order);
	 	            if(order != null && driver != null) {
	 	            	Button2.setEnabled(true);
	 	            } else {
	 	            	Button2.setEnabled(false);
	 	            }
	        	 }
	        }
	    });
		
		Pane.setViewportView(Table1);
		
//this set's the jlabel orders bounds
		orders = new JLabel("Orders");
		orders.setBounds(10, 11, 91, 14);
		Content.add(orders);
		
		Pane2 = new JScrollPane();
		Pane2.setBounds(10, 210, 660, 149);
		Content.add(Pane2);
		//this is creating the second Jtable
		Table2 = new JTable();
		Table2.setRowSelectionAllowed(true);
		Table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	 if (Table2.getSelectedRow() > -1) {
	        		 driver = Table2.getValueAt(Table2.getSelectedRow(), 0).toString();
	 	            System.out.println(driver);
		 	           if(order != null && driver != null) {
		 	        	  Button2.setEnabled(true);
		 	            } else {
		 	            	Button2.setEnabled(false);
		 	            }
	        	 }
	        }
	    });
		Pane2.setViewportView(Table2);
		//this set's jlabel drivers bounds
		drivers = new JLabel("Drivers");
		drivers.setBounds(10, 185, 46, 14);
		Content.add(drivers);
		//this is the assign driver's button the selected driver to a command
		Button2 = new JButton("Assign Driver");
		Button2.setEnabled(false);
		Button2.setBounds(360, 400, 135, 53);
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignDriver(order, driver);
				retrieveDrivers();
				retrieveOrders();
			}
		});
		Content.add(Button2);
		

		
	
	

    }
	
	public void retrieveOrders() {
		Connection connection;
        java.sql.PreparedStatement pst;
		
		//this set's the connection with the database and runs a sql query
	
		try {
               connection = DriverManager.getConnection("jdbc:mysql://10.1.63.200/Group 24", "1516627", "1516627");
               pst = connection.prepareStatement("select * from Trip where status ='pending'");
               rs = pst.executeQuery();
               Table1.setModel(DbUtils.resultSetToTableModel(rs));
               if (rs.next());
            	
		
		}catch (Exception e1){
			e1.printStackTrace();
			
		}
		
	}
	
	public void retrieveDrivers(){
		Connection connection;
        java.sql.PreparedStatement pst;
		
		
		//this set's the connection with the database and runs a sql query
		try {
               connection = DriverManager.getConnection("jdbc:mysql://10.1.63.200/Group 24", "1516627", "1516627");
               pst = connection.prepareStatement("select * from Driver where Available = 'yes'");
               rs = pst.executeQuery();
               Table2.setModel(DbUtils.resultSetToTableModel(rs));
               if (rs.next());
            	
		
		}catch (Exception e1){
			e1.printStackTrace();
			
		}
		
		
	}
	
	public void assignDriver( String order, String driver){
		Connection connection;
		
		//this set's the connection with the database and runs a sql query
		try {
               connection = DriverManager.getConnection("jdbc:mysql://10.1.63.200/Group 24", "1516627", "1516627");
               Statement stmt = connection.createStatement();
               String sql1 = "update Driver set available = 'no' where DriverID = " + driver;
               String sql2 = "update Trip set status = 'accepted', Driver = 'SG LM 145'  where TripID = 1";
               stmt.addBatch(sql1);
               stmt.addBatch(sql2);
               stmt.executeBatch();
               this.driver = null;
               this.order = null;
               Button2.setEnabled(false);
             
 
              
            	
		}catch (Exception e1){
			e1.printStackTrace();
			
		}
		
		
	}
}
