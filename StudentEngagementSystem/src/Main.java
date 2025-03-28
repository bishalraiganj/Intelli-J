import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static int index =0;
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



        System.out.println("-".repeat(50));


        Student[] studentsArr = new Student[1000];





                Stream.generate(()->Student.getRandomStudent(jmc,pymc))
                .limit(1000)
                .forEach((e)-> {
                    studentsArr[index] = e;
                    index++;
                });


                long maleStudentsCount =Arrays.stream(studentsArr)
                        .filter((e)->e.getGender().equals("M"))
                        .count();

                System.out.println("Male Students Count:" + maleStudentsCount);

                long femaleStudentsCount = Arrays.stream(studentsArr)
                        .filter((e)->e.getGender().equals("F"))
                        .count();
                System.out.println("Female Students Count: " +femaleStudentsCount);

                long uStudentsCount = Arrays.stream(studentsArr)
                        .filter((e)->e.getGender()=="U")
                        .count();
                System.out.println("U students Count:"+uStudentsCount);

                long range30 = Arrays.stream(studentsArr)
                        .filter((e)->e.getAge()<30)
                        .count();
                System.out.println("Range less than 30  : " +range30);

                long range30and60 = Arrays.stream(studentsArr)
                        .filter((e)->e.getAge()<=60&&e.getAge()>=30)
                        .count();
                System.out.println("Range greater thean 30 and less than 60: "+range30and60);

                long range60 = Arrays.stream(studentsArr)
                        .filter((e)->e.getAge()>60)
                        .count();
                System.out.println("Range greater than 60 :"+range60);

                /*System.out.println(
                        Arrays.toString(studentsArr));*/

//        Arrays.stream(studentsArr)
//                .
//

    }


}
