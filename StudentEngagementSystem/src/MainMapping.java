import java.util.*;
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
                    .collect(()->new TreeMap<String,Student>(),(TreeMap<String,Student> e1,Student e2)->e1.put(String.valueOf(e2.getStudentId()),e2),(e3,e4)->e3.putAll(e4));



        }

}
