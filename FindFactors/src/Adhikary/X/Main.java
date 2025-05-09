package Adhikary.X;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String... args)
	{


		System.out.println("Total number of factors : " + getFactCount(1024));


	}

	private static int getFactCount(int n)
	{
//		int prevFac = 0;
//		int currFac = 0;

		Map<Integer,Integer> factPairMap = new LinkedHashMap<>();

		for(int i = 2 ; i <= Math.sqrt(n) ; i++)
		{
			if(n%i == 0)
			{
				factPairMap.put(i,n/i);
			}
		}
		factPairMap.put(1,n);
		factPairMap.forEach((k,v)->System.out.println(k + " - " + v));


		boolean perfectSquareCheck = (n % Math.sqrt(n) == 0)? true : false;
		int numOfFac = (perfectSquareCheck) ? (factPairMap.size() * 2) - 1 : factPairMap.size() * 2;


		// Logging logic from here :-)

		factPairMap.entrySet()
				.stream()
				.forEach((entry)->logCalculation(entry));

		try(FileWriter fw = new FileWriter("calculationLog.txt", true))
		{
			fw.write(" Calculation Date :  " + LocalDateTime.now());

		} catch(IOException e)
		{
			System.out.println("Error Message: " + e.getMessage());
		}



		return numOfFac;

	}

	private static void logCalculation(Map.Entry<Integer,Integer> entry)
	{
		if(!Files.exists(Path.of("calculationLog.txt")))
		{
			try {
				Files.createFile(Path.of("calculationLog.txt"));
			} catch(IOException e)
			{
				System.out.println("Error Message : " + e.getMessage());
			}

		}

		try(FileWriter writer = new FileWriter("calculationLog.txt" , true))
		{
			writer.write(entry.getKey() + " - " + entry.getValue() + "\n");


		} catch(IOException e)
		{
			System.out.println("Error Message : " + e.getMessage());
		}


	}

}
