package Adhikary.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args)
    {


        System.out.println(Arrays.toString(sortColors(new int[]{0, 1, 2,1,2,2,0,1,0,1,1,1,0})));


    }

    public static int[] sortColors(int[] nums)
    {
        List<Integer> zero = new ArrayList<>();
        List<Integer> one =  new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        int zeroIndexCounter=0;
        int oneIndexCounter=0;
        int twoIndexCounter=0;

        for(Integer i:nums)
        {
            if(i==0)
            {
                zero.add(i);
                zeroIndexCounter++;
            }
            else if(i==1)
            {
                one.add(i);
                oneIndexCounter++;
            }
            else
            {
                two.add(i);
                twoIndexCounter++;
            }
        }

        for(int i=0;i<zero.size();i++)
        {
            nums[i]=zero.get(i);
        }
        for(int i=zero.size();i<zeroIndexCounter+oneIndexCounter;i++)
        {
            nums[i]=1;
        }
        for(int i=zeroIndexCounter+oneIndexCounter;i<zeroIndexCounter+oneIndexCounter+twoIndexCounter;i++)
        {
            nums[i]=2;
        }

        return nums;


    }


}
