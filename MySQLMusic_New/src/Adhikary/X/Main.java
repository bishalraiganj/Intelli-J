package Adhikary.X;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {

	private final static String CONN_STRING = "jdbc:mysql://localhost:3306/";

	public static void main(String... args)
	{

		String username = JOptionPane.showInputDialog(null,"Enter DB Username");

		JPasswordField pf = new JPasswordField();

		int okCxl = JOptionPane.showConfirmDialog(null,pf,"Enter DB Password",JOptionPane.OK_CANCEL_OPTION);


		final char[] password = (okCxl == JOptionPane.OK_OPTION)  ? pf.getPassword() : null;


		MysqlDataSource dataSource = new MysqlDataSource();

//		dataSource.setURL(CONN_STRING);

		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("music");

		try(Connection connection = dataSource.getConnection(username,String.valueOf(password)))
		{
			JOptionPane.showMessageDialog(null,"Connected to : " + CONN_STRING);
			System.out.println("Connected to : " + CONN_STRING);

		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e);
			throw new RuntimeException(e);
		}




//		try(Connection connection = DriverManager.getConnection(CONN_STRING,username,String.valueOf(password)))
//		{
//			JOptionPane.showMessageDialog(null,"Connected to : " + CONN_STRING);
//			System.out.println("Success !! Connection made to the music database ");
//			Arrays.fill(password,' ');
//		}catch(SQLException e)
//		{
//			JOptionPane.showMessageDialog(null,"Connection Failed ! :-) ");
//			throw new RuntimeException(e);
//		}
	}

}
