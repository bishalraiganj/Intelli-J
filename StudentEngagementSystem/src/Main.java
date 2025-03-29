import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
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
//                    System.out.println(e);
                });

                System.out.println("-".repeat(50));



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



                IntSummaryStatistics ageStatistics = Arrays.stream(studentsArr)
                        .mapToInt(Student::getAge)
                        .summaryStatistics();
                System.out.println("Age Statistics : " +ageStatistics);


                List<String> countryCodes = new ArrayList<>();
                Arrays.stream(studentsArr)
                        .filter((e)->{
                            if(countryCodes.indexOf(e.getCountryCode())<0)
                            {
                                countryCodes.add(e.getCountryCode());
                                return true;
                            }
                            return false;
                        })
                        .forEach(System.out::println);
                System.out.println("CountryCodes List:" +countryCodes.toString());

                boolean conditions =Arrays.stream(studentsArr)
                        .anyMatch((e)->

                            e.getEngagementMap().values().stream().allMatch((f)->f.getLastActivityYear()== LocalDate.now().getYear())&&e.getYearsSinceEnrolled()>7
//                            for(CourseEngagement cE:e.getEngagementMap().values())
//                            {
//
//
//                            }

                          );
                System.out.println("Conditions Match Status:" +conditions);

                Stream<Student> conditionsMatchedStudents = Arrays.stream(studentsArr)
                        .filter((e)->e.getEngagementMap().values().stream().allMatch((f)->f.getLastActivityYear()==LocalDate.now().getYear())&&e.getYearsSinceEnrolled()>7)
                        .sorted(Comparator.comparing(Student::getAge).reversed())
                        .limit(5)        ;
//                        .filter((e)->e.getYearsSinceEnrolled()>new Random().nextInt(8,59));

                conditionsMatchedStudents.forEach(System.out::println);



                System.out.println("-".repeat(50));

//                var maleStudents = Stream.generate(()->Student.getRandomStudent(jmc,pymc))
//                        .limit(1000);
//                        maleStudents = maleStudents.filter((e)->e.getGender().equals("M"));
        
                Student[] students = new Student[1000];
                Arrays.setAll(students,(i)->Student.getRandomStudent(jmc,pymc));

                Stream<Student> maleStudents = Arrays.stream(students)
                                .filter((e)->e.getGender().equals("M"));
                System.out.println("# of Male Students: "+ maleStudents.count());

                System.out.println("-".repeat(50));

                for(String gender:List.of("M","F","U"))
                {
                    Stream<Student>  myStudents = Arrays.stream(students)
                            .filter((e)->e.getGender().equals(gender));
                    System.out.println("# of " + gender + "Students: "+myStudents.count());
                }

                System.out.println("-".repeat(50));

                List<Predicate<Student>> list = List.of((s)->s.getAge()<30,(Student s)->s.getAge()>=30&&s.getAge()<60);

//                for(Predicate<Student> predicate:list)
//                {
//                    Stream<Student> myStudents = Arrays.stream(students)
//                            .filter(predicate);
//                    System.out.println((predicate.test(new Student("IN",2024,9,"M",true,jmc,pymc))?"# of age<30: ":"# of age<60: ")+ myStudents.count());
//
//
//                } // This can also be used here the predicate is checked to determine the range being printed but the logic is complex

                long total=0;
                for(int i=0;i<list.size();i++)
                {
                    Stream<Student> myStudents = Arrays.stream(students)
                            .filter(list.get(i));
                    long cnt=myStudents.count();
                    total+=cnt;
                    System.out.printf("# of students (%s) = %d%n".formatted((i==0?" < 30":">=30 && < 60"),cnt));
                }

                System.out.println("# of students >= 60 = "+ (students.length-total));

                IntStream ageStream = Arrays.stream(students)
                        .mapToInt(Student::getAgeEnrolled);
                System.out.println(ageStream.summaryStatistics());

                IntStream currentAgeStream = Arrays.stream(studentsArr)
                        .mapToInt(Student::getAge);

                System.out.println(currentAgeStream.summaryStatistics());

                Arrays.stream(studentsArr)
                        .map(Student::getCountryCode)
                        .distinct()
                        .sorted()
                        .forEach((s)->System.out.print(s + " "));

                System.out.println("-".repeat(50));

                boolean longTerm = Arrays.stream(studentsArr)
                        .anyMatch((e)->e.getMonthsSinceActive()<12&&e.getAge()-e.getAgeEnrolled()>=7);
                System.out.println("LongTerm students? " + longTerm);

                long longTermCount = Arrays.stream(studentsArr)
                        .filter((e)->e.getAge()-e.getAgeEnrolled()>=7&&e.getMonthsSinceActive()<12)
                        .count();
                System.out.println("LongTerm students? " + longTermCount);

                Arrays.stream(studentsArr)
                        .filter((e)->e.getAge()-e.getAgeEnrolled()>=7&&e.getMonthsSinceActive()<12)
                        .filter((e)->!e.hasProgrammingExperience())
                        .limit(5)
                        .forEach(System.out::println);






                /*System.out.println(
                        Arrays.toString(studentsArr));*/

//        Arrays.stream(studentsArr)
//                .
//

    }


}
