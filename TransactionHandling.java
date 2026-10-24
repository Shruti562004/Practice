package transactionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionHandling {
	public static void main(String[] args) throws Exception {

	    Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection con = DriverManager.getConnection(
	        "jdbc:mysql://localhost:3306/advjava",
	        "root",
	        "shruti5"
	    );
	    
	    try {
	    	
	    	// Disable auto-commit 
	    	con.setAutoCommit(false);
	    	Statement st = con.createStatement();
	    	
	    	// Debit Rahul
	    	st.executeUpdate( "UPDATE accounts SET balance = balance - 1000 WHERE id = 1" );

	    
	    	// Credit Amit 
	    	st.executeUpdate( "UPDATE accounts SET balance = balance + 1000 WHERE id = 2" );
	    	// Save both changes 
	    	con.commit();
	    	System.out.println("Transaction Successful"); 
	    	st.close();
	    }
	    catch (Exception e) {

	        // Cancel changes if an error occurs
	        con.rollback();

	        System.out.println("Transaction Failed");
	        e.printStackTrace();

	    } finally {
	        con.close();
	    }
	}

	}
