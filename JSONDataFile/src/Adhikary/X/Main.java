package Adhikary.X;

import Adhikary.X.Student.Course;
import Adhikary.X.Student.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Main {


	private static int studentCount = 0 ;
	public static void main(String... args)
	{
		Course jmc = new Course("JMC","Java Masterclass");
		Course pymc = new Course("Python","Python Masterclass");

		try (PrintWriter pw = new PrintWriter("studentsData.json"))
		{



			StringJoiner sj = new StringJoiner(" \n ,", "[\n", "\n]");
			Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
					.limit(4)
					.forEach((e) -> {

						StringJoiner engagementJoiner = new StringJoiner("\n}, { \n", "[{\n", "\n}]");


						for (String record : e.getEngagementRecords()) {
							String[] parts = record.split(",");
							String courseCode = parts[7];
							String engagementType = parts[2];
							String enrollmentMonth = parts[8];
							int enrolledYear = Integer.parseInt(parts[3]);
							String engagementString = """
											"courseCode" : "%s",
											"engagementType" : "Lecture %s",
											"enrollmentMonth" : "%s",
											"enrollmentYear" : %d
									""".formatted(courseCode, engagementType,
									enrollmentMonth, enrolledYear);

							engagementJoiner.add(engagementString);
						}


//					System.out.println(engagementJoiner);


						String studentString = """
								{
								"studentId" : %d,
								"demographics" : {
									"countryCode" : "%s",
									"enrolledMonth" : %d,
									"enrolledYear" : %d,
									"ageAtEnrollment" : %d,
									"gender" : "%s",
									"previousProgrammingExperience" : %b
									},
									"engagement" : %s
									}
								""".formatted(e.getStudentId()
								, e.getCountry()
								, e.getEnrollmentMonth()
								, e.getEnrollmentYear()
								, e.getEnrollmentAge()
								, e.getGender()
								, e.hasExperience()
								, engagementJoiner.toString());


						sj.add(studentString);
						studentCount++;
//						try {
//							if (studentCount % 2 == 0) {
//								Thread.sleep(2000);
////								System.out.println(".");
//
//								pw.println(sj);
//								pw.flush(); // Since we are writing a StringJoiner Instance there's no EOF like in a File would be
//								System.out.println(".");
//
//							}
////							System.out.println("here : " + sj.toString() + "\n");
////							pw.write(studentString);
//						} catch (InterruptedException f) {
//							throw new RuntimeException(f);
//						}

					});

			pw.println(sj);
			pw.flush();  /*

			 in order to actually do the disk write we have to manually flush the buffer data and thus
			  the disk write will be triggered , because disk writes do not happen until buffer memory is full and
			  a printWriter instance constructed using the above constructor implicitly constructs and uses a
			  bufferedWriter instance which implicitly has huge buffer memory which is not filled with small amounts of
			  data which is why we explicitly flushed the buffer and triggered the disk write

			  */

//			System.out.println(sj.toString());


		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


	}

}
