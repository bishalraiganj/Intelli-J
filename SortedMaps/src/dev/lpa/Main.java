package dev.lpa;

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


    }


}
