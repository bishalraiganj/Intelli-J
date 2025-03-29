import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {

    public static void main(String... args)
    {

        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");

        List<Student> students = Stream.generate(()->Student.getRandomStudent())
                .limit(1000)
                .toList();

        Set<Student> australianStudents = students.stream()
                .filter((e)->e.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());
        System.out.println("# of Australian Students = " + australianStudents.size());

        Set<Student> underThirty = students.stream()
                .filter((e)->e.getAge()<30)
                .collect(Collectors.toSet());
        System.out.println("# of Under Thirty Students = " + underThirty.size());

        Set<Student> youngAussies1 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngAussies1.addAll(australianStudents);
        youngAussies1.retainAll(underThirty);
        youngAussies1.forEach((s)->System.out.print(s.getStudentId()+" "));
        System.out.println("\n"+"-".repeat(50));

       /* Set<Student> youngAussies2 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngAussies2.addAll(students.stream()
                .filter((e)->e.getCountryCode().equals("AU")&&e.getAge()<30)
                .collect(Collectors.toSet()));
        youngAussies2.forEach((s)->System.out.print(s.getStudentId()+" "));
        System.out.println("\n"+"-".repeat(50));*/

        Set<Student> youngAussies2 = students.stream()
                .filter((e)->e.getAge()<30&&e.getCountryCode().equals("AU"))
                .collect(()->new TreeSet<>(Comparator.comparing(Student::getStudentId)),TreeSet::add,TreeSet::addAll);
        youngAussies2.forEach((s)->System.out.print(s.getStudentId()+" "));
        System.out.println("\n"+"-".repeat(50));




    }
}
