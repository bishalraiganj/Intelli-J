package Adhikary.X;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Main {

	public static void main(String... args)
	{

		System.out.println("Enter the File Path : \n");

		Scanner sc =  new Scanner(System.in);
		String filePathString = sc.nextLine();
		Path filePath = Path.of(filePathString);


		try
		{
			Files.walkFileTree(filePath,new Main.StatsVisitor());
		}
		catch(IOException e)
		{
			 throw new RuntimeException(e);
		}




	}


	public static class StatsVisitor extends SimpleFileVisitor<Path>{


		private Path initialPath = null;
		private final Map<Path, List<Long>> folderStats =  new LinkedHashMap<>();
		private int initialNameCount;


		@Override
		public   FileVisitResult  visitFile(Path file, BasicFileAttributes attrs) throws IOException
		{
		 	Objects.requireNonNull(file);
			Objects.requireNonNull(attrs);

			List<Long> fileStats = new ArrayList<>();
			fileStats.add(0,attrs.size());
			fileStats.add(1,0L);
			fileStats.add(2,0L);
			fileStats.add(3,0L);




			folderStats.merge(file.getParent(),fileStats,(o,n)-> {
				o.set(0,o.get(0)+attrs.size());
//				if(!Files.isRegularFile(file)&& file.getParent().getNameCount()-initialPath.getNameCount()==0)
//				{
//
//				}

				folderStats.get(file.getParent()).set(2,folderStats.get(file.getParent()).get(2)+1);
				return o;
			});

			return FileVisitResult.CONTINUE;
		}


		@Override
		public FileVisitResult preVisitDirectory(Path dir , BasicFileAttributes attrs) throws IOException
		{
			Objects.requireNonNull(dir);
			Objects.requireNonNull(attrs);


			if(initialPath == null)
			{
				initialPath = dir;
				initialNameCount = dir.getNameCount();
			}
			else {



				int relativeLevel = dir.getNameCount() - initialPath.getNameCount();

				if (relativeLevel == 1) {
					folderStats.clear();
				}

				List<Long> directoryStats = new ArrayList<>();
				directoryStats.add(0, 0L);
				directoryStats.add(1, 0L);
				directoryStats.add(2, 0L);
				directoryStats.add(3, 0L);

				folderStats.put(dir, directoryStats);


			}

			return FileVisitResult.CONTINUE;
		}


		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
		{
			Objects.requireNonNull(dir);

			int relativeLevel = dir.getNameCount()-initialPath.getNameCount();
			List<Long> list = new ArrayList<>();
			list.add(0,0L);
			list.add(1,0L);
			list.add(2,0L);
			list.add(3,0L);
			if(dir.equals(initialPath))
			{
				return FileVisitResult.TERMINATE;
			}
			if(relativeLevel>1) {
				folderStats.merge(dir.getParent(), list, (o, n) -> { //

					o.set(1,folderStats.get(dir.getParent()).get(1) +   folderStats.get(dir).get(1)+folderStats.get(dir).get(0));
					o.set(3,folderStats.get(dir.getParent()).get(3)  + 1);
					return o;

				});
			}
			if(relativeLevel ==1)
			{

				folderStats.forEach((path,statsList)->System.out.println("\t".repeat(path.getNameCount()-initialNameCount-1) + "%s (files in it ) %d bytes (sub-folders size) %d  files - %d folders - %d ".formatted(path.getFileName(),statsList.get(0),statsList.get(1)
						,statsList.get(2),statsList.get(3))));

				System.out.println("-".repeat(50));
			}

			return FileVisitResult.CONTINUE;

		}











	}

}
