import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class MainOptional {

    public static void main(String... args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .collect(() -> new ArrayList<>(), (ArrayList<Student> e1, Student e2) -> e1.add(e2), (e3, e4) -> e3.addAll(e4));

        Optional<Student> o1 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty = " + o1.isEmpty() + ", Present = " + o1.isPresent());
        System.out.println(o1);
//        System.out.println(o1.get());
//        o1.ifPresent(System.out::println);
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("---> Empty"));
        System.out.println("-".repeat(50));


        Optional<Student> o2 = getStudent(students, "first");
        System.out.println("Empty = " + o2.isEmpty() + ", Present = " + o2.isPresent());
        System.out.println(o2);
        o2.ifPresent(System.out::println);

        Student firstStudent = (o2.orElseGet(()->getDummyStudent(jmc)));
        long id = (firstStudent == null ? -1 : firstStudent.getStudentId());
        System.out.println("firstStudent's id is " + id);

        System.out.println("-".repeat(50));

        List<String> countryList = new ArrayList<>();
        List<String> countries =  students.stream()
                        .map(Student::getCountryCode)
                                .filter((e)->{
                                    if(!countryList.contains(e))
                                    {
                                        return true;
                                    }
                                    return false;
                                })
                                        .collect(()->new ArrayList<>(),(ArrayList<String> e1, String e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));

        Optional.of(countries)
                .map((e)->String.join(",",e))
                .filter((e)->e.contains("FR"))
                .ifPresentOrElse(System.out::println,()->System.out.println("Missing FR"));

        System.out.println("-".repeat(50));


    }

    private static Optional<Student> getStudent(List<Student> list, String type) {

        if (list == null || list.size() == 0) {
            return Optional.empty();
        } else if (type.equals("first")) {
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")) {
            return Optional.ofNullable(list.get(list.size() - 1));
        } else
            return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
    }

    public static Student getDummyStudent(Course... courses)
    {
        System.out.println("Getting the dummy student");
        return new Student("NO",1,1,"U",false,courses);
    }



}
