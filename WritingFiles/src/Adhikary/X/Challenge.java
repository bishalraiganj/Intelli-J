package Adhikary.X;

import Adhikary.X.Student.Course;
import Adhikary.X.Student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Challenge {

	public static void main(String... args)
	{
		Course jmc =  new Course("JMC","Java Masterclass");
		Course pymc = new Course("PYC","Python Masterclass");

		List<String> students = Stream.generate(()->Student.getRandomStudent())
				.limit(2)
				.map((e)->e.toJSON())
				.collect(()->new ArrayList<>(),(ArrayList<String> e1, String e2)
		-> e1.add(e2),(e3,e4)->e3.addAll(e4));


		students.forEach(System.out::println);

		System.out.println("-".repeat(50));

		String s1 = Stream.generate(()->Student.getRandomStudent())
				.limit(2)
				.map((e)->e.toJSON())
				.collect(()->new StringBuilder(),(StringBuilder e1,String e2)
		->



				{ if(e1.length() > 0) {
					e1.append("," + e2);

				}
				else
					e1.append(e2);



	},(e3,e4)->e3.replace(0,e3.length(),e4.toString()))
				.toString();


		System.out.println(s1);


		System.out.println("-".repeat(50));





	}


}
