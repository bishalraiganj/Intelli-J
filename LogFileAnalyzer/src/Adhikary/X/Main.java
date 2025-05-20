package Adhikary.X;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

	public static void main(String... args)
	{

		String logData = """
				[2025-05-18 09:23:45] INFO  - User john logged in from IP 192.168.0.10
				[2025-05-18 09:24:10] ERROR - Invalid password attempt for user admin
				[2025-05-18 09:24:30] WARN  - Disk space running low on server-01
				[2025-05-18 09:25:01] INFO  - User alice uploaded file report.pdf
				[2025-05-18 09:26:20] INFO  - User bob logged out
				[2025-05-18 09:26:55] ERROR - User charlie attempted access to restricted area
				[2025-05-18 09:27:15] DEBUG - Cache refreshed for user alice
				[2025-05-18 09:28:03] INFO  - User david logged in from IP 192.168.0.22
				[2025-05-18 09:29:11] ERROR - Failed to send email to user emily
				[2025-05-18 09:30:42] WARN  - High memory usage detected
				[2025-05-18 09:31:12] INFO  - User john downloaded monthly_report.xlsx
				[2025-05-18 09:32:00] INFO  - Scheduled backup completed successfully
				[2025-05-18 09:33:15] DEBUG - Session timeout check executed
				[2025-05-18 09:34:21] ERROR - Uncaught exception in module payment
				[2025-05-18 09:35:29] INFO  - User admin changed password
				""";

		Path p = Path.of("log.txt");
		if(!Files.exists(p))
		{
			try {
				Files.createFile(p);
			}catch(IOException e)
			{
				e.printStackTrace();
			}


		}
		writeLog(p, logData);

		System.out.println(logData);
		System.out.println(logReader(p));


		System.out.println(":".repeat(50));
		listLogs(logReader(p)).forEach(System.out::println);

		System.out.println(":".repeat(50));

		mapLogs(listLogs(logReader(p))).forEach((k , v) -> System.out.println("Key: " + k + " | Value: " + v));


		System.out.println(":".repeat(50));

		List<String> logs = listLogs(logReader(p));
		String testLevelString = "INFO";
		long count = countLevel(logs,testLevelString);
		System.out.println(testLevelString + " Count: " + count);


		System.out.println("\n\n End of Instructions /Main thread :-)  \n ");



	}

	private static void writeLog(Path path, String log)
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt")))
		{
			bw.write(log);

		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}

	private static String logReader(Path path)
	{
		String str = "";
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path.toFile())))
		{

		byte[] bArr = bis.readAllBytes();
		str = new String(bArr, StandardCharsets.UTF_8);


		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return str;
	}

	private static List<String> listLogs(String logString)
	{
		String[] logs = logString.split("\n");

		List<String> list = new ArrayList<>(Arrays.asList(logs));

		return list;
	}

	private static Map<String,List<String>> mapLogs(List<String> logs)
	{
		Map<String,List<String>> map = logs.stream()
				.collect(Collectors.groupingBy((e)->{

					Pattern pattern = Pattern.compile("^\\[.*]");

					Matcher matcher = pattern.matcher(e);
					 matcher.find();
//					String match = matcher.group();
//					String finalString = e.replace(match,"");
//					return finalString;

					return matcher.group();
				},Collectors.toList()));


		return map;
	}

	private static long countLevel(List<String> logs, String level)
	{
		long count = logs.stream()
				.filter( (e)-> {

					Pattern p = Pattern.compile(level);
					Matcher matcher = p.matcher(e);
					return matcher.find();

				})
				.count();
		return count;
	}

}
