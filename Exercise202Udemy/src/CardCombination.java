import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record CardCombination(List<Hand> cList,Hand... combinations)
{
    public CardCombination(Hand... combinations)
    {
        this(new ArrayList<>(Arrays.asList(combinations)),combinations);




    }

}
