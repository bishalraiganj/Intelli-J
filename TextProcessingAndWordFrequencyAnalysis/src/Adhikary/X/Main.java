package Adhikary.X;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{


		System.out.println("-".repeat(50));

		Path path = Path.of("file.txt");
		analyzingStream(path);


		System.out.println("-".repeat(50));



	}

	private static void analyzingStream(Path path)
	{
		Pattern p = Pattern.compile("[A-Z\\p{Punct}a-z0-9]+");

		try(Stream<String> streamStringOfLines = Files.lines(path))
		{
			Map<String,Long> wordFrequencies = streamStringOfLines
					.map((e)->p.matcher(e))
					.flatMap((matcher)->matcher.results())
					.map((matchResult)-> matchResult.group().replaceAll("\\p{Punct}",""))
					.filter((word)->word.length()>=5)
//					.sorted()
					.collect(Collectors.groupingBy((e)->e,()->new LinkedHashMap<>(),Collectors.counting()));

			wordFrequencies.entrySet().forEach(System.out::println);


		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}


	}

	private static void analyzingSimply(Path path)
	{





	}



}
