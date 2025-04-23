package Adhikary.X;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
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

		private Path initialPath = null;

		private final Map<Path,Long> folderSizes = new LinkedHashMap<>();
		private final Map<Path,Long> subFolderSizes =  new LinkedHashMap<>();

		private int initialCount;


//		private int level;
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			Objects.requireNonNull(file);
			Objects.requireNonNull(attrs);
//				System.out.println("\t".repeat(level + 1) + file.getFileName());

			folderSizes.merge(file.getParent(),0L,(o,n)->o += attrs.size());
				return FileVisitResult.CONTINUE;
		}


		@Override
		public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs) throws IOException
		{
			Objects.requireNonNull(dir);
			Objects.requireNonNull(attrs);
//			level++;
//			System.out.println("\t".repeat(level) + dir.getFileName());

			if(initialPath ==  null)
			{
				initialPath = dir;
				initialCount = dir.getNameCount();
			}
			else {
				int relativeLevel = dir.getNameCount() - initialCount;
				if (relativeLevel == 1)
				{
					folderSizes.clear();
				}
				folderSizes.put(dir,0L);
			}



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
//			level--;
			if(dir.equals(initialPath))
			{
				return FileVisitResult.TERMINATE;
			}
			int relativeLevel =  dir.getNameCount()-initialCount;
			if(relativeLevel==1)
			{
				folderSizes.forEach((key,value)->{

					int level = key.getNameCount() - initialCount-1;
					System.out.printf("%s[%s] - ,%d bytes( Files in it)  %n","\t".repeat(level),key.getFileName(),value);


				});
			}
			else
			{
				long folderSize = folderSizes.get(dir);
				folderSizes.merge(dir.getParent(),0L,(o,n)->o += folderSize);
//				subFolderSizes.merge(dir.getParent(),0L,(o,n)->o += folderSize);

			}

			return FileVisitResult.CONTINUE;

		}



	}






}
