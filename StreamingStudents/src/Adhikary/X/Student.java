package Adhikary.X;

import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Student {

    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;
    private final Map<String,CourseEngagement> engagementMap;


    public Student(long studentId,String countryCode,int yearEnrolled,int ageEnrolled,String gender,boolean programmingExperience,Map<String,CourseEngagement> engagementMap)
    {
        this.studentId = studentId;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled =  ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;
        this.engagementMap =new TreeMap<>(Comparator.comparing((e)->engagementMap.get(e)));
//        this.engagementMap = new TreeMap<>(Comparator.comparing(CourseEngagement::engagementMap.get(e)))
        this.engagementMap.putAll(engagementMap);
    }

    public long getStudentId()
    {
        return studentId;
    }
    public String getCountryCode()
    {
        return countryCode;
    }
    public int getYearEnrolled()
    {
        return yearEnrolled;
    }
    public int ageEnrolled()
    {
        return ageEnrolled;
    }
    public String getGender()
    {
        return gender;
    }
    public boolean getProgrammingExperience()
    {
        return programmingExperience;
    }

    public Map<String,CourseEngagement> getEngagementMap()
    {
        return engagementMap;
    }


    public int  getAge()
    {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.getYear()-yearEnrolled)+ageEnrolled;
    }

    public int getYearsSinceEnrolled()
    {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.getYear()-yearEnrolled);
    }

    public int getMonthsSinceActive(String courseCode)
    {
      return  engagementMap.get(courseCode).getMonthsSinceActive();
    }

    public double getPercentComplete(String courseCode)
    {
        return engagementMap.get(courseCode).getPercentComplete();
    }

    public int getMonthsSinceActive()
    {
       return new LinkedHashMap<>(engagementMap).firstEntry().getValue().getMonthsSinceActive();
    }






}
