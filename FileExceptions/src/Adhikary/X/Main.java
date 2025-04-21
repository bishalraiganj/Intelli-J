package Adhikary.X;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String... args)  {

		System.out.println("Current Working Directory (cwd) = " + new File("").getAbsolutePath());

		String filename = "files/testing.csv";

		File f1 = new File(".");
		System.out.println("-".repeat(50));
		System.out.println(f1.getAbsolutePath());
//		Path path = Paths.get(filename);


//		try {
//			List<String> lines = Files.readAllLines(path);
//		} catch (IOException e)
//		{
//			throw new RuntimeException(e);
//		}
//

//		testFile(filename);
//		testFile2(null);




//		File file = new File(".",filename);
		File file = new File(new File("").getAbsolutePath(),filename);
		System.out.println(file.getAbsolutePath());
		if(!file.exists())
		{
			System.out.println("I can't run unless this file exists");
//			System.out.println("Quitting Application, go figure it out");
			return;
		}
		System.out.println("I'm good to go.");

		for(File f : File.listRoots())
		{
			System.out.println(f);
		}


	}

	private static void testFile(String filename)
	{
		Path path = Paths.get(filename);
		FileReader reader = null;
		try
		{
//			List<String> lines = Files.readAllLines(path);
			reader = new FileReader(filename);
		} catch(IOException e)
		{
			throw new RuntimeException(e);
//			int i = 1/0;
		}
		finally {
			if(reader != null)
			{
				try {
					reader.close();
				} catch(IOException e)
				{
					throw new RuntimeException(e);
				}
			}
			System.out.println("Maybe I'd log something either way...");
		}
		System.out.println("File exists and able to use as a resource");
	}



	private static void testFile2(String filename) {
		try (FileReader reader = new FileReader(filename)) {
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch(NullPointerException|IllegalArgumentException badData)
		{
			System.out.println("User has added bad data" + badData.getMessage());
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
		catch(Exception e)
		{
			System.out.println("Something unrealted and unexpected happened");
		}
		finally {
			System.out.println("Maybe I'd log something either way...");
		}
			System.out.println("File exists and able to use as a resources");




	}

}
