package Adhikary.X;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class Main {
	public static void main(String... args)
	{
		Path p = java.nio.file.Path.of("public");
		Path p2 = Path.of("public/assets");
		Path p3 = Path.of("public/assets/icons");


		try
		{


			if (!Files.exists(p)) {
				Files.createDirectory(p);
			}
			if(!Files.exists(p2))
			{
				Files.createDirectory(p2);
			}
			if(!Files.exists(p3))
			{
				Files.createDirectory(p3);
			}




			Files.walkFileTree(p,new SimpleFileVisitor<Path>(){


				Path  currentFilePath = null;
				Path  previousFilePath = null;
				int firstVisitStatus = 0 ;
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
				{
					Objects.requireNonNull(file);

					System.out.println(file.toAbsolutePath());
					currentFilePath = file.getParent();

					try(FileWriter fw = new FileWriter(file.getParent().resolve("index.txt").toString(),true))

					{
						if(!currentFilePath.equals(previousFilePath))
						{
							firstVisitStatus = 0;
						}
//						System.out.println(file.getFileName());
						if(!file.equals(file.getParent().resolve("index.txt")))
						{


							if(firstVisitStatus == 0)
							{ // logic problem here
								previousFilePath = file.getParent();
								fw.write("\n" + file.getFileName().toString());
								currentFilePath = file.getParent();
								firstVisitStatus =1 ;


							}
							else
							{
								currentFilePath = file.getParent();
								fw.append("\n"+file.getFileName().toString());
							}
						}

					} catch(IOException e)
					{
						System.out.println("Error Message: " + e.getMessage());
					}


					return FileVisitResult.CONTINUE;


				}

				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
				{
					Objects.requireNonNull(dir);
					Objects.requireNonNull(attrs);

					if(!Files.exists(dir.resolve("index.txt")))
					{
						Files.createFile(dir.resolve("index.txt"));
					}

					return FileVisitResult.CONTINUE;


				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir , IOException e)
				{
					Objects.requireNonNull(dir);


					return FileVisitResult.CONTINUE;
				}











			});



		} catch(IOException e)
		{
			System.out.println("Error Message : " + e.getMessage());
		}



	}


}
