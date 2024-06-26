package dev.lpa;

import dev.lpa.burger.Store;
import dev.lpa.domain.Employee;
import dev.lpa.domain.EmployeeComparator;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

public static void main(String[] args)
{

    List<Employee> eList = new ArrayList<>(List.of(new Employee(10001, "Ralph", 2015), new Employee(10005, "Carole", 2021),
            new Employee(10022, "Jane", 2013)
            , new Employee(13151, "laura", 2020),
            new Employee(10050, "Jim", 2018)));
    List<StoreEmployee> storeEmployees= new  ArrayList<>(List.of(new StoreEmployee(10015,"Meg",2019,"Target"),new StoreEmployee(10515,"Joe",2021,"Walmart"),new StoreEmployee(10105,"Tom",2020,"Macys"),
            new StoreEmployee(10215,"Marty",2018,"Walmart"),new StoreEmployee(10322,"Bud",2016,"Target")));

    var c0 = new EmployeeComparator<StoreEmployee>();
    var c1 = new Employee.EmployeeComparator();
    var c2 = new StoreEmployee().new StoreComparator<StoreEmployee> ();



    class NameSort<T> implements Comparator<StoreEmployee>
    {

        @Override
        public  int compare(StoreEmployee o1, StoreEmployee o2)
        {

            return o1.getName().compareToIgnoreCase(o2.getName());

        }



    }
    var c3 = new NameSort<StoreEmployee>();
    //using anonymous class
    var c4 = new Comparator<StoreEmployee> () {
        @Override
        public int compare(StoreEmployee o1,StoreEmployee o2)
        {

           return o1.getName().compareToIgnoreCase(o2.getName());

        }

    };

    sortIt(storeEmployees,c0);
    sortIt(storeEmployees,c1);
    sortIt(storeEmployees,c2);
    sortIt(storeEmployees,c3);
    sortIt(storeEmployees,c4);



}
public static <T> void sortIt(List<T> list, Comparator<? super T> comparator)
{

    System.out.println("Sorting with comparator: " + comparator.toString());
    list.sort(comparator);
    for(var employee : list)
    {
        System.out.println(employee);
    }

}


}
