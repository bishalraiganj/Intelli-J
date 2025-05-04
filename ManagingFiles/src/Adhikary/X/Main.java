package Adhikary.X;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{
//		File oldFile = new File("students.json");
//		File newFile = new File("student-activity.json");
//
//		if(oldFile.exists())
//		{
//			oldFile.renameTo(newFile);
//			System.out.println("File renamed successfully");
//		}
//		else
//		{
//			System.out.println("File does not exist");
//		}
//
//
//		System.out.println(":".repeat(50));
//		Path oldPath = oldFile.toPath();
//		Path newPath = newFile.toPath();

//		Path oldPath = Path.of("students.json");
//		Path newPath = Path.of("files/student-activity.json");
//
//
//
//		try{
////			Files.createDirectories(newPath.subpath(0,newPath.getNameCount()-1));
//			Files.move(oldPath,newPath);
//			System.out.println(oldPath + " moved (renamed to)--> " + newPath);
//		} catch(IOException e)
//		{
//			e.printStackTrace();
//		}


		System.out.println(":".repeat(50));

		Path fileDir = Path.of("files");
		Path resourceDir = Path.of("resources");

		try {
//			if(Files.exists(Path.of("resources")))
//			{
//				Files.walk(Path.of("resources"),Integer.MAX_VALUE,(new SimpleFileVisitor<Path>{
//
//			}))
//				Files.delete(Path.of("resources"));

//			if (Files.exists(resourceDir)) {
//				Files.delete(resourceDir);
//			}

//			Files.deleteIfExists(fileDir);
			if (Files.exists(resourceDir))
			{
				recurseDelete(resourceDir);
			}
			recurseCopy(fileDir,resourceDir);
			System.out.println("Directory copied to " + resourceDir);
		} catch (IOException e)
		{
			e.printStackTrace();
		}






	}


	public static void recurseCopy(Path source,Path target) throws IOException
	{
		Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);
		if(Files.isDirectory(source))
		{
			 try(Stream<Path> children = Files.list(source))
			 {
				 children.collect(()->new ArrayList<>(),
						 (ArrayList<Path> e1,Path e2)->e1.add(e2)
				 ,
						 (e3,e4)->e3.addAll(e4))
				 .forEach((pathInstance)->

						 {
							 try {
						 recurseCopy(pathInstance,target.resolve(pathInstance.getFileName()));

							 } catch (IOException e)
							 {
								 throw new RuntimeException(e);
							 }
						 });



			 } catch(IOException e)
			 {
				 throw new RuntimeException(e);
			 }


		}



	}

	public static void recurseDelete(Path target) throws IOException
	{
		if(Files.isDirectory(target))
		{
			try(Stream<Path> children = Files.list(target))
			{
				children.collect(()->new ArrayList<>(),
								(ArrayList<Path> e1,Path e2)->e1.add(e2)
								,
								(e3,e4)->e3.addAll(e4))
						.forEach((pathInstance)->

						{
							try {
								recurseDelete(pathInstance);

							} catch (IOException e)
							{
								throw new RuntimeException(e);
							}
						});


//				Files.delete(target);

			} catch(IOException e)
			{
				throw new RuntimeException(e);
			}


		}

		Files.delete(target);



	}


}
