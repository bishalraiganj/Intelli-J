package Adhikary.X;

import java.time.LocalDate;

public class Main
{
    public static void main(String... args)
    {

        Course java =  new Course("JAVA01","Complete Java by Tim Buchalka",750);
        CourseEngagement bishal1 = new CourseEngagement(java, LocalDate.of(2010,3,1),"Studying",256,LocalDate.of(2025,1,1));

        System.out.println(bishal1.getMonthsSinceActive());




    }
}
