package jdbc.j2ee.webtech4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// import java.util.Scanner;

public class SelectDemo {
	
	public static void main(String[] args) throws Exception 
 {
		
	  // v_* --> program variable, ui_* --> user input variable, p_* --> parameter variable

      //String v_name = "Disha";  -- it's hardcoded in sql insert stmt
	  //	String v_email ="priya@gmail.com";
	  //	String v_city = "Abc";  // after update city will be Pune
	  //String v_edu ="mca"; -- it's handled using Scanner input read	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Step 1: Driver load and register successful");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","april22");
		System.out.println("Step 2: Connection created successful");
				
		PreparedStatement ps = con.prepareStatement("select * from register");
		//ps.setString(1, v_city);
		//ps.setString(1, v_email);
		//System.out.println("Enter your Educational Degree -> ");
		//Scanner sc = new Scanner(System.in);			
		//String ui_edu = sc.nextLine();
		
		//ps.setString(2, ui_edu);

		System.out.println("Step 3: Statement Prepared Success\n \n");
		
		/* int val = ps.executeUpdate();*/		// executeUpdate is used for DML (Insert/Update/Delete)
		
		ResultSet rs = ps.executeQuery();		// executeQuery is used for SELECT
			//System.out.println(" | " + "fname" + " | " + "email" + " | " + "city" + " | " + "edu" + " | \n" );
		while (rs.next()) 
		{
//			String v_name  = rs.getString("fname");
//			String v_email = rs.getString("email");
//			String v_city  = rs.getString("city");
//			String v_edu   = rs.getString("edu");

			//System.out.println(" | " + v_name + " | " + v_email + " | " + v_city + " | " + v_edu + " | \n" );
			 System.out.println(" | " + rs.getString("fname")  + 
							    " | " + rs.getString("email")  + 
							    " | " + rs.getString("city")   + 
							    " | " + rs.getString("edu")    + 
							    " |     \n" );
						
		}
		
		//con.close();
			System.out.println(" Step 4: Statement Executiond successful");
		
 }
	
}
