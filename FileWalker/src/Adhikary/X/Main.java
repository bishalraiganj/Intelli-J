package Adhikary.X;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args) {

		System.out.println("-".repeat(50));
		Path cwd = Path.of(".");

		try (Stream<Path> cwdHierarchy = Files.find(cwd, Integer.MAX_VALUE, (path, attr) -> Files.isDirectory(path))) {

			cwdHierarchy.
					forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("-".repeat(50));

		Path startingPath = Path.of(".");

		FileVisitor<Path> statsVisitor = new Main.StatsVisitor();
		try {
			Files.walkFileTree(startingPath, statsVisitor);
		} catch (IOException e)
		{
			throw new RuntimeException(e);
		}







	}


	public static  class StatsVisitor extends SimpleFileVisitor<Path>
	{

		private int level;
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
		{
				Objects.requireNonNull(file);
				Objects.requireNonNull(attrs);
				System.out.println("\t".repeat(level + 1) + file.getFileName());
				return FileVisitResult.CONTINUE;
		}


		@Override
		public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs) throws IOException
		{
			Objects.requireNonNull(dir);
			Objects.requireNonNull(attrs);
			level++;
			System.out.println("\t".repeat(level) + dir.getFileName());
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
		{
			Objects.requireNonNull(dir);
//			if(exc != null )
//			{
//				throw exc;
//			}
			level--;
			return FileVisitResult.CONTINUE;

		}



	}






}
