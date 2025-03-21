package Adhikary.X;

public class Student {

    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;


    public Student(long studentId,String countryCode,int yearEnrolled,int ageEnrolled,String gender,boolean programmingExperience)
    {
        this.studentId = studentId;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled =  ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;
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





}
