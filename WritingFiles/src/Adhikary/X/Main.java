package Adhikary.X;

import Adhikary.X.Student.Course;
import Adhikary.X.Student.CourseEngagement;
import Adhikary.X.Student.Student;
import Adhikary.X.Student.StudentDemographics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{
		String header = """
				Student Id,Country Code,Enrolled Year,Age,Gender,\
				Experienced,Course Code,Engagement Month,Engagement Year,\
				Engagement Type""";

		Course jmc = new Course("JMC","Java Masterclass");
		Course pymc = new Course("Python","Python Masterclass");

		List<Student>  students = Stream
				.generate(()->Student.getRandomStudent(jmc,pymc))
				.limit(5)
				.collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)
				->e1.add(e2),(e3,e4)->e3.addAll(e4));
//		System.out.println(header);
//		students.forEach((e)->e.getEngagementRecords().forEach((e1)->System.out.println(e1)));

		Path path = Path.of("students.csv");

//		try{
//			Files.writeString(path,header);
//			for(Student student : students)
//			{
//				Files.write(path,student.getEngagementRecords(),
//						StandardOpenOption.APPEND);
//			}
//		} catch(IOException e)
//		{
//			e.printStackTrace();
//		}


		try{
			List<String> data = new ArrayList<>();
			data.add(header);
			for(Student student : students)
			{
				data.addAll(student.getEngagementRecords());
			}
			Files.write(path,data);
		} catch (IOException e)
		{
			e.printStackTrace();
		}


		System.out.println("-".repeat(50));
		Path path2 = Path.of("take2.csv");
		try(BufferedWriter writer = Files.newBufferedWriter(path2))
		{
			writer.write(header);
			writer.newLine();
			for(Student student : students)
			{
				for(String record : student.getEngagementRecords())
				{
					writer.write(record);
					writer.newLine();
				}
			}
		} catch(IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("-".repeat(50));


		try(BufferedWriter writer = Files.newBufferedWriter(path2))
		{
			writer.write(header);
			writer.newLine();
			for(Student student : students)
			{
				for(String record : student.getEngagementRecords())
				{
					writer.write(record);
					writer.newLine();
				}

			}


		} catch(IOException e)
		{
			e.printStackTrace();
		}



	}



}
