public class TeenNumberChecker {
    public static boolean hasTeen(int one,int two, int three)
    {
        if((13<=one&&one<=19)||(13<=two&&two<=19)||(13<=three&&three<=19))
        {
            return true;

        }
        else
            return false;

    }
}