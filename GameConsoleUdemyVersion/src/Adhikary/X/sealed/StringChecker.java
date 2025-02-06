package Adhikary.X.sealed;

import java.util.function.Predicate;

public  final class StringChecker implements SealedInterface{
    @Override
    public boolean testData(Predicate<String> p, String... args)
    {
        return false;
    }
}
