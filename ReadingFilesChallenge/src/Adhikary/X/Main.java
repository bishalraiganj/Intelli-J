package Adhikary.X;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {

	public static void main(String... args)
	{

		try(BufferedReader br = new BufferedReader(new FileReader("article.txt")))
		{


//			System.out.printf("%,d lines in file%n",br.lines().count());

			Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");
//			System.out.printf("%,d words in file%n",br.lines()
////					.flatMap((e)->pattern.splitAsStream(e))
//							.flatMap((s)-> Arrays.stream(s.split(pattern.toString())))
//					.count());


			System.out.printf("%,d words in file%n",br.lines()
					.mapToLong((e)->e.split(pattern.toString()).length)
					.sum());

		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}




	}


}
