package Adhikary.X;


import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

record Person(String firstName, String lastName, int age)
{
	private static final String[] firsts =
			{
					"Able","Bob","Charlie","Donna","Eve","Fred"
			};

	private static final String[] lasts =
			{"Norton","OHara","Peterson","Quincy","Richardson","Smith"};

	private static final Random random = new Random();

	public Person()
	{
		this(firsts[random.nextInt(firsts.length)],
				lasts[random.nextInt(lasts.length)],
				random.nextInt(18,100));

	}

	@Override
	public String toString()
	{
		return "%s, %s (%d)".formatted(lastName, firstName, age);
	}

}
public class Main
{
	public static void main(String... args)
	{
		Stream.generate(()->new Person()) // Alternate option : new::Person
				.limit(10)
				.sorted(Comparator.comparing((e)->{

					return e.lastName();
				}))
				.forEach(System.out::println);





	}




}
