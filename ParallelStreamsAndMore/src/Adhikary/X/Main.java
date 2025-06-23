package Adhikary.X;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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


		Person[] persons = Stream.generate(Person::new)
				.limit(10)
				.sorted(Comparator.comparing((e)->e.lastName()))
				.toArray(Person[]::new);
		for(Person person : persons)
		{
			System.out.println(person);
		}
		System.out.println("-".repeat(50));


		Arrays.stream(persons)
				.limit(10)
				.parallel()
//				.sorted(Comparator.comparing((e)->{
//
//					return e.lastName();
//				}))
				.forEach(System.out::println);

		System.out.println("-".repeat(50));

		int sum = IntStream.range(1,101)
				.parallel()
				.reduce(0,(a,b)->Integer.sum(a,b));
		System.out.println("The sum of the number is:  " + sum);

		System.out.println("-".repeat(50));

		String humptyDumpty = """
				Humpty Dumpty sat on a wall.
				Humpty Dumpty had a great fall.
				All the king's horses and all the king's men
				couldn't put humpty together again. 
				""";
		System.out.println("-".repeat(50));

		List<String> words = new Scanner(humptyDumpty).tokens()
				.collect(()->new ArrayList<>(),(ArrayList<String> e1, String e2)->
				{
					e1.add(e2);
				},(e3,e4)-> {
					e3.addAll(e4);
				});
		words.forEach(System.out::println);
		System.out.println("-".repeat(50));

		String backToTogetherAgain =
				words.parallelStream()
//						.reduce(new StringJoiner(" "),
//								(sj,s)->
//								{
//								return	sj.add(s);
//								},
//								(sj1,sj2)->
//								{
//							return sj1.merge(sj2);
//								});

//		.collect(Collectors.joining(" "));

		.reduce("",(s1,s2)->s1.concat(s2).concat(" "));
		System.out.println(backToTogetherAgain);



		System.out.println("-".repeat(50));

		Map<String, Long> lastNameCounts = Stream.generate(()-> new Person())
				.limit(10000)
				.parallel()
				.collect(Collectors.groupingBy((person)->person.lastName(),
						Collectors.counting()));

		lastNameCounts.entrySet().forEach(System.out::println);

		System.out.println("-".repeat(50));

		lastNameCounts.forEach((k,v)->{
			System.out.println(k + " : " + v);
		});

		int total = 0;

		for(long val : lastNameCounts.values())
		{
			total += val;
		}

		System.out.println("Total: " + total);



	}




}
