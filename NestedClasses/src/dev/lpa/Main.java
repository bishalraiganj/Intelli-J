package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.EmployeeComparator;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
    List<Employee> eList = new ArrayList<>(List.of(new Employee(10001, "Ralph", 2015), new Employee(10005, "Carole", 2021),
            new Employee(10022, "Jane", 2013)
            , new Employee(13151, "laura", 2020),
            new Employee(10050, "Jim", 2018)));
//    var comparator = new EmployeeComparator<>();
//
//    eList.sort(comparator);

eList.sort(new Employee.EmployeeComparator<>("Yearstarted").reversed());
    for (Employee e: eList)
    {
        System.out.println(e);
    }
    System.out.println("Store Members");
    List<StoreEmployee> storeEmployees= new  ArrayList<>(List.of(new StoreEmployee(10015,"Meg",2019,"Target"),new StoreEmployee(10515,"Joe",2021,"Walmart"),new StoreEmployee(10105,"Tom",2020,"Macys"),
            new StoreEmployee(10215,"Marty",2018,"Walmart"),new StoreEmployee(10322,"Bud",2016,"Target")));

//var genericEmployee = new StoreEmployee();
storeEmployees.sort(new StoreEmployee().new storeComparator<>());
for(StoreEmployee e:storeEmployees)
{
 
    System.out.println(e);
}



}


}
