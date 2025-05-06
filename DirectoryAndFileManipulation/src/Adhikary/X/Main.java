package Adhikary.X;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class Main {

	public static void main(String... args)
	{
		Path p = Path.of("public");
		Path p1 = Path.of("public/assets");
		Path p3 = Path.of("public/assets/icons");
		try
		{




			if(!Files.exists(p))
			{
				Files.createDirectory(p);

			}
			if(!Files.exists(p1)) {
				Files.createDirectory(p1);

			}
			if(!Files.exists(p3)) {
				Files.createDirectory(p3);
			}





			Files.walkFileTree(p,new SimpleFileVisitor<Path>()  {



				int dirVisitedCounter = 0;
				int dirExitedCounter = 0;


				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
				{

					Objects.requireNonNull(file);
					return FileVisitResult.CONTINUE;

				}

				@Override
				public FileVisitResult visitFileFailed(Path file,IOException exc) throws IOException
				{

					Objects.requireNonNull(file);
					return FileVisitResult.CONTINUE;

				}
				@Override
				public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs) throws IOException
				{
					Objects.requireNonNull(dir);
					dirVisitedCounter++;
					if(!Files.exists(dir.resolve("index.txt")))
					{
						Files.createFile(dir.resolve("index.txt"));
					}
//
//					if(!(dirCounter<=1))
//					{
//						try(
//						PrintWriter  pw = new PrintWriter(dir.getParent().resolve("index.txt").toString());
//						)
//						{
//							pw.println("Directory :" + dir.getFileName());
//
//
//
//						} catch(IOException e)
//						{
//							System.out.println("Error Message : " + e.getMessage());
//						}
//
//					}
					return FileVisitResult.CONTINUE;

				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir,IOException exc) throws IOException
				{
					Objects.requireNonNull(dir);
					dirExitedCounter++;
//					if(!Files.exists(dir.resolve("index.txt")))
//					{
//						Files.createFile(dir.resolve("index.txt"));
//					}

					if(dirVisitedCounter-dirExitedCounter!=0)
					{
						try(
								BufferedWriter  pw = new BufferedWriter(new FileWriter(dir.getParent().resolve("index.txt").toString(),true));
								BufferedReader br = new BufferedReader(new FileReader(dir.resolve("index.txt").toString()));

								BufferedWriter bwAppend = new BufferedWriter(new FileWriter(dir.getParent().resolve("index.txt").toString(),true));
						)
						{
							if(dirExitedCounter==1)
							{
								System.out.println("dir exit value : " + dirExitedCounter + dir.getFileName());
								pw.write("Directory Name:" + dir.getFileName());
							pw.write("\t\t\t\t\t\t");

							}
							else
							{

								bwAppend.newLine();
								System.out.println("dir exit value else block : " + dirExitedCounter + dir.getFileName());
								bwAppend.write("Directory Name:" + dir.getFileName());

							}










						} catch(IOException e)
						{
							System.out.println("Error Message : " + e.getMessage());
						}

					}
					return FileVisitResult.CONTINUE;

				}





			});



	} catch(IOException e)
		{
			throw new RuntimeException(e);
		}



}
	}
