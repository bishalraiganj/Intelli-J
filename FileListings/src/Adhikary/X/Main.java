package Adhikary.X;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args)
	{

		Path path = Path.of("");
		System.out.println("cwd = " + path.toAbsolutePath());

		try(Stream<Path> paths = Files.list(path))
		{

			paths
			        .map((SubPath)->listDir(SubPath))
					.forEach((SubPath)->System.out.println(SubPath));

		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}

		System.out.println("-".repeat(50));

		try (Stream<Path> paths = Files.walk(path,2))
		{
			paths
					.filter((subPath)->Files.isRegularFile(subPath))
					.map((subPath)->listDir(subPath))
					.forEach(System.out::println);

		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}


		System.out.println("-".repeat(50));

		try (Stream<Path> paths = Files.find(path,Integer.MAX_VALUE,
				(p,attr)-> attr.isRegularFile() && attr.size()>300))
		{
			paths
//					.filter((subPath)->Files.isRegularFile(subPath))
					.map((subPath)->listDir(subPath))
					.forEach(System.out::println);

		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}

		path = path.resolve(".idea");

		System.out.println("=".repeat(50) + "DirectoryStream" + "=".repeat(50));

		try(DirectoryStream<Path> dirs = Files.newDirectoryStream(path,"*.xml"))
		{
			dirs.forEach((subPath)->System.out.println(Main.listDir(subPath)));
		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}

		System.out.println("=".repeat(50) + "DirectoryStream" + "=".repeat(50));

		try(DirectoryStream<Path> dirs = Files.newDirectoryStream(path,
				(subPath)->subPath.getFileName().toString().endsWith(".xml")
		&& Files.isRegularFile(subPath) && Files.size(subPath)>1000))
		{
			dirs.forEach((subPath)->System.out.println(Main.listDir(subPath)));
		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}



	}

	private static String listDir(Path path)
	{
		try{
			boolean isDir = Files.isDirectory(path);
			FileTime dateField = Files.getLastModifiedTime(path);
			LocalDateTime modDT = LocalDateTime.ofInstant(dateField.toInstant(), ZoneId.systemDefault());
			return "%tD %tT %-5s %12s %s".formatted(modDT,modDT, (isDir ? "<DIR>" : " "),(isDir ? " " :Files.size(path)),path);
		}catch(IOException e)
		{
			System.out.println("Whoops! Something went wrong with " + path);
			return path.toString();
		}
	}



}
