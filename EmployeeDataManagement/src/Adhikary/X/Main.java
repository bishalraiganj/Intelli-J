package Adhikary.X;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.*;

public class Main {

	private static Map<Integer,Long> employeeMap= new LinkedHashMap<>();

	public static void main(String... args)
	{
		loadIndex("employees.dat",employeeMap);
		employeeMap.entrySet()
				.stream()
//				.map(e->e.getKey())
//				.collect(()->new ArrayList<>(),(ArrayList<Integer> e1,Integer e2)->e1.add(e2)
//						,(e3,e4)->e3.addAll(e4))
				.forEach(System.out::println);


//		long offset =  employeeMap.get(21);
//		try(RandomAccessFile ra = new RandomAccessFile("employees.dat","rw"))
//		{
//			ra.seek(offset);
//			ra.writeUTF("Testing Record/ Bishal Adhikary / Salary : 999999999999");
//		}catch(IOException e)
//		{
//			throw new RuntimeException(e);
//		}



//				populateRecords(employeeMap,"employees.dat");
				System.out.println(" \n\n" + fetchEmployee(730,employeeMap,"employees"));

				System.out.println("=".repeat(50));

				promptLogic();








	}

	private static void promptLogic()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id: ");
		int id = sc.nextInt();
		System.out.println(fetchEmployee(id,employeeMap,"employees"));
		System.out.println("Enter new salary: ");
		double salary = sc.nextDouble();
		updateRecord(id,employeeMap,"employees",salary);
		System.out.println("Updated Salary: " + fetchEmployee(id,employeeMap,"employees"));

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
//			String record = ra.readUTF();
//			System.out.println(record);
			String record = "Employee id : " + ra.readInt() + "" + " Salary: " +  ra.readDouble() + " First Name: " +  ra.readUTF() + " Last Name: " + ra.readUTF();
//			System.out.println(record);

			return record;


		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}



	}

	private static void populateRecords(Map<Integer,Long> map,String path)
	{

		map.forEach((k,v)->
		{
			try(RandomAccessFile ra = new RandomAccessFile(path,"rw"))
			{
				ra.seek(v);
				System.out.println("offset before writing record: " + ra.getFilePointer());
				ra.writeUTF(generateRecord(k).toString());
				System.out.println("offset after writing record: " + ra.getFilePointer());


			}
			catch(IOException e)
			{
				throw new RuntimeException(e);
			}


		});


	}

	private static Employee generateRecord(int id)
	{
		Random r = new Random();
//		Employee random = new Employee(id,r.nextDouble(10,15)*100000,"FirstName: ["+(char) r.nextInt(65,90) + "]",
//				"LastName:  "+(char) r.nextInt(65,90));
		Employee record = new Employee(id,300000,"Bishal","Adhikary");
		System.out.println(":".repeat(50) + record);

		return record;

	}

	private static void updateRecord(int id, Map<Integer,Long> map,String datPath,double salary)
	{
		long offset = map.get(id)+4;
		try(RandomAccessFile ra = new RandomAccessFile(datPath,"rw"))
		{
			ra.seek(offset);
			ra.writeDouble(salary);

		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}


	}

}
