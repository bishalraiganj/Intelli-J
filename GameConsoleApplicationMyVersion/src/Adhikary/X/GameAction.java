package Adhikary.X;

import java.util.function.Predicate;

public class GameAction {
    private final char key;

    private final String prompt;

    private final Predicate<Integer> action;

    public GameAction(char key,String prompt,Predicate<Integer> action)
    {
        this.key = key;
        this.prompt = prompt;
        this.action = action;
    }



}
