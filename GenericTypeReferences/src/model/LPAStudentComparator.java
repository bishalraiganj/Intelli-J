package model;

import java.util.Comparator;

public class LPAStudentComparator implements Comparator<Student> {


    public int compare(Student o1,Student o2)
    {
        return Integer.valueOf(o1.getStudentId()).compareTo(o2.getStudentId());

    }


}
