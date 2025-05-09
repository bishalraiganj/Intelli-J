package Adhikary.X;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String... args)
	{


		getFactCount(48);


	}

	private static int getFactCount(int n)
	{
		int prevFac = 0;
		int currFac = 0;

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
		return 0;
	}

}
