package Adhikary.X;

import javax.naming.directory.BasicAttributes;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Main {

	private static Map<Path, List<String>> contentMap = new LinkedHashMap<>();

	public static void main(String... args)
	{
		try
		{
			Path aPublic = Path.of("public");
			Path aAssets = Path.of("assets");
			Path  aIcons = Path.of("icons");
			if(!Files.exists(aPublic))
			{
				Files.createDirectory(aPublic);
			}
			if(!Files.exists(aPublic.resolve(aAssets)))
			{
				Files.createDirectory(aPublic.resolve(aAssets));
			}
			if(!Files.exists(aPublic.resolve(aAssets).resolve(aIcons)))
			{
				Files.createDirectory(aPublic.resolve(aAssets).resolve(aIcons));
			}

			Files.walkFileTree(aPublic,new SimpleFileVisitor<Path>()
			{

				int dirVisitedOrder = 0;
				int dirExitedOrder = 0;

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
				{

					Objects.requireNonNull(file);
					Objects.requireNonNull(attrs);

					contentMap.get(file.getParent()).add(file.getFileName().toString());

					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs) throws IOException
				{
					Objects.requireNonNull(dir);
					Objects.requireNonNull(attrs);

					dirVisitedOrder++;
					contentMap.put(dir,new ArrayList<>());
					try{
						if(!Files.exists(dir.resolve("index.txt")))
						{
							Files.createFile(dir.resolve("index.txt"));
						}

					} catch(IOException e)
					{
						System.out.println("Error Message: " + e.getMessage());
					}

					return FileVisitResult.CONTINUE;

				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir,IOException exc) throws IOException
				{

					Objects.requireNonNull(dir);
					dirExitedOrder++;
					if(dirExitedOrder != dirVisitedOrder)
					{
						contentMap.get(dir.getParent()).add("(DIR)-\"" + dir.getFileName().toString() + "\"");
					}
					return FileVisitResult.CONTINUE;
				}

			});



		} catch(IOException e)
		{
			System.out.println("Error Message: " + e.getMessage());
		}


		contentMap.forEach((k,v)->System.out.println("Path -( " + k + " ) - "  + "Contents : " +  v.toString()));

//
//		contentMap.entrySet().stream()
//				.forEach((e)->{
//
//					try(FileWriter fw = new FileWriter(e.getKey().))
//
//
//				})


	}




}
