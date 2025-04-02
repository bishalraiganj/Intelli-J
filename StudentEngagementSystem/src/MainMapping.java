import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainMapping {

        public static void main(String... args)
        {
            Course pymc = new Course("PYMC","Python Masterclass",50);
            Course jmc = new Course("JMC","Java Masterclass",100);
            Course jgames= new Course("JGMS","Creating Games in Java");


            List<Student> students = IntStream.rangeClosed(1,5000)
                    .mapToObj((e)->Student.getRandomStudent(jmc,pymc,jgames))
                    .collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));


            Map<String,Student> studentsMap = students.stream()
                    .limit(20)
                    .collect(()->new TreeMap<String,Student>(),(TreeMap<String,Student> e1,Student e2)->e1.put(String.valueOf(e2.getStudentId()),e2),(e3,e4)->e3.putAll(e4));
            studentsMap.forEach((k,v)->System.out.println(k+" " +v));

            System.out.println("-".repeat(50));


//            Map<String,Student> mappedStudents = students.stream()
//                    .collect


            Map<String,List<Student>> mappedStudents = students.stream()
                    .collect(Collectors.groupingBy((t)->t.getCountryCode()));
            mappedStudents.forEach((k,v)->System.out.println(k + " " + v.size()));

            System.out.println("-".repeat(50));
            int minAge = 25;
            Map<String,List<Student>> youngerSet = students.stream()
                    .collect(Collectors.groupingBy((Student t)->t.getCountryCode(),Collectors.filtering(( Student e)->e.getAge()<=minAge,Collectors.toList())));
            youngerSet.forEach((k,v)->System.out.println(k + " " + v.size()));

            System.out.println("-".repeat(50)+" \n Below we have the result of The Collectors.partitioningBy() %n");

            Map<Boolean,List<Student>> experienced =  students.stream()
                    .collect(Collectors.partitioningBy((Student t)->t.hasProgrammingExperience()));
            System.out.println("Experienced Students : " + experienced.get(true).size());


            Map<Boolean,Long> expCount = students.stream()
                    .collect(Collectors.partitioningBy((t)->t.hasProgrammingExperience(),Collectors.counting()));
            System.out.println("Experienced Students : "+ expCount.get(true));


            System.out.println("-".repeat(50));
            Map<Boolean,Long> experiencedAndActive = students.stream()
                    .collect(Collectors.partitioningBy((e)->e.getMonthsSinceActive()==0&& e.hasProgrammingExperience(),Collectors.counting()));
            System.out.println("Experienced and Active Students : " + experiencedAndActive.get(true));

            System.out.println("-".repeat(50)+"\n Returning a multi-level map of students keyed by country code then the students of this country by another map keyed by gender \n");

            Map<String,Map<String,List<Student>>> multiLevel = students.stream()
                    .collect(Collectors.groupingBy((t)->t.getCountryCode(),Collectors.groupingBy((t1)->t1.getGender())));
            multiLevel.forEach((k,v)->{
                System.out.println(k);
                v.forEach((k1,v1)-> System.out.println("\t" + k1 + " " + v1.size()));
            });






            long studentBodyCount =0;
            for (List<Student> list : experienced.values())
            {
                studentBodyCount += list.size();
            }
            System.out.println("studentBodyCount  = " + studentBodyCount);

            studentBodyCount = experienced.values().stream()
                    .mapToInt((l)->l.size())
                    .sum();
            System.out.println("studentBodyCount = "+ studentBodyCount);

            studentBodyCount = experienced.values().stream()
                    .map((l)->l.stream().filter((e)->e.getMonthsSinceActive()<=3).count())
                    .mapToLong((l)->l)
                    .sum();
            System.out.println("StudentBodyCount = " + studentBodyCount);

            System.out.println("-".repeat(50)+"\n Used the flatmap() method here \n");

            long count = experienced.values().stream()
                    .flatMap((l)->l.stream())
                    .filter((e)->e.getMonthsSinceActive()<=3)
                    .count();
            System.out.println("Active Students = " + count);

            count = multiLevel.values().stream()
                    .flatMap((m)->m.values().stream().flatMap((l)->l.stream()))
                    .filter((e)->e.getMonthsSinceActive()<=3)
                            .count();
            System.out.println(" Active Students (Used Multi-Level Map) = " +count);




        }

}
