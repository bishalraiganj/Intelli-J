import java.util.*;
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


        double totalPercent = students1.stream()
                .mapToDouble((e)->e.getPercentComplete("JMC"))
                .reduce(0,Double::sum);
        double avePercent  = totalPercent/ students1.size();
        System.out.printf("Average Percentage Complete = %.2f%% %n",avePercent);

        int topPercent = (int) (1.25*avePercent);
        System.out.printf("Best Percentage Complete = %d%% %n",topPercent);

        Comparator<Student> longTermStudent = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorkers= students1.stream()
            .filter((e)->e.getMonthsSinceActive("JMC")==0)
            .filter((e)->e.getPercentComplete("JMC")>=topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .map((e)->{
                    e.addCourse(jgms);
                    return e;
                })
                .peek((e)->System.out.println(e))
                .collect(()->new ArrayList<>(),(e1,e2)->e1.add(e2),ArrayList::addAll);

        System.out.println("hardWorkers :" + hardWorkers.size());

        System.out.println("-".repeat(50));


        students1.stream()
                .filter((e)->e.getMonthsSinceActive("JMC")==0)
                .filter((e)->e.getPercentComplete("JMC")>=topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)->e1.add(e2),ArrayList::addAll)
                .forEach((Student e)->{
                    e.addCourse(jgms);
                    System.out.print(e.getStudentId()+" ");
                });

        System.out.println("\n"+"-".repeat(50));

        Comparator<Student> uniqueSorted = longTermStudent.thenComparing(Student::getStudentId);
        students1.stream()
                .filter((e)->e.getMonthsSinceActive("JMC")==0)
                .filter((e)->e.getPercentComplete("JMC")>=topPercent)
                .sorted(longTermStudent)
                .limit(10)
//                .peek(System.out::println)
//                .collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)->e1.add(e2),ArrayList::addAll)
                .collect(()->new TreeSet<>(uniqueSorted),(TreeSet<Student> e1,Student e2)->e1.add(e2),TreeSet::addAll)
                .forEach((Student e)->{
                    e.addCourse(jgms);
                    System.out.print(e.getStudentId()+" ");
                });













    }

}
