package Adhikary.X;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {


	private static final Map<Integer,Long> indexedIds = new LinkedHashMap<>();
	static
	{
		int recordsInFile = 0;
		try(RandomAccessFile ra = new RandomAccessFile("employees.dat","r"))
		{
			recordsInFile = ra.readInt();
			System.out.println(recordsInFile + " records in file");
			for(int i = 0 ; i < recordsInFile ; i++)
			{
				indexedIds.put(ra.readInt(),ra.readLong());
			}


		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public static void main(String... args)
	{







	}


}
