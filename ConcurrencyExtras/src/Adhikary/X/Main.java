package Adhikary.X;


import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

record Student(String name, int enrolledYear, int studentId) implements Comparable<Student>
{
	@Override
	public int compareTo(Student o)
	{
		return this.studentId - o.studentId;
	}

}


class StudentId {
	private int id = 0;

	public int getId()
	{
		return id ;

	}

	public int getNextId()
	{
		return ++id;
	}




}
public class Main {


	private static Random random = new Random();

	private static ConcurrentSkipListSet<Student> studentSet = new ConcurrentSkipListSet<>();
	public static void main(String... args)
	{

		StudentId idGenerator = new StudentId();
		Callable<Student> studentMaker = ()-> {

			int studentId = idGenerator.getNextId();
			Student student = new Student("Tim" + studentId , random.nextInt(2018,2025),studentId);
			studentSet.add(student);
			return student;

		};

		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0 ; i < 10 ; i++) {
			studentSet.clear();
			try {
				List<Future<Student>> futures = executor.invokeAll(Collections.nCopies(10, studentMaker));
				System.out.println("# of students = " + studentSet.size());
//				studentSet.forEach((student) -> {
//					System.out.println(student);
//				});
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}


		}
		executor.shutdown();





	}



}
