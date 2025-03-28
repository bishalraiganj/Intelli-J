import java.util.stream.Stream;

public class Main {

    public static void main(String... args)
    {

        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");
//        Student bishal = new Student("IN ",2018,22,"M",true,jmc,pymc);
//
//        System.out.println(bishal);

//        bishal.watchLecture("JMC",10,5,2019);
//        bishal.watchLecture("PYMC",7,7,2020);
//        System.out.println(bishal);

        Stream.generate(()->Student.getRandomStudent(jmc,pymc))
                .limit(10)
                .forEach(System.out::println);

    }


}
