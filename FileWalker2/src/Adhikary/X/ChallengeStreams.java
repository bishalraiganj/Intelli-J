package Adhikary.X;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChallengeStreams {

	public static void main(String... args)
	{


		Path startingPath = Path.of("..");
		int index =  startingPath.getNameCount();
		try(Stream<Path> paths = Files.walk(startingPath,Integer.MAX_VALUE))
		{
			paths
					.filter((e)->Files.isRegularFile(e))
					.collect(Collectors.groupingBy((e)->e.subpath(index,index+1)  // This Classifier function groups by the first level of sub folders for all files of any depth
							,Collectors.summarizingLong((e)->
							{

								try{
									return Files.size(e);
								}
								catch(IOException exc)
								{
									throw new RuntimeException(exc);
								}
		})))

					.entrySet()
					.stream()
					.sorted(Comparator.comparing((e)->e.getKey().toString()))
					.forEach((e)->
					{
						System.out.printf("[%s] %,d bytes, %d files %n",e.getKey(),e.getValue().getSum(),e.getValue().getCount());
					});







		}
		catch(IOException e)
		{
			e.printStackTrace();
		}



	}



}
