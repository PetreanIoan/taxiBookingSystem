package TaxiATC;
/**
 */
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class  DatabaseConnection  
{
    // the database connector details  
    static final String DRIVER = "com.mysql.jdbc.Driver"; // JDBC driver
    static final String DATABASE = "Group 24"; // the database name
    static final String HOST = "10.1.63.200"; // the database host IP

    // the full URL:
    static final String DATABASE_URL =
        "jdbc:mysql://" + HOST + "/" + DATABASE;

    public Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String results = null;
    String password = null;
    String user = null;
    String sqlQuery = null;

    // launch the application


    /**
     * Returns true if connection could be established, false otherwise
     */
    public boolean setConnection()
    {
        boolean connectionOK = false;
        // connect to database 
        try 
        {
            // load the driver class
            Class.forName(DRIVER);
            // establish connection to database    
            connection =  DriverManager.getConnection(DATABASE_URL, user, password);
            connectionOK = true;  // never reached if exception thrown
        }
        catch (SQLException sqlException)                                
        {       
            System.err.println("Driver loaded, but something went wrong elsewhere!");               
            sqlException.printStackTrace();

        } // end catch                                                     
        catch (ClassNotFoundException classNotFound)                     
        {                        
            System.err.println("Couldn't find driver!");
            classNotFound.printStackTrace();            
        } // end catch                             

        return connectionOK;
    }

    public static void theQuery(String query)
    {
    	Connection con =null;
    	Statement st = null;
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://10.1.63.200/Group 24","1516627", "1516627");
    		st = con.createStatement();
    		st.executeUpdate(query);
    		
    	}
    	catch(Exception ex) {
    		JOptionPane.showMessageDialog(null,ex.getMessage());
    		
    	}
    }
}
