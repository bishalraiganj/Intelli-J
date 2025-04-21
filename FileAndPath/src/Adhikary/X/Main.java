package Adhikary.X;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String... args)
	{

		useFile("testfile.txt");

		System.out.println("-".repeat(50));

		usePath("pathFile.txt");

		System.out.println("-".repeat(50));
	}

	private static void useFile(String fileName)
	{

		File file = new File(fileName);
		boolean fileExists = file.exists();
		System.out.printf("File '%s' %s%n",fileName,fileExists ? "exists" : "does not exist");

		if(fileExists)
		{
			System.out.println("Deleting file: " + fileName);
			fileExists = !file.delete();
		}

		if(!fileExists)
		{
			try
			{

				file.createNewFile();
			}
			catch(IOException e)
			{
//				throw new RuntimeException(e);
				System.out.println("Something went wrong");
			}
			System.out.println("Created file: " + fileName);
			if(file.canWrite())
			{
				System.out.println("Would write to file here");
			}
		}
	}

	private static void usePath(String fileName)
	{
		Path path = Path.of(fileName);
		boolean fileExists = Files.exists(path);

		System.out.printf("File '%s' %s%n", fileName,fileExists ? "exists" : "does not exist" );
		if(fileExists)
		{
			System.out.println("deleting file: " + fileName);
			try {
				Files.delete(path);
				fileExists = false;
			}
			catch(IOException e)
			{
				System.out.println("Trace:");
				e.printStackTrace();
				System.out.println("-".repeat(50));
			}
		}

		if(!fileExists)
		{
			try {
				Files.createFile(path);
				System.out.println("Created file: " + fileName);
				if (Files.isWritable(path)) {
//					System.out.println("Would write to file here");
					Files.writeString(path, """
							Here is some data,
							For my life,
							just to prove,
							Using the Files class and path are better!
							""");
				}

				System.out.println("And I can read too");
				System.out.println("-".repeat(50));
				Files.readAllLines(path)
						.forEach((e)->System.out.println(e));

			}
			catch (IOException e)
			{
				System.out.println("Something went wrong");

			}

		}







	}



}
