package Adhikary.X;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static final Map<Long,Long> indexedIds = new LinkedHashMap<>();
	private static int recordsInFile = 0;
	public static void main(String... args)
	{

//		BuildStudentData.build("studentData");

		try(RandomAccessFile ra = new RandomAccessFile("studentData.dat","r"))
		{

			loadIndex(ra,0);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a student Id or 0 to quit");
			while(sc.hasNext())
			{
				long studentId = Long.parseLong(sc.nextLine());
				if(studentId <  1)
				{
					break;
				}
				ra.seek(indexedIds.get(studentId));
				String targetRecord = ra.readUTF();
				System.out.println(targetRecord);
				System.out.println("Enter another student Id or 0 to quit");


			}

		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}



	}

	private static void loadIndex(RandomAccessFile ra, int indexPosition)
	{
		try {
			ra.seek(indexPosition);
			recordsInFile = ra.readInt();
			System.out.println(recordsInFile);
			for (int i = 0; i < recordsInFile; i++)
			{
				indexedIds.put(ra.readLong(),ra.readLong());
			}


		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}



	}


}
