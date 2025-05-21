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

	public static void main(String... args) {

		String logData = """
				[2025-05-18 09:23:45] INFO  - User john logged in from IP 192.168.0.10
				[2025-05-18 09:23:45] INFO  - User john logged in from IP 123.434.45.0
				[2025-05-19 08:21:24] INFO  - User john logged in from IP 192.169.0.12
				[2025-05-18 09:24:10] ERROR - Invalid password attempt for user admin
				[2025-05-18 09:24:30] WARN  - Disk space running low on server-01
				[2025-05-18 09:25:01] INFO  - User alice uploaded file report.pdf
				[2025-05-18 09:26:20] INFO  - User bob logged out
				[2025-05-18 09:26:55] ERROR - User charlie attempted access to restricted area
				[2025-05-18 09:27:15] DEBUG - Cache refreshed for user alice
				[2025-05-18 09:28:03] INFO  - User david logged in from IP 192.168.0.22
				[2025-05-19 08:21:19] INFO  - User david logged in from IP 192.167.0.10
				[2025-05-18 09:29:11] ERROR - Failed to send email to user emily
				[2025-05-18 09:30:42] WARN  - High memory usage detected
				[2025-05-18 09:31:12] INFO  - User john downloaded monthly_report.xlsx
				[2025-05-18 09:32:00] INFO  - Scheduled backup completed successfully
				[2025-05-18 09:33:15] DEBUG - Session timeout check executed
				[2025-05-18 09:34:21] ERROR - Uncaught exception in module payment
				[2025-05-18 09:35:29] INFO  - User admin changed password
				""";

		Path p = Path.of("log.txt");
		if (!Files.exists(p)) {
			try {
				Files.createFile(p);
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
		writeLog(p, logData);

		System.out.println(logData);
		System.out.println(logReader(p));


		System.out.println(":".repeat(50));
		listLogs(logReader(p)).forEach(System.out::println);

		System.out.println(":".repeat(50));

		mapLogs(listLogs(logReader(p))).forEach((k, v) -> System.out.println("Key: " + k + " | Value: " + v));


		System.out.println(":".repeat(50));

		List<String> logs = listLogs(logReader(p));
		String testLevelString = "INFO";
		long count = countLevel(logs, testLevelString);
		System.out.println(testLevelString + " Count: " + count);

		System.out.println(":".repeat(50));

		loggedUsers(logs).forEach((k, v) -> System.out.println(k + " | Value: " + v));


		System.out.println(":".repeat(50));

		timedLogs(logs).forEach((k,v)-> System.out.println(k + " | Value: " + v));

		System.out.println("\n\n End of Instructions /Main thread :-)  \n ");


	}






	private static void writeLog(Path path, String log) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"))) {
			bw.write(log);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}






	private static String logReader(Path path) {
		String str = "";
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path.toFile()))) {

			byte[] bArr = bis.readAllBytes();
			str = new String(bArr, StandardCharsets.UTF_8);


		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}










	private static List<String> listLogs(String logString) {
		String[] logs = logString.split("\n");

		List<String> list = new ArrayList<>(Arrays.asList(logs));

		return list;
	}











	private static Map<String, List<String>> mapLogs(List<String> logs) {
		Map<String, List<String>> map = logs.stream()
				.collect(Collectors.groupingBy((e) -> {

					Pattern pattern = Pattern.compile("^\\[.*]");

					Matcher matcher = pattern.matcher(e);
					matcher.find();
//					String match = matcher.group();
//					String finalString = e.replace(match,"");
//					return finalString;

					return matcher.group();
				}, Collectors.toList()));


		return map;
	}








	private static long countLevel(List<String> logs, String level) {
		long count = logs.stream()
				.filter((e) -> {

					Pattern p = Pattern.compile(level);
					Matcher matcher = p.matcher(e);
					return matcher.find();

				})
				.count();
		return count;
	}







	private static Map<String, List<String>> loggedUsers(List<String> logs) {
		List<String> loggedList = logs.stream()
				.filter((e) -> {

					Pattern p = Pattern.compile("logged in");
					Matcher matcher = p.matcher(e);
					return matcher.find();

				})
				.collect(() -> new ArrayList<>(), (ArrayList<String> e1, String e2) -> e1.add(e2), (e3, e4) -> e3.addAll(e4));

		Map<String, List<String>> userMap = loggedList.stream()
				.collect(Collectors.groupingBy((e) -> {

					Pattern p = Pattern.compile("User.*logged in");
					Matcher matcher = p.matcher(e);
					matcher.find();
					String str = matcher.group();
					str = str.replaceAll("User", "");
					str = str.replaceAll("logged in", "");
					return str;


				}, Collectors.toList()));


//		userMap.forEach((k , v) -> System.out.println(k + " | value: " + v));

		Map<String, List<String>> map = userMap.entrySet().stream()
				.map((entry) -> {
					List<String> ipList = new ArrayList<>();
					for (String s : entry.getValue()) {
						Pattern p = Pattern.compile("[0-9]+([.][0-9]+)+");
						Matcher matcher = p.matcher(s);
						matcher.find();
//						System.out.println(matcher.group());
						ipList.add(matcher.group());
					}

					return Map.entry(entry.getKey(), ipList);
				})
				.collect(() -> new LinkedHashMap<String, List<String>>(), (LinkedHashMap<String, List<String>> e1, Map.Entry<String, List<String>> e2) -> {

					e1.put(e2.getKey(), e2.getValue());
				}, (e3, e4) -> e3.putAll(e4));


		return map;

	}






	private static Map<String, Map<String,List<String>>>   timedLogs(List<String> logs)
	{
		Map<String,Map<String,List<String>>>  map = logs.stream()
				.collect(Collectors.groupingBy(( e)->{

					Pattern p = Pattern.compile("^\\[[0-9-]+");
					Matcher m = p.matcher(e);
					m.find();


//					System.out.println(m.group());
					return m.group();

				} ,Collectors.groupingBy(( e1)->{

					Pattern p = Pattern.compile("[0-9:]+");
					Matcher m = p.matcher(e1);
					m.find();
					m.find();
					m.find();
					m.find();


//					System.out.println(m.group());
					return m.group();

				} ,Collectors.toList())));


		return map;



	}

	private static Map<String,Map<String,List<String>>> filterLogs(Map<String,Map<String,List<String>>> map, String date,String timeOrigin, String timeBound)
	{

		Map<String,Map<String,List<String>>> resultMap = new LinkedHashMap<>();

		Pattern p = Pattern.compile("[0-9]+");
		Matcher oM = p.matcher(timeOrigin);
		Matcher bM = p.matcher(timeBound);

		oM.find();
		int oHour = Integer.valueOf(oM.group());
		oM.find();
		int oMin = Integer.valueOf(oM.group());
		oM.find();
		int oSec = Integer.valueOf(oM.group());

		bM.find();
		int bHour = Integer.valueOf(bM.group());
		bM.find();
		int bMin = Integer.valueOf(bM.group());
		bM.find();
		int bSec = Integer.valueOf(bM.group());



		map.entrySet().stream()
				.filter((entry)->{

					Pattern p12 = Pattern.compile("[0-9-]+");
					Matcher m = p12.matcher(entry.getKey());
					m.find();
					return m.group().equals(date);
				})
				.forEach((entry)->{

					Map<String, List<String>> mp = new LinkedHashMap<>();


					for(Map.Entry<String,List<String>> entryNested : entry.getValue().entrySet())
					{

						Pattern p1 = Pattern.compile("[0-9]+");
						Matcher mKey = p1.matcher(entryNested.getKey());
						mKey.find();
						int mHour = Integer.valueOf(mKey.group());
						mKey.find();
						int mMinute = Integer.valueOf(mKey.group());
						mKey.find();
						int mSecond = Integer.valueOf(mKey.group());
						if(mHour<=bHour && mHour>=oHour && mMinute<=bMin && mMinute>=oMin && mSecond<=bSec && mSecond>=oSec)
						{
							mp.put(entryNested.getKey(),entryNested.getValue());
						}

					}
					resultMap.put(entry.getKey(),mp);


				});

		Map<String,Map<String,List<String>>> finalMap = resultMap.entrySet()
				.stream()
				.filter((entry)-> {

					if(entry.getValue().size()>0)
					{
						return true;
					}
					return false;
				})
				.collect(()->new LinkedHashMap<>(),(LinkedHashMap<String,Map<String,List<String>>> e1, Map.Entry<String,Map<String,List<String>>> e2)-> e1.put(e2.getKey(),e2.getValue()),

						(e3,e4)->e3.putAll(e4));



		return finalMap;
	}

}
