package model;

import model.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem {

    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();
    private static String[] firstNames = { "Bishal","Suparna","Ann","Bill","Cathy","John","Tim"};
    private static String[] courses = { "C++","Java","Python","GoLang","Rust","Ruby"};
    public Student()
    {
        int lastNameIndex = random.nextInt(65,91);
        name = firstNames[random.nextInt(7)]+" "+(char) lastNameIndex;
        course = courses[random.nextInt(6)];
        yearStarted = random.nextInt(2018,2025);


    }
    public String getName()
    {
        return name;
    }
    public String getCourse()
    {
        return course;
    }
    public int getYearStarted()
    {
        return yearStarted;
    }
    @Override
    public String toString()
    {
        return "%-15s %-15s %d".formatted(name,course,yearStarted);

    }
    public boolean matchFieldValue(String fieldName,String fieldValue)
    {  String fName=fieldName.toUpperCase();
       return switch(fName){
           case "NAME" -> name.equalsIgnoreCase(fieldValue);
           case "COURSE" -> course.equalsIgnoreCase(fieldValue);
           case "YEARSTARTED" -> yearStarted==Integer.parseInt(fieldValue);
           default ->false;
       };




    }
}
