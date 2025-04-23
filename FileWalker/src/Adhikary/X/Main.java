package Adhikary.X;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{

		System.out.println("-".repeat(50));
		Path cwd =  Path.of(".");

		try( Stream<Path> cwdHierarchy = Files.find(cwd,Integer.MAX_VALUE,(path, attr)->Files.isDirectory(path)))
		{

			cwdHierarchy.
					forEach(System.out::println);

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("-".repeat(50));







	}


	public static  class statsVisitor extends SimpleFileVisitor<Path>
	{

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
		{
				Objects.requireNonNull(file);
				Objects.requireNonNull(attrs);
				System.out.println(file.getFileName());
				return FileVisitResult.CONTINUE;
		}


		@Override
		public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs) throws IOException
		{
			Objects.requireNonNull(dir);
			Objects.requireNonNull(attrs);
			System.out.println(dir.getFileName());
			return FileVisitResult.CONTINUE;



		}
	}






}
