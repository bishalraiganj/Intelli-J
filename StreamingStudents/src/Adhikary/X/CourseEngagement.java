package Adhikary.X;

import java.time.LocalDate;
import java.util.stream.Stream;

public class CourseEngagement implements Comparable<CourseEngagement>{

    private final Course course;
    private final LocalDate enrollmentDate;
    private  String engagementType;
    private  int lastLecture;
    private  LocalDate lastActivityDate;

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
//        return (int) Stream.iterate(getLastActivityYear()+1,(i)-> i< now.getYear(),(i)->i+1)
//                .filter((e)->e<now.getYear()&&lastActivityDate.getYear()!=now.getYear()-1)
//                .peek(System.out::println)
//                .count() *12+(lastActivityDate.getYear()==now.getYear()?now.getMonthValue()-lastActivityDate.getMonthValue():(12-lastActivityDate.getMonthValue())+now.getMonthValue());

        LocalDate now = LocalDate.now();
        if(lastActivityDate.getYear()==now.getYear())
        {
            return now.getMonthValue()-lastActivityDate.getMonthValue();
        }
        else if(lastActivityDate.getYear()==now.getYear()-1)
        {
            return (12-lastActivityDate.getMonthValue())+now.getMonthValue();
        }
        else

            return (now.getYear()-lastActivityDate.getYear()-1)*12+(12-lastActivityDate.getMonthValue())+now.getMonthValue();

    }

    public double getPercentComplete()
    {
        return (double) lastLecture/( (double)course.getLectureCount()/100);

    }

    public void watchLecture(int lecture,LocalDate date)
    {
        lastLecture = lecture;
        lastActivityDate = date;
    }

    @Override
    public int compareTo(CourseEngagement o)
    {
        return Integer.valueOf(getMonthsSinceActive()).compareTo(o.getMonthsSinceActive()); // Simpler Solution Using Integer.compare(int v1,int v2);
    }

    @Override
    public String toString()
    {
        return "Code : "+getCourseCode()+"\n Enrollment Date : " + getEnrollmentYear() +"\n Last Lecture Number : " +lastLecture + "\n Last Activiy Date : " + lastActivityDate;
    }

//    @Override
//    public String toString()
//    {
//        return courseCode +
//    }


}
