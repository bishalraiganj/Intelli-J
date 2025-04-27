package Adhikary.X;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//
//			System.out.printf("%,d words in file%n",br.lines()
//					.mapToLong((e)->e.split(pattern.toString()).length)
//					.sum());


			System.out.println("-".repeat(50));

			Map<String,Long> result = br.lines()
					.flatMap((e)->pattern.splitAsStream(e))
					.map((e)->e.replaceAll("\\p{Punct}+",""))
					.map(String::toLowerCase)
					.filter((e)->e.length()>4)
					.collect(Collectors.groupingBy((e)->e,Collectors.counting()));

			result.entrySet().stream()
					.sorted(Comparator.comparing((e)->e.getValue(),Comparator.reverseOrder()))
					.limit(10)
					.forEach((e)->System.out
					.println(e.getKey() + " - " + e.getValue() + "times"));

		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}




	}


}
