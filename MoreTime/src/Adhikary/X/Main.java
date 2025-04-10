package Adhikary.X;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class Main {



    static int counter = 0;
    public static void main(String... args)
    {

        System.setProperty("user.timezone","America/Los_Angeles");
//        System.setProperty("useer.timezone","UTC");
        System.out.println(ZoneId.systemDefault());

        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
        ZoneId.getAvailableZoneIds().stream()
                .filter((s)->s.startsWith("India"))
                .sorted()
                .map((s)->ZoneId.of(s))
                .peek((s)->++counter)
                .forEach((z)->System.out.println(z.getId() + ": " + z.getRules()));

        System.out.println("Indian Zone's Count = " + counter);

        System.out.println("-".repeat(50));

        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldWay = new HashSet<>(Set.of(alternate));

        jdk8Zones.removeAll(oldWay);
        System.out.println(jdk8Zones);

        System.out.println("-".repeat(50));

        oldWay.removeAll(jdk8Zones);
        System.out.println(oldWay);

        ZoneId bet = ZoneId.of("BET",ZoneId.SHORT_IDS);
        System.out.println(bet);

        System.out.println("-".repeat(50));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Instant instantNow = Instant.now();
        System.out.println(instantNow);

        for(ZoneId z : List.of(
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Europe/Paris"),
                ZoneId.of("America/New_York")))
        {
            DateTimeFormatter zoneFormatter  = DateTimeFormatter.ofPattern("z:zzzz");
            System.out.println(z);
            System.out.println("\t" + instantNow.atZone(z).format(zoneFormatter));
            System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
            System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));



        }


        Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
        LocalDateTime dob = LocalDateTime.ofInstant(dobInstant,ZoneId.systemDefault());
        System.out.println("Your kid's birthdate, LA time = " + dob.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dobSydney = ZonedDateTime.ofInstant(dobInstant,ZoneId.of("Australia/Sydney"));
        System.out.println("Your kid's birthdate, Sydney Time = " + dobSydney.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dobHere = dobSydney.withZoneSameInstant(ZoneId.systemDefault());
        System.out.println("Your kid's birthdate, here Time = " + dobHere.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime firstOfMonth = ZonedDateTime.now()
                        .with(TemporalAdjusters.firstDayOfMonth());
        System.out.printf("First of next Month = %tD %n", firstOfMonth );

        System.out.println("-".repeat(50));

        Period timePast = Period.between(LocalDate.EPOCH,dob.toLocalDate());
        System.out.println(timePast);

        Duration timeSince = Duration.between(Instant.EPOCH,dob.toInstant(ZoneOffset.UTC));
        System.out.println(timeSince);

        System.out.println("-".repeat(50));

        LocalDateTime dob2 = dob.plusYears(2).plusMonths(4)
                .plusDays(4)
                .plusHours(7)
                .plusMinutes(14)
                .plusSeconds(37);

        System.out.println("Your  2nd kid's birthdate, here Time = " + dob2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        Period timePast2 = Period.between(LocalDate.EPOCH,dob2.toLocalDate());
        System.out.println(timePast2);

        Duration timeSince2 = Duration.between(Instant.EPOCH,dob2.toInstant(ZoneOffset.UTC));
        System.out.println(timeSince2);


        System.out.println("-".repeat(50));

        for(ChronoUnit u : ChronoUnit.values())
        {
            if(u.isSupportedBy(LocalDate.EPOCH))
            {
                long val = u.between(LocalDate.EPOCH,dob2.toLocalDate());
                System.out.println(u + " past = " + val);
            } else
            {
                System.out.println("-- Not supported: " + u);
            }
        }

        System.out.println("-".repeat(50));

        System.out.println("-".repeat(50));

        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.EPOCH,ZoneOffset.UTC);

        for(ChronoUnit u : ChronoUnit.values())
        {

            if(u.isSupportedBy(ldt))
            {
                long val = u.between(ldt,dob2);
                System.out.println( u + " past = " + val);
            }
            else
            {
                System.out.println("-- Not supported: " + u);
            }
        }






    }


}
