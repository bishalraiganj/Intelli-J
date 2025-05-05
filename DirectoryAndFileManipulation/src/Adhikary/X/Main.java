package Adhikary.X;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String... args)
	{
		Path p = Path.of("public");
		Path p1 = Path.of("public/assets");
		Path p3 = Path.of("public/assets/icons");
		try{
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





	} catch(IOException e)
		{
			throw new RuntimeException(e);
		}



}
	}
