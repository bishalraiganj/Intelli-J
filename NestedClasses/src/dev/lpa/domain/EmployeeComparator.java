package dev.lpa.domain;

import java.util.Comparator;

public class EmployeeComparator<T extends Employee> implements Comparator<T> {

    public int compare( T o1,T o2)
    {
     return o1.getName().compareTo(o2.getName());
//        return o1.yearStarted()-o1.yearStarted();

    }
}
