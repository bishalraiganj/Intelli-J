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


				int firstInvocationStatus = 0;
				int visitedDirNum = 0;
				int exitedDirNum = 0;
				int firstDirExitStatus = 0;

				Path p = null;
				Path prevDir = null;

//				@Override
//				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
//				{
//					Objects.requireNonNull(file);
//
//					if(firstInvocationStatus==0)
//					{
//						try(FileWriter fw = new FileWriter(file.getParent().resolve("index.txt").toString()))
//						{
//							fw.write(file.getFileName().toString());
//
//							p=file;
//							firstInvocationStatus++;
//
//					} catch(IOException e)
//						{
//							System.out.println("Error Message: " + e.getMessage());
//						}
//
//					}
//					else if(!file.getParent().equals(p.getParent()) && !file.getFileName().toString().equals("index.txt"))
//						{
//
//							try(FileWriter fw = new FileWriter(file.getParent().resolve("index.txt").toString())) {
//								fw.write(file.getFileName().toString());
//
//								p = file;
//							} catch (IOException e)
//							{
//								e.printStackTrace();
//							}
//						}
//					else if(p.getParent().equals(file.getParent())&&!file.getFileName().toString().equals("index.txt"))
//					{
//						try(FileWriter fw = new FileWriter(file.getParent().resolve("index.txt").toString(),true))
//						{
//							fw.append("\n" + file.getFileName().toString());
//						} catch(IOException e)
//						{
//							e.printStackTrace();
//						}
//					}
//
//
//
//					System.out.println(file.toAbsolutePath());
//
//
//
//
//
//
//					return FileVisitResult.CONTINUE;
//
//
//				}

				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
				{
					Objects.requireNonNull(dir);
					Objects.requireNonNull(attrs);

					visitedDirNum++;


					return FileVisitResult.CONTINUE;


				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir , IOException e) throws IOException
				{
					Objects.requireNonNull(dir);
					exitedDirNum++;


					if(exitedDirNum!=visitedDirNum+1)  // this condition checks the  number of file in order
					{
						if(firstDirExitStatus == 0)
						{
							try(FileWriter fw = new FileWriter(dir.getParent().resolve("index.txt").toString()))
							{
								fw.write(dir.getFileName().toString());
								prevDir = dir;
								firstDirExitStatus++;
							}
						}
						else if(!dir.equals(prevDir)&&exitedDirNum!=visitedDirNum)
						{
							try(FileWriter fw = new FileWriter(dir.getParent().resolve("index.txt").toString()))
							{
								fw.write(dir.getFileName().toString());
								prevDir = dir;
							}
						}
						else if(exitedDirNum!=visitedDirNum)
						{
							try(FileWriter fw = new FileWriter(dir.getParent().resolve("index.txt").toString(),true))
							{
								fw.append("\n"+dir.getFileName().toString());
							}
						}

						if(!Files.exists(dir.resolve("index.txt")))
						{
							try {
								Files.createFile(dir.resolve("index.txt"));
							} catch (IOException f)
							{
								System.out.println("Error Message:  " + f.getMessage());
							}

						}
					}


					return FileVisitResult.CONTINUE;
				}











			});



		} catch(IOException e)
		{
			System.out.println("Error Message : " + e.getMessage());
		}



	}


}
