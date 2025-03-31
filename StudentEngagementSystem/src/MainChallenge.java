import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String... args)
    {
        Course pymc = new Course("PYMC","Python Masterclass",50);
        Course jmc = new Course("JMC","Java Masterclass",100);
        Course jgms= new Course("JGMS","Creating Games in Java");

        List<Student> studentsList = Stream.generate(()->Student.getRandomStudent(jmc,pymc))
                .limit(5000)
                .collect(()->new ArrayList<>(),(List<Student> e1,Student e2)->e1.add(e2),(List<Student> e3,List<Student> e4)->e3.addAll(e4));


        double  average = studentsList.stream()
                .map((e)->(double)e.getPercentComplete("JMC"))
                .reduce((double) 0,Double::sum);
        System.out.println(average/5000);

        List<Student> longestStudents = studentsList.stream()
                .filter((e)->(e.getMonthsSinceActive()<12))
                .sorted(Comparator.comparing(Student::getYearsSinceEnrolled).reversed())
                .limit(10)
                .map((e)->{
                    e.addCourse(jgms);
                    return e;
                })
                .collect(()->new ArrayList<>(),(e1,e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));

        longestStudents.forEach(System.out::println);
        System.out.println("\n"+"-".repeat(50));



        List<Student> students =  Stream.iterate(1,(e)->e<=5000,(e)->e+1)
                .map((e)->Student.getRandomStudent(jmc,pymc))
                .collect(()->new ArrayList<>(),(e1,e2)->e1.add(e2),ArrayList::addAll);

        List<Student> students1 = IntStream.rangeClosed(1,5000)
                .mapToObj((e)->Student.getRandomStudent(jmc,pymc))
                .collect(ArrayList::new,ArrayList::add,(e1,e2)->e1.addAll(e2));













    }

}
