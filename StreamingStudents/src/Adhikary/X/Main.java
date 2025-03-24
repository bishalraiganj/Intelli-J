package Adhikary.X;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Main
{
    public static void main(String... args)
    {

        Course java =  new Course("JAVA01","Complete Java by Tim Buchalka",750);
        Course dsa = new Course("DSA01","Data Structures and Algorithms by Tim Buchalka",300);
        Course  advancedAlgorithms = new Course("ADALGO01","Advanced Algorithms by Tim Buchalka",200);
        CourseEngagement bishal1 = new CourseEngagement(java, LocalDate.of(2010,3,1),"Studying",375,LocalDate.of(2023,3,1));
        CourseEngagement dsa1 = new CourseEngagement(dsa,LocalDate.of(2010,3,1),"Studying",22,LocalDate.of(2022,2,1));
        CourseEngagement adAlgo1 = new CourseEngagement(advancedAlgorithms,LocalDate.of(2010,3,1),"Studying",30,LocalDate.of(2023,1,1));

        Map<String,CourseEngagement> engagementMap = new TreeMap<>(Map.of(
                "JAVA01",bishal1,
                "DSA01",dsa1,
                "ADALGO01",adAlgo1
        ));

        Course[] programmingCourses = {java,dsa,advancedAlgorithms};




        Student bishalAdhikary = new Student(6297609615L,"INDIA",2010,24,"MALE",true,programmingCourses);








//        System.out.println(bishal1.getMonthsSinceActive());
//        System.out.println("\n"+bishal1.getPercentComplete()+" %");
//
//        System.out.println("-".repeat(50));
//        System.out.println(bishalAdhikary.getMonthsSinceActive());
//
//        System.out.println(bishal1.getMonthsSinceActive());
//
//        System.out.println("-".repeat(50));





    }
}
