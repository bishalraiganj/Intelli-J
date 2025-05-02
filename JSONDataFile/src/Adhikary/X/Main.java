package Adhikary.X;

import Adhikary.X.Student.Student;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{

		StringJoiner sj =  new StringJoiner("\n} \n , {\n ,","[{\n","\n}]");
		Stream.generate(()-> Student.getRandomStudent())
				.limit(2)
				.forEach((e)->{

					StringJoiner engagementJoiner = new StringJoiner("\n}, { \n","[{\n","\n}]");


					for(String record : e.getEngagementRecords() )
					{
						String[] parts = record.split(",");
						String courseCode = parts[1];
						String engagementType = parts[2];
						String enrollmentMonth = parts[8];
						String enrolledYear = parts[3];
						String engagementString = """
								courseCode : %s,
								engagementType : %s,
								enrollmentMonth : %s,
								enrollmentYear : %s
						""".formatted(courseCode,engagementType,
								enrollmentMonth,enrolledYear);

						engagementJoiner.add(engagementString);
					}


					String studentString = """
							studentId : %d,
							demographics : {
								countryCode : %s,
								enrollmentMonth : %d,
								enrolledYear : %d,
								ageAtEnrollment : %d,
								gender : %s,
								previousProgrammingExperience : %s
								},
								engagement : 
							""".formatted(e.getStudentId()
							,e.getCountry()
							,e.getEnrollmentMonth()
							,e.getEnrollmentYear()
							,e.getEnrollmentAge()
							,e.getGender()
							,e.hasExperience()
							,engagementJoiner.toString());


					sj.add(studentString);

				});

		System.out.println(sj.toString());





	}

}
