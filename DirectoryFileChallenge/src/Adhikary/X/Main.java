package Adhikary.X;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args) {
		Path deepestFolder = Path.of("public", "assets", "icons");

		try
		{
			Files.createDirectories(deepestFolder);
			generateIndexFile(deepestFolder.getName(0));

		}catch(IOException e)
		{
			System.out.println("Error Message: " + e.getMessage());
		}



	}

	private static void generateIndexFile(Path startingPath) throws IOException {
		Path indexFile = startingPath.resolve("index.txt");
		try (Stream<Path> contents = Files.find(startingPath, Integer.MAX_VALUE, (path, attrs)
				-> true)) {

			String fileContents =
					contents
							.map((path) -> path.toAbsolutePath().toString())
							.collect(() -> new StringJoiner(System.lineSeparator()
											, "Directory Contents: " + System.lineSeparator()
											, System.lineSeparator() + "Generated: " + LocalDateTime.now())
									, (StringJoiner e1, String e2) -> e1.add(e2)
									, (e3, e4) -> e3.merge(e4))
							.toString();

			Files.writeString(indexFile, fileContents, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			System.out.println("Error Message: " + e.getMessage());
		}

		try (Stream<Path> contents = Files.list(startingPath)) {


			contents
					.filter((path) -> Files.isDirectory(path))
					.collect(() -> new ArrayList<Path>()
							, (ArrayList<Path> list, Path path) -> list.add(path)
							, (list1, list2) -> list1.addAll(list2))
					.forEach((dir) -> {

						try {
							generateIndexFile(dir);
						} catch (IOException g) {
							System.out.println("Error Message: " + g.getMessage());
						}
					});


		}

	}


}
