package Adhikary.X;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args) {

//		System.out.println("-".repeat(50));
//		Path cwd = Path.of(".");
//
//		try (Stream<Path> cwdHierarchy = Files.find(cwd, Integer.MAX_VALUE, (path, attr) -> Files.isDirectory(path))) {
//
//			cwdHierarchy.
//					forEach(System.out::println);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("-".repeat(50));
//
//		Path startingPath = Path.of(".");
//
//		FileVisitor<Path> statsVisitor = new Main.StatsVisitor();
//		try {
//			Files.walkFileTree(startingPath, statsVisitor);
//		} catch (IOException e)
//		{
//			throw new RuntimeException(e);
//		}



		// The above logic is for testing through Hard Code :-)


		System.out.println("-".repeat(50));



		Scanner sc = new Scanner(System.in);

		System.out.printf("""
		                                         Greetings ! from Bishal Adhikary :-)    
		                                         
		                               Enter The File Path below (must be an absolute path ;-)  
		
		
		
		""");

		String line = sc.nextLine();

		Path p2 = Path.of(line);

		try {
			Files.walkFileTree(p2,new Main.StatsVisitor());
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}




	}


	public static  class StatsVisitor extends SimpleFileVisitor<Path>
	{

//		private int outStart =0;
		private Path initialPath = null;

		private final Map<Path, List<Long>> folderSizes = new LinkedHashMap<>();
		private final Map<Path,Long> subFolderSizes =  new LinkedHashMap<>();

		private int initialCount;


//		private int level;
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			Objects.requireNonNull(file);
			Objects.requireNonNull(attrs);
//				System.out.println("\t".repeat(level + 1) + file.getFileName());

			List<Long> l = new ArrayList<>();
			l.add(0,0L);
			l.add(1,0L);
			folderSizes.merge(file.getParent(),l,(o,n)->
			{
				    List<Long> list = new ArrayList<>();
					list.add(0,0L);
					list.add(1,0L);
					list.set(0,folderSizes.get(file.getParent()).get(0)+attrs.size());
					list.set(1,folderSizes.get(file.getParent()).get(1)); //  , here , the bug were  when we visited a file  list of values , at index 1 it was always zero , now setting value at 1 fixed the problem
					return list;
			});
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
//					outStart = 0;
				}
				List<Long> list = new ArrayList<>();
				list.add(0,0L);
				list.add(1,0L);

				folderSizes.put(dir,list);
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



				//


//				List<Long> list = new ArrayList<>();
//				list.add(0,0L);
//				list.add(1,0L);
////				if(outStart ==0)
////				{
////					long firstOutSize = folderSizes.get(dir).get(0);
////					folderSizes.merge(dir.getParent(),list,(o,n)->{
////						List<Long> l = new ArrayList<>();
////						l.add(0,o.get(0));
////						l.add(1,o.get(1)+firstOutSize);
////						return l;
////
////					});
////					outStart++;
////				}
////				else {
//				long folderSize = folderSizes.get(dir).get(0);
//				long subFolderSize = folderSizes.get(dir).get(1);
//
//				folderSizes.merge(dir.getParent(), list, (o, n) ->
//
//				{
//					List<Long> l = new ArrayList<>();
//					l.add(0, o.get(0));
//					l.add(1, o.get(1) + folderSize + subFolderSize);
//					return l;
//
//				});
				//

				folderSizes.forEach((key,value)->{

					int level = key.getNameCount() - initialCount-1;
					System.out.printf("%s[%s] - ,%d bytes( Files in it)  -  %d bytes (total in SubFolders) %n","\t".repeat(level),key.getFileName(),value.getFirst(),value.get(1));

					System.out.println("-".repeat(50));


				});
					System.out.println("\n");
			}
			else
			{

				List<Long> list = new ArrayList<>();
				list.add(0,0L);
				list.add(1,0L);
//				if(outStart ==0)
//				{
//					long firstOutSize = folderSizes.get(dir).get(0);
//					folderSizes.merge(dir.getParent(),list,(o,n)->{
//						List<Long> l = new ArrayList<>();
//						l.add(0,o.get(0));
//						l.add(1,o.get(1)+firstOutSize);
//						return l;
//
//					});
//					outStart++;
//				}
//				else {
					long folderSize = folderSizes.get(dir).get(0);
					long subFolderSize = folderSizes.get(dir).get(1);

					folderSizes.merge(dir.getParent(), list, (o, n) ->

					{
						List<Long> l = new ArrayList<>();
						l.add(0,0L);
						l.add(1,0L);
						l.set(0, o.get(0));
						l.set(1, o.get(1) + folderSize + subFolderSize);
						return l;

					});
//					outStart++;
//				}
//				subFolderSizes.merge(dir.getParent(),0L,(o,n)->o += folderSize);

			}

			return FileVisitResult.CONTINUE;

		}



	}






}
