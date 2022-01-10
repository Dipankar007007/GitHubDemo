package EndtoEndFrameWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class mySqlDataBase {
	
	public static void main(String[] args) throws SQLException
	{
		String host="localhost";
		String port="3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/automation","root","mysql@007007");
		
		Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery("select * from Employeenfo  where Ename = 'Mohan'");
		while(result.next())
		{
			System.out.println(result.getString("id"));
			System.out.println(result.getInt("age"));
			System.out.println(result.getString("location"));
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
