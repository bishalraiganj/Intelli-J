package Adhikary.X;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String... args)
	{

		try(Scanner scanner = new Scanner(new File("file.txt")))
		{
			while(scanner.hasNextLine())
			{
				System.out.println(scanner.nextLine());
			}


		} catch(IOException e )
		{
			throw new RuntimeException(e);
		}




	}


}
