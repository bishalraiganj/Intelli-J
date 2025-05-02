package Adhikary.X;

import Adhikary.X.Student.Course;
import Adhikary.X.Student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Challenge {


	private static int studentCount = 0;
	private static int accumulationCount = 0;
	public static void main(String... args)
	{
		Course jmc =  new Course("JMC","Java Masterclass");
		Course pymc = new Course("PYC","Python Masterclass");

		List<String> students = Stream.generate(()->Student.getRandomStudent())
				.limit(2)
				.map((e)-> e.toJSON())
				.collect(()->new ArrayList<>(),(ArrayList<String> e1, String e2)
		-> e1.add(e2),(e3,e4)->e3.addAll(e4));


		students.forEach(System.out::println);

		System.out.println("-".repeat(50));

		String s1 = Stream.generate(()->Student.getRandomStudent())
				.limit(4)
				.map((e)->
				{
					studentCount++;
					return e.toJSON();
				})
				.collect(()->new StringBuilder(),(StringBuilder e1,String e2)
		->



				{ if(e1.length() > 0 && accumulationCount != studentCount-1)
				{
					e1.append("," + e2);
					accumulationCount++;

				}
				else if(e1.length() == 0) {
					e1.append("[" + e2);
					accumulationCount++;
				}
				else if(accumulationCount == studentCount-1)
				{
					e1.append("," + e2 + "]");
					accumulationCount++;
				}

	},(e3,e4)->e3.replace(0,e3.length(),e4.toString()))
				.toString();


		System.out.println(s1);

		System.out.println("-".repeat(50));



		System.out.println(":".repeat(50));




		String delimiter = "," + System.lineSeparator();

		String s2 = Stream.generate(()->Student.getRandomStudent())
				.limit(1000)
				.map((e)->e.toJSON())
				.collect(Collectors.joining(delimiter,"[","]"));

		System.out.println(s2);
		try
		{
			Files.writeString(Path.of("studentsData3.json"),s2);
		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}



		try
		{
			Files.writeString(Path.of("StudentsData.json"),s1);

		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}



		System.out.println(studentCount);
		System.out.println("-".repeat(50));





	}


}
