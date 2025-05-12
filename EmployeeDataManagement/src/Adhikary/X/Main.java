package Adhikary.X;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	private static Map<Integer,Long> employeeMap= new LinkedHashMap<>();

	public static void main(String... args)
	{
		loadIndex("employees.dat",employeeMap);
		employeeMap.entrySet()
				.stream()
				.map(e->e.getKey())
				.collect(()->new ArrayList<>(),(ArrayList<Integer> e1,Integer e2)->e1.add(e2)
						,(e3,e4)->e3.addAll(e4))
				.forEach(System.out::println);

		System.out.println("record 730 \n\n" + fetchEmployee(21,employeeMap,"employees"));




	}

	private static void loadIndex(String indexPath, Map<Integer, Long> employeeMap)
	{
		int i = 0;
		try(RandomAccessFile ra = new RandomAccessFile(indexPath,"r"))
		{
			int recordSize = ra.readInt();
			System.out.println("Number of employees: " + recordSize);
			while(i<recordSize)
			{
				int id = ra.readInt();
				long offset = ra.readLong();
				employeeMap.put(id,offset);
				i++;

			}


		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}




	}


	private static String fetchEmployee(int id, Map<Integer, Long> map, String datPath)
	{
		long offset =map.get(id);
		try(RandomAccessFile ra = new RandomAccessFile(datPath+".dat","r"))
		{
			ra.seek(offset);
			String record = ra.readUTF();
			System.out.println(record);
			return record;
//			System.out.println(record);


		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}



	}

}
