package db_init;
import java.sql.*;
public class database_config
{
public static Connection get_connection()
{
	Connection con=null;
	String url="jdbc:sqlite:db/ShopDatabaseFile.db";
	try
	{
		con=DriverManager.getConnection(url);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Database Error : "+e.getMessage());
	}
	return con;
}
public static void main(String[]args)
{
	get_connection();
	System.out.println("Connected");
}
}

