package Adhikary.X;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Main {

	record Employee(int id, double salary,String firstName, String lastName)
	{

	}

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


		try(RandomAccessFile ra = new RandomAccessFile("employees.dat","rw"))
		{
			Scanner sc = new Scanner(System.in);
			List<Integer> ids = new ArrayList<>(indexedIds.keySet());
			Collections.sort(ids);
			while(true)
			{
				System.out.println(ids);
				System.out.println("Enter an Employee Id or 0 to quit");
				if(!sc.hasNext())
				{
					break;
				}
				int employeeId= Integer.parseInt(sc.nextLine());
				if(employeeId < 1)
				{
					break;
				}

				if(!ids.contains(employeeId))
				{
					continue;
				}
				Employee e = readRecord(ra,employeeId);
				System.out.println("Enter new salary, nothing if no change: ");
				try
				{
					double salary = Double.parseDouble(sc.nextLine());
					ra.seek(indexedIds.get(employeeId)+4);
					ra.writeDouble(salary);
					readRecord(ra,employeeId);

				}catch(NumberFormatException f)
				{ // if entered input is not a valid number, i'll ignore it.
					throw new RuntimeException(f);
				}
			}


		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}





	}

	private static Employee readRecord(RandomAccessFile ra, int employeeId) throws IOException
	{
		ra.seek(indexedIds.get(employeeId));
//		return new Employee(ra.readInt(),ra.readDouble(),ra.readUTF(),ra.readUTF());

		int id = ra.readInt();
		double salary = ra.readDouble();
		String firstName = ra.readUTF();
		String lastName = ra.readUTF();
		Employee e = new Employee(id,salary,firstName,lastName);
		System.out.println(e);
		return e;


	}


}
