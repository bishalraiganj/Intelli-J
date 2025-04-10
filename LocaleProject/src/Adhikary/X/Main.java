package Adhikary.X;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String... args)
    {

        Locale.setDefault(Locale.US);
        System.out.println("Default Local = " + Locale.getDefault());

        Locale en = new Locale("en");
        Locale enAu = new Locale("en","AU");
        Locale enCA = new Locale("en","CA");

        Locale enIn = new Locale.Builder().setLanguage("en").setRegion("CA").build();
        Locale enNZ = new Locale.Builder().setLanguage("en").setRegion("NZ").build();

        System.out.println("-".repeat(50));

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

        for(Locale locale : List.of(Locale.getDefault(),Locale.US,en,enAu,enCA,Locale.UK,enNZ,enIn))
        {
                System.out.println(locale.getDisplayName() + "= " + LocalDateTime.now().format(dtf.withLocale(locale)));

        }

    }
}
