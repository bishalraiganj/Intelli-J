public class CanPackFlourExerciseInUdemy {
    public static void main(String[] args)
    {
   System.out.println(canPack(5,2,12));
    }
    public static boolean canPack(int bigCount,int smallCount,int goal) {

        if(bigCount<0||smallCount<0)
        {
            return false;
        }
        if (bigCount * 5 + smallCount * 1 >= goal)
        {
            int i, j = 0,i2,j2=0;
            for (i = 0;i<=bigCount;i++ )
            {
                j=i*5;
                   for(i2=0;i2<=smallCount;i2++)
                   { j2=i2;
                      if(j+j2==goal)
                      {
                          return true;
                      }


                   }
            }

        }
        return false;
    }
}
