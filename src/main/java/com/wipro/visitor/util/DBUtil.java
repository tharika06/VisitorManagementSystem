package com.wipro.visitor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
public static Connection getDBConnection() throws SQLException{
	Connection con=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		con=DriverManager.getConnection(url,"system","a");
		con.setAutoCommit(false);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;	
}
}
