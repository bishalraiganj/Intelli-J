import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MainTerminalOptional {

    public static void main(String... args)
    {
        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");

        List<Student> students = Stream.generate(()->Student.getRandomStudent(jmc,pymc))
                .limit(1000)
                .collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));


        int minAge =18;
        students.stream()
                .filter((e)->e.getAge()<=minAge)
                .findAny()
                .ifPresentOrElse((e)->System.out.printf("Student %d from %s is %d%n",e.getStudentId(),e.getCountryCode(),e.getAge()),()->System.out.println("Didn't find anyone under "+ minAge));

        students.stream()
                .filter((e)->e.getAge()<=minAge)
                .findFirst()
                .ifPresentOrElse((e)->System.out.printf("Student %d from %s is %d%n",e.getStudentId(),e.getCountryCode(),e.getAge()),()->System.out.println("Didn't find anyone under "+ minAge));

        System.out.println("-".repeat(50));

        students.stream()
                .filter((e)->e.getAge()<=minAge)
//                .sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
//                .limit(100)
//                .forEach((e)->System.out.printf("Student ID = %d , age = %d \n",e.getStudentId(),e.getAge()));
//                .count();
//                .findFirst()
                .min((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
                .ifPresentOrElse((e)->System.out.printf("Student %d from %s is %d%n",e.getStudentId(),e.getCountryCode(),e.getAge()),()->System.out.println("Didn't find anyone under "+ minAge));

        System.out.println("-".repeat(50));

        students.stream()
                .filter((e)->e.getAge()<=minAge)
//                .sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
//                .limit(100)
//                .forEach((e)->System.out.printf("Student ID = %d , age = %d \n",e.getStudentId(),e.getAge()));
//                .count();
//                .findFirst()
                .max((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
                .ifPresentOrElse((e)->System.out.printf("Student %d from %s is %d%n",e.getStudentId(),e.getCountryCode(),e.getAge()),()->System.out.println("Didn't find anyone under "+ minAge));




        int total =students.stream()
                .filter((e)->e.getAge()<=minAge)
                .mapToInt((e)->e.getAge()) // the lambda expression can be replaced with the method reference Student::getAge
                .reduce(0,Integer::sum);

        System.out.println("Total is " + total + "Average is " );

        System.out.println("-".repeat(50));

        students.stream()
                .filter((e)->e.getAge()<=minAge)
                .mapToInt(Student::getAge)
                .average()
                .ifPresentOrElse((e)->System.out.printf("Avg age under 21: %.2f%n",e),()->System.out.println("Didn't find anyone under "+ minAge));
        System.out.println("-".repeat(50));


        System.out.println("This is the list of the unique country codes of the students less than equal to minAge");
        List<String> filterTest = new ArrayList<>();
        students.stream()
                .filter((e)->e.getAge()<=minAge)
                .map((e)->e.getCountryCode())
                .filter((e)->{
                    if(filterTest.indexOf(e)<0)
                    {
                        filterTest.add(e);
                        return true;
                    }
                    return false;
                })
                .sorted()
//                .reduce(String::concat)
                .reduce((e1,e2)->e1+","+e2)
                .ifPresentOrElse(System.out::println,()->System.out.println("None Found"));

        System.out.println("-".repeat(50));

        System.out.println("Student from Specified Country and under minAge will be printed below in the console" );
        List<String> countryList = new ArrayList<>();


        students.stream()
                .filter((e)->e.getAge()<=minAge)
                .map(Student::getCountryCode)
                .filter((e)->{
                    if(!countryList.contains(e))
                    {
                        countryList.add(e);
                        return true;
                    }
                    return false;
                })
//                .peek(System.out::println)
//
        .reduce((e1,e2)->e1+"," +e2)
//                .map((e)->String.join(",",e))
                .filter((e)->e.contains("AU"))
                .ifPresentOrElse(System.out::println,()->System.out.println("Missing AU"));

        System.out.println("-".repeat(50));

        List<String> filterList2 = new ArrayList<>();
        students.stream()
//                .filter((e)->e.getAge())
                .map(Student::getCountryCode)
                .filter((e)->{
                    if(filterList2.indexOf(e)<0)
                    {
                        filterList2.add(e);
                        return true;
                    }
                    return false;
                })
//                .distinct()
                        .map((e)->e+",")
//                .peek(System.out::println)
                .forEach(System.out::println);

        System.out.println("-".repeat(50));


        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .map((l)->String.join(",",l))
                .filter((l)->l.contains("AU"))
                .findAny()
                .ifPresentOrElse(System.out::println,()->System.out.println("Missing AU"));




    }
}
