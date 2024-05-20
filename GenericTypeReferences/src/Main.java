import model.LPAStudent;
import model.Student;


import model.util.QueryItem;
import model.util.QueryList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class StudentComparator<T extends Student> implements Comparator<T>

{
    public int compare(T o1,T o2) {
        if (o1 instanceof Student s) {
            return Integer.valueOf(o1.getStudentId()).compareTo(Integer.valueOf((o2.getStudentId())));
        }

         LPAStudent s2= (LPAStudent) o2;
            return Double.valueOf(((LPAStudent)o1).getPercentComplete()).compareTo(Double.valueOf(s2.getPercentComplete()));

    }
}
record Employee(String name) implements QueryItem{
    public boolean matchFieldValue(String fieldName,String fieldValue)
    {
        return fieldName.equals(fieldValue);
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String... args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());

        }
        printMoreList(students);

        List<LPAStudent> LPAStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            LPAStudents.add(new LPAStudent());

        }
        printMoreList(LPAStudents);


        QueryList<LPAStudent> queryList1 = new QueryList<>(List.of(new LPAStudent()
                , new LPAStudent(), new LPAStudent(), new LPAStudent(), new LPAStudent(),
                new LPAStudent(), new LPAStudent(), new LPAStudent(),
                new LPAStudent(), new LPAStudent(), new LPAStudent(), new LPAStudent(),
                new LPAStudent(), new LPAStudent()));
//        System.out.println("\nThis is the ArrayList of Matches Found\n"+queryList1.getMatches("Course","Java"));
        System.out.println("This is the list of available students in the  QueryList you created above ");
        printMoreList(queryList1);
        var matches = queryList1.getMatches("course", "java");
        System.out.printf("Matches found in the List are the following %s \n", queryList1.returnQueryListType());
        printMoreList(matches);
//            var students2=QueryList.getMatches(new ArrayList<>(),"yearStarted","2021");
//        System.out.println(students2);

//        QueryList<Employee> employeeList=new QueryList<>();

        Student[] lStudents = {new Student(), new Student(), new Student(), new Student(), new Student(), new Student(), new Student()};
        Arrays.sort(lStudents, new StudentComparator<>());
        System.out.println(Arrays.toString(lStudents));
        LPAStudent[] lStudents2 = {new LPAStudent(), new LPAStudent(), new LPAStudent(), new LPAStudent(), new LPAStudent(), new LPAStudent(), new LPAStudent()};
        Arrays.sort(lStudents2, new StudentComparator<>());

        System.out.println(Arrays.toString(lStudents2));


    }
    //new
    public static void printMoreList(List<? extends Student> students)
    {
        for(var s:students)
        {
            System.out.println(s.getYearStarted()+": "+s);

        }
        System.out.println();
    }

//    public static <T extends Student >void printList(List<T> students)
//    {
//        for(var s:students)
//        {
//            System.out.println(s.getYearStarted()+": "+s);
//
//        }
//        System.out.println();
//    }

//        public static void testList(List<?> list)
//        {
//
//            for(var element:list) {
//                if (element instanceof String) {
//                    System.out.println("String: " + element.toUpperCase());
//                }
//            }
//
//        }

    public static <T > void testList(List<T> list)
    {

        for(var element:list)
        {   if(element instanceof Integer i){
            System.out.println("Integer: "+i.floatValue());
        }
        }
    }
}