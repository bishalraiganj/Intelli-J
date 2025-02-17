import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for(char c : "BINGO".toCharArray()) {
            for (int i = start; i < start + 15; i++)
            {
                bingoPool.add("" + c + i );
            }
            start+=15;
        }

        bingoPool.forEach(System.out::println);
    }
}
