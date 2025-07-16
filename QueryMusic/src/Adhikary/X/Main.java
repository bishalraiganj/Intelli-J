package Adhikary.X;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

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




		MysqlDataSource dataSource  = new MysqlDataSource();

		dataSource.setServerName(props.getProperty("serverName"));
		dataSource.setPort(Integer.parseInt(props.getProperty("port")));
		dataSource.setDatabaseName(props.getProperty("databaseName"));


		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an Artist  id: ");
		String artistId = scanner.nextLine();
		int artistIdInt = Integer.parseInt(artistId);
		String query = "SELECT * FROM music.artists WHERE artist_id=%d"
				.formatted(artistIdInt);

		try(Connection connection = dataSource.getConnection(props.getProperty("user"),System.getenv("MYSQL_PASS"));
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query))
		{

			JOptionPane.showMessageDialog(null,"Connected to : " + dataSource.getServerName());
			System.out.println("Connected to : " + props.getProperty("serverName"));


			ResultSetMetaData meta = resultSet.getMetaData();

//			for( int i = 1; i <= meta.getColumnCount(); i++)
//			{
//				System.out.printf(" %d %s %s %n",
//						i,
//						meta.getColumnName(i),
//						meta.getColumnTypeName(i));
//
//			}

			System.out.println("-".repeat(100));

			for(int i = 1 ; i <= meta.getColumnCount(); i++)
			{
				System.out.printf("%-15s",meta.getColumnName(i).toUpperCase());

			}

			System.out.println();

			while(resultSet.next())
			{
//				System.out.printf("%d %s %s %n",
//						resultSet.getInt("track_number"),
//						resultSet.getString("artist_name"),
//						resultSet.getString("song_title")
//				);

				for(int i = 1 ; i <= meta.getColumnCount(); i++)
				{

					System.out.printf("%-15s",resultSet.getString(i).toUpperCase());

				}

				System.out.println();

			}



		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, e);
			throw new RuntimeException(e);
		}





	}


}
