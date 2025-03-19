package Adhikary.X;

import java.time.LocalDate;
import java.util.stream.Stream;

public class CourseEngagement {

    private final Course course;
    private final LocalDate enrollmentDate;
    private final String engagementType;
    private final int lastLecture;
    private final LocalDate lastActivityDate;

    public CourseEngagement(Course course,LocalDate enrollmentDate,String engagementType,int lastLecture,LocalDate lastActivityDate)
    {
        this.course = course;
        this.enrollmentDate  = enrollmentDate;
        this.engagementType  = engagementType;
        this.lastLecture = lastLecture;
        this.lastActivityDate = lastActivityDate;
    }

    public String getCourseCode()
    {
        return course.getCourseCode();
    }

    public int getEnrollmentYear()
    {
        return enrollmentDate.getYear();
    }

    public int getLastActivityYear()
    {
        return lastActivityDate.getYear();
    }

    public String  getLastActivityMonth()
    {
        return lastActivityDate.getMonth().toString();
    }

    public int getMonthsSinceActive()
    {
        return (int) Stream.iterate(getLastActivityYear()+1,(i)-> i< LocalDate.now().getYear(),(i)->i+1)
//                .peek(System.out::println)
                .count() *12+(12-lastActivityDate.getMonthValue())   ;
    }

    public LocalDate getLastActivityDate()
    {
        return lastActivityDate;
    }



}
