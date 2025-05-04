package Adhikary.X;

import Adhikary.X.Student.Course;
import Adhikary.X.Student.CourseEngagement;
import Adhikary.X.Student.Student;
import Adhikary.X.Student.StudentDemographics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
				.limit(25)
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
			int count = 0;
			writer.write(header);
			writer.newLine();
			for(Student student : students)
			{
				for(String record : student.getEngagementRecords())
				{
					writer.write(record);
					writer.newLine();
					count++;
					if(count % 5 == 0)
					{
						Thread.sleep(2000);
						System.out.print(".");
					}

					if(count % 10 == 0)
					{
						writer.flush();
					}
				}
			}
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}

		System.out.println("-".repeat(50));


		try(FileWriter writer = new FileWriter("take3.csv"))
		{
			writer.write(header);
//			writer.newLine();

			writer.write(System.lineSeparator());
			for(Student student : students)
			{
				for(String record : student.getEngagementRecords())
				{
					writer.write(record);
//					writer.newLine();
					writer.write(System.lineSeparator());
				}

			}


		} catch(IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("-".repeat(50));

		try(PrintWriter writer = new PrintWriter("take4.txt"))
		{
			writer.println(header);
			for(Student student : students)
			{
				for(String record : student.getEngagementRecords())
				{
					String[] recordData = record.split(",");
					writer.printf("%-12d%-5s%2d%4d%3d%-1s".formatted(
							 student.getStudentId() //Student Id
							,student.getCountry() //Country Code
							,student.getEnrollmentYear() // Enrolled Year
							,student.getEnrollmentMonth() // Enrolled Month
							,student.getEnrollmentAge() // Age
							,student.getGender() // Gender
					)); // used println inplace of write() since both has the same functionality

					writer.printf("-1s",(student.hasExperience()?"Y":"N")); // Experienced in Programming ?

					writer.format("%-3s%10.2f%-10s%-4s%-30s",
							recordData[7] //Couse Code
							,student.getPercentComplete(recordData[7]) //Percentage of Course Complete  )
							,recordData[8] // Engagement Month
							,recordData[9] // Engagement Year
							,recordData[10] ); // Engagement Type

					writer.println();

				}
			}


		} catch(IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("-".repeat(50));


	}

	public static void recurseCopy(Path source,Path target) throws IOException
	{
		Files.copy(source,target);
		if(Files.isDirectory(source))
		{
			try(Stream<Path> children = Files.list(source))
			{
				children.collect(()->new ArrayList<>(),
								(ArrayList<Path> e1,Path e2)->e1.add(e2)
								,
								(e3,e4)->e3.addAll(e4))
						.forEach((pathInstance)->

						{
							try {
								recurseCopy(pathInstance,target.resolve(pathInstance.getFileName()));

							} catch (IOException e)
							{
								throw new RuntimeException(e);
							}
						});



			} catch(IOException e)
			{
				throw new RuntimeException(e);
			}


		}



	}




}
