import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

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








    }
}
