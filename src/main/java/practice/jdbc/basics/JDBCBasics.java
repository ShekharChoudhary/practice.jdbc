package practice.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBasics {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	static final String url = "jdbc:mysql://localhost:3306/mytestdb";
	static final String user ="root";
	static final String pass = "1234";
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(url, user, pass);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employee_details");
			/*
			 * this statement is for execute() command.
			boolean status = stmt.execute("select * from employee_details");
			System.out.println(status+" "+stmt.getResultSet());
			*/
			rs.next();
			System.out.println(rs.getInt("EMPLOYEE_ID"));
			System.out.println(rs.getString(2));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
