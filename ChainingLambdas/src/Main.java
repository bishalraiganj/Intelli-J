import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {


    public static void main(String... args)
    {

     String tim = "Tim";
        Function<String,String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(tim));
        Function<String,String>  lastname = (s)->s.concat(" Adhikary");
        Function<String, String> uCaseLastname = uCase.andThen(lastname);
        System.out.println(uCaseLastname.apply(tim));
        uCaseLastname = uCase.compose(lastname);
        System.out.println(uCaseLastname.apply(tim));
        Function<String,String[]> f0 = uCase.
                andThen((s)->s.concat(" Adhikary")).
                andThen((s)->s.split(" "));
        System.out.println(Arrays.toString(f0.apply(tim)));

        Function<String,String> f1 = uCase.
                andThen((s)->s.concat(" Adhikary")).
                andThen((s)->s.split(" ")).
                andThen((s)->s[1].toUpperCase() + ", " +s[0]) ;
        System.out.println(f1.apply(tim));

        Function<String,Integer> f2 = uCase.
                andThen((s)->s.concat(" Adhikary")).
                andThen((s)->s.split(" ")).
                andThen((s)->String.join(",",s)).
                andThen(String::length);
        System.out.println(f2.apply(tim));

        String[] names = {"Bishal","Suparna","Subhankar","Dhrup","Rudra","Avi","Deep","Joy","Khushi"};
        Consumer<String> s0 = (s)->System.out.print(s.charAt(0)+"");
        Arrays.asList(names).forEach(s0.
                andThen((s)->System.out.print("-")).
                andThen(System.out::println));

        Predicate<String> p1 = (s)->s.equals("TIM");
        Predicate<String> p2 = (s)->s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = (s)->s.startsWith("T");
        Predicate<String> p4 = (s)->s.endsWith("e");

        Predicate<String> combined1 = p1.or(p2);

        System.out.println("Combined1 "+combined1.test(tim));

        Predicate<String> combined2 = p3.and(p4);

        System.out.println("Combined2 "+combined2.test(tim));

        Predicate<String> combined3 = p3.and(p4).negate();

        System.out.println("Combined3 "+combined3.test(tim));

         record Person(String firstName,String lastName)
         {}

       List<Person> list = new ArrayList<>(Arrays.asList(new Person("Peter","Pan"),
                                                         new Person("Peter","PumpkinEater"),
                                                         new Person("Minnie","Mouse"),
                                                         new Person("Mickey","Mouse")

       ));

      list.sort((o1,o2)->o1.lastName.compareTo(o2.lastName));
      list.forEach(System.out::println);

      System.out.println("-".repeat(28));

      list.sort(Comparator.comparing(Person::lastName));

      list.forEach(System.out::println);

        System.out.println("-".repeat(28));

        list.sort(Comparator.comparing(Person::lastName)
                        .thenComparing(Person::firstName));

        list.forEach(System.out::println);

        System.out.println("-".repeat(28));

        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
                        .reversed());






        list.forEach(System.out::println);

















    }
}
