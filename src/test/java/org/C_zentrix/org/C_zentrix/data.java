package org.C_zentrix.org.C_zentrix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class data {
	static String s1,LicenseVersion,s3,s4,s5;
    static int state, Feature_Details,agent_id;
	public static void main(String[] args)
	{
		
		System.out.println("start database method");
		  //String input = args.length == 0 ? "1818-11-11" : args[0]; for save special type data
	      Connection con=null;
		  Statement st=null;
		  ResultSet rs=null;
		  ResultSet rs1=null;
		  ResultSet rs2=null;
		  ResultSet rs3=null;
		  
	  try{
		  try {
		  Class.forName("com.mysql.jdbc.Driver");//.newInstance();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  System.out.println("exception");
		  }
		     Class.forName("com.mysql.jdbc.Driver");
		  // Class.forName("oracle.jdbc.driver.oracleDriver");
			 System.out.println("Driver loaded");
			 con=DriverManager.getConnection("jdbc:mysql://172.16.2.25/czentrix_campaign_manager","himanshu677","Himanshu@677");
	        //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","himanshu","Himansu@123");
			 //172.16.2.179
			 if(con!=null) {
	             System.out.println("Connected to the database");
	         }else {
	             System.out.println("Failed to connect to  database");
	         }
			 String sql="select * from license";
			 String sql1="select * from features";
			 String sql2="select*from maximum";
			 String sql3="select list_id from list where list_name='List1'";
			 System.out.println("data base 1");
			 st=con.createStatement();
			 System.out.println("data base 2");
			 rs=st.executeQuery(sql);
			 System.out.println("data base 3");
			 System.out.println("database table row is\t"+rs.getRow());
			 System.out.println("data base 4");
		     while(rs.next())
			 {
			  LicenseVersion =rs.getString(2);
			  System.out.println("License version is::"+LicenseVersion);
	         }
			 rs1=st.executeQuery(sql1);
			 while(rs1.next())
			 {
		       //state =rs1.getString(2);
		         state=rs1.getInt(2);
		         System.out.println("state value is::"+state);
		         break;
		     }
			 rs2=st.executeQuery(sql2);
			 while(rs2.next())
			 {
				 System.out.println("hello himanshu ");
	             Feature_Details=rs2.getInt(3);
				 System.out.println("Feature_Details::" + Feature_Details);
			 }
			
			 rs3=st.executeQuery(sql3);
		
			 while(rs3.next())
			 {
				 System.out.println("in list table");
				 agent_id=rs3.getInt(1);
				 System.out.println("agent id is :" + agent_id);
			 }
	    }	 
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
	}

}
