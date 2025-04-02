import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFinalChallenge {

    public static void main(String... args)
    {
        Course pymc = new Course("PYMC","Python Masterclass",50);
        Course jmc = new Course("JMC","Java Masterclass",100);
        Course jgames= new Course("JGMS","Creating Games in Java");

        int currentYear = LocalDate.now().getYear();

        List<Student> students = Stream.generate(()->Student.getRandomStudent(jmc,pymc,jgames))
                .filter((e)->currentYear-e.getYearEnrolled()<=4)
                .limit(10000)
                .collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));

        System.out.println(students.stream().mapToInt(Student::getYearEnrolled).summaryStatistics());

        students.subList(0,10).forEach((e)->System.out.println(e));

        System.out.println(students.stream().mapToInt((e)->e.getEngagementMap().size()).summaryStatistics());


         Set<CourseEngagement> mappedActivity = students.stream()
                .flatMap((e)->e.getEngagementMap().values().stream())
                 .collect(()->new HashSet<>(),(HashSet<CourseEngagement> e1,CourseEngagement e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));

         Map<String,Long> mappedActivityCount= mappedActivity.stream()
                 .collect(Collectors.groupingBy((e)->e.getCourse(),Collectors.counting()));

         mappedActivityCount.forEach((k,v)->System.out.println(k + " " + v));

        Map<Integer,Long> classCounts= students.stream()
                .collect(Collectors.groupingBy((e)->e.getEngagementMap().size(),Collectors.counting()));

        classCounts.forEach((k,v)->System.out.println(k + " " + v));

        System.out.println("-".repeat(50));

        Map<String,DoubleSummaryStatistics>  percentages = students.stream()
                .flatMap((e)->e.getEngagementMap().values().stream())
                .collect((Collectors.groupingBy((e)->e.getCourse(),Collectors.summarizingDouble((e)->e.getPercentComplete()))));
//                .mapToDouble((e)->e.getPercentComplete())
                percentages.forEach((k,v)-> System.out.println(k + " " + v));










    }

}
