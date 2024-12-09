package Adhikary.X;

import java.util.Arrays;

record Person(String name,String dob,Person[] kids){

    @Override
    public String toString()
    {
        return "Person{ " +
                "name = ' "+name + '\'' +
                ", kids=" + Arrays.toString(kids)+
                        '}';
    }
}

public class Main {

    public static void main(String... args)
    {
        Person joe = new Person("Joe","01/01/1961",null);
        Person jim = new Person("Jim","02/02/1962",null);
        Person jack = new Person("Jack" , "03/03/1963",new Person[] {joe,jim});
        Person jane = new Person("Jane","04/04/1964",null);
        Person jill = new Person("jill","05/05/1965",new Person[] {joe,jim});

        Person[] persons = {joe,jim,jack,jane,jill};
//        Person[] personsCopy = Arrays.copyOf(persons,persons.length);
        Person[] personsCopy = new Person[5];
        for(int i=0; i<persons.length;i++)
        {
            var current = persons[i];
            personsCopy[i] = new Person(current.name(),current.dob(),current.kids());
        }

        var jillsKids = personsCopy[4].kids();
        jillsKids[1] = jane;


        for (int i = 0;i<persons.length;i++ )
        {
            if(persons[i] == personsCopy[i])
            {
                System.out.println("Equal References " + persons[i]);
            }
        }


    }



}
