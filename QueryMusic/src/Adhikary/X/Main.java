package Adhikary.X;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

	public static void main(String... args)
	{

		Properties props = new Properties();

		try
		{
			props.load(new BufferedInputStream(new FileInputStream("music.properties")));

		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}

		String query = "SELECT * FROM music.artists";



		MysqlDataSource dataSource  = new MysqlDataSource();

		dataSource.setServerName(props.getProperty("serverName"));
		dataSource.setPort(Integer.parseInt(props.getProperty("port")));
		dataSource.setDatabaseName(props.getProperty("databaseName"));

		try(Connection connection = dataSource.getConnection(props.getProperty("user"),System.getenv("MYSQL_PASS"));
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query))
		{

			JOptionPane.showMessageDialog(null,"Connected to : " + dataSource.getServerName());
			System.out.println("Connected to : " + props.getProperty("serverName"));

			while(resultSet.next())
			{
				System.out.printf("%d %s %n", resultSet.getInt(1),
						resultSet.getString("artist_name")
				);


			}



		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, e);
			throw new RuntimeException(e);
		}





	}


}
