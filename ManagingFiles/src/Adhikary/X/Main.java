package Adhikary.X;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String... args)
	{
		File oldFile = new File("students.json");
		File newFile = new File("student-activity.json");

		if(oldFile.exists())
		{
			oldFile.renameTo(newFile);
			System.out.println("File renamed successfully");
		}
		else
		{
			System.out.println("File does not exist");
		}


		System.out.println(":".repeat(50));
		Path oldPath = oldFile.toPath();
		Path newPath = newFile.toPath();

		try{
			Files.move(newPath,oldPath);
			System.out.println("Path renamed successfully ! Using the Files helper class");
		} catch(IOException e)
		{
			e.printStackTrace();
		}






	}


}
