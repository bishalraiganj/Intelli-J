package Adhikary.X;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String... args)
	{
		String emails = """
				john.boy@valid.com
				jane.doe-smith@valid.co.uk
				jane_Doe1976@valid.co.uk
				bob-1964@valid.net
				elaine@valid-test.com.au
				david@valid.io
				john.boy@invalid
				bob!@invalid.com
				elaineinvalid1983@.com
				david@invalid..com
				""";


//		String testString  = """
//				match1-sdsf.sff
//				.noMatch/
//				.no3match.
//				match-match.m-m
//				no..Match
//				matchmatch
//				""";

		Pattern emailPattern = Pattern.compile("(^[0-9a-zA-Z]+([._-]([0-9a-zA-Z])+)*)@([0-9a-zA-Z]+([-._][0-9a-zA-Z]+)*(\\.[a-zA-Z0-9]+)+$)");
		Pattern emailPatternForMultilineInput = Pattern.compile("([0-9a-zA-Z]+([._-]([0-9a-zA-Z])+)*)@([0-9a-zA-Z]+([-._][0-9a-zA-Z]+)*(\\.[a-zA-Z0-9]+)+)");
		Matcher m = emailPatternForMultilineInput.matcher(emails);

//		System.out.println(Pattern.matches("(^[0-9a-zA-Z]+([._-]([0-9a-zA-Z])+)*)@([0-9a-zA-Z]+([-._][0-9a-zA-Z]+)*(\\.[a-zA-Z0-9]+)+$)","john.boy@valid.com"));


//		System.out.println(m.find());
		m.results()
				.forEach((mr)->System.out.println(mr.group(0)));




		System.out.println("-".repeat(50));
		emails.lines()
//				.peek((e)->System.out.println(e+ "\n"+ "-".repeat(50)))
				.map((e)->{
					if(Pattern.matches(emailPattern.pattern(),e))
						return e;
					return"";

				})
				.forEach((e)->System.out.println(e));



		System.out.println("-".repeat(50));

		m.reset();
		while(m.find())
		{
			System.out.println("Valid Match: " + m.group(0)
		                      +"\n"+"Username: " + m.group(1)
					          +"\n"+"Domain: " + m.group(4));
		}

	}

}
