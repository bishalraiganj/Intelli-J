package Adhikary.X;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{

		System.out.println(System.getProperty("file.encoding"));
		System.out.println(Charset.defaultCharset());

		Path path = Path.of("fixedWidth.txt");

		try{

			System.out.println(new String(Files.readAllBytes(path)));
			System.out.println("-".repeat(50));
			System.out.println(new String(Files.readString(path)));

			Pattern p = Pattern.compile("(.{15})(.{3})(.{12})(.{8})(.{2}).*");
			Set<String> values = new TreeSet<>();
			Files.readAllLines(path)

					.forEach((e)->{
						Matcher m =  p.matcher(e);
						if(!e.startsWith("Name")) {
							if (m.matches()) {
								values.add(m.group(3).trim());
							}
						}


					});
			System.out.println(values);
			System.out.println("-".repeat(50));

			try(Stream<String> stringStream = Files.lines(path))
			{
				String[] results = stringStream
						.map((e)->p.matcher(e))
						.filter((e)->e.matches())
						.map((e)->e.group(3).trim())
						.distinct()
						.sorted()
						.toArray(String[]::new);
				System.out.println(Arrays.toString(results));
			}

			try(Stream<String> stringStream = Files.lines(path))
			{

				Map<String,Long> results = stringStream
						.skip(1)
						.map((e)->p.matcher(e))
						.filter(Matcher::matches)
						.collect(Collectors.groupingBy((e)->e.group(3).trim(),Collectors.counting()));



				results.entrySet().forEach((e)->System.out.println(e));




			}
			catch(IOException e)
			{
				throw new RuntimeException(e);
			}


		} catch (IOException e)
		{
			throw new RuntimeException(e);
		}






	}


}
