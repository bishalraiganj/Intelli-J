package Adhikary.X;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{


		System.out.println("-".repeat(50));

		Path path = Path.of("file.txt");
		Path path2 = Path.of("article.txt");
		Path path3 = Path.of("bigben.txt");

		analyzingStream(path3);


		System.out.println("-".repeat(50));


		System.out.println("-".repeat(50)+ "Here invoked/called the analyzingSimply()" + "-".repeat(50));

		analyzingSimply(path2);

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
					.collect(Collectors.groupingBy((e)->e.toLowerCase(),()->new LinkedHashMap<>(),Collectors.counting()));

			wordFrequencies.entrySet().forEach(System.out::println);

			System.out.println("-".repeat(50)+  " Here Ordered  based on the word frequencies  (Ascending Order ) !" + "-".repeat(50));
			wordFrequencies.entrySet().stream()
					.sorted(Comparator.comparing((entry)->entry.getValue()))
					.forEach(System.out::println);





			System.out.println("-".repeat(50) + "! Here , we have collected into a linkedHashMap and reversed the order (Descending Order) !");





		 	LinkedHashMap<String,Long> orderedFrequencies =	wordFrequencies.entrySet()
					.stream()
					.sorted(Comparator.comparing((entry)->entry.getValue()))
					.collect(()-> new LinkedHashMap<>(),(LinkedHashMap<String,Long> e1, Map.Entry<String,Long> e2)->e1.put(e2.getKey(),e2.getValue()),(e3,e4)->e3.putAll(e4));


//			LinkedHashMap<String,Long> DescendingOrder =orderedFrequencies.reversed();

//					.limit()
					orderedFrequencies
							.reversed() // this method returns  a sequenced map
							.entrySet()
							.stream()
							.limit(10)
							.forEach((entry)->System.out.println(entry.getKey()+ " = " + entry.getValue()));


		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}


	}

	private static void analyzingSimply(Path path)
	{
		Pattern pattern  = Pattern.compile("[A-Za-z0-9\\p{Punct}]+");

		List<String> excluded = List.of("grand"
						,"canyon"
						,"retrieved"
						,"archived"
						,"service"
						,"original");

		try
		{
			Map<String,Long> wordFrequencies = new LinkedHashMap<>();
			Matcher m = pattern.matcher(Files.readString(path));
			while(m.find())
			{
				String processedWord  = m.group().replaceAll("\\p{Punct}","").toLowerCase();
				if(processedWord.length()>=5) {
					wordFrequencies.merge(processedWord, 1L, (o, n) -> o + 1);
				}
			}

			 wordFrequencies.entrySet().stream()
					.sorted(Comparator.comparing((entry)->entry.getValue(),Comparator.reverseOrder()))
					 .filter((entry)->!excluded.contains(entry.getKey()))
					.limit(10)
					.forEach((entry)->System.out.println(entry.getKey() + " = " + entry.getValue()));
//					.count();

//			System.out.println("Word Count  : " + wordCount);
		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}







	}



}
