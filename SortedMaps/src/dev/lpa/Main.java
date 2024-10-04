package dev.lpa;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {

    private static Map<String,Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String,Student> students = new TreeMap<>();




    public static void main(String[] args)
    {





    }

    public static void addPurchase(String name,Course course,Double price)
    {
        Student existingStudent = students.get(name);
        if(existingStudent==null)
        {
            existingStudent = new Student(name,course);
            students.put(name,existingStudent);
        }
        else
        {
            existingStudent.addCourse(course);
        }

        int day = purchases.size()+1;
        String key = course.courseId()+"_"+existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(),existingStudent.getId(),price,year,day);
        purchases.put(key,purchase);



    }


}
