package Adhikary.X;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MusicDML {

	public static void main(String... args)
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}

		try(Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/music",
				System.getenv("MYSQl_USER"),
				System.getenv("MYSQL_PASS"));
			Statement statement = connection.createStatement();
		)
		{
			String artist = "elf";
			String query = " SELECT * FROM artists WHERE artist_name='s'"
					.formatted(artist);
			boolean result = statement.execute(query);
			System.out.println("result: " + result);

		}catch(SQLException e)
		{
			throw new RuntimeException(e);
		}


	}



}
