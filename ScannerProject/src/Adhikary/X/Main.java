package Adhikary.X;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{

		try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("fixedWidth.txt"))))
		{
//			while(scanner.hasNextLine())
//			{
//				System.out.println(scanner.nextLine());
//			}

//			System.out.println(scanner.delimiter());
//
//			System.out.println("-".repeat(50));

//			scanner.useDelimiter("$");
//			scanner.tokens()
//					.forEach(System.out::println);
//
//			System.out.println("-".repeat(50));

//			scanner.findAll("[A-Za-z]{10,}")
//					.map((matchResult)->matchResult.group())
//					.distinct()
//					.sorted()
//					.forEach(System.out::println);


			String[] results =
					scanner
							.findAll("(.{15})(.{3})(.{12})(.{8})(.{2}).*")
							.skip(1)
							.map((matchResult)->matchResult.group(3).trim())
							.distinct()
							.sorted()
							.toArray((e)->new String[e]); // we can replace this lambda with the method reference String::new ,here the int size value is passed implicitly in the method reference by inference

			System.out.println(Arrays.toString(results));


		} catch(IOException e )
		{
			throw new RuntimeException(e);
		}




	}


}
