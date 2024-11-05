package Adhikary.X;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String... args)
    {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of Permutations to create from alphabets , letters arent repeated\n");
        int length = s.nextInt();
        s.nextLine();


        List<String>  previousString = new ArrayList<>();
        List<String> newString = new ArrayList<>();


        while(previousString.get(0).length()<=length)
        {
            for (String str : previousString)
            {



            }

        }




    }


    public static List<String>  removeString(String s)
    {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        List<String>  afterString  = new ArrayList<>();
        for(char  c: alphabets.toCharArray())
        {
            afterString.add(String.valueOf(c));
        }
        for(char c1: s.toCharArray())
        {
            afterString.remove(String.valueOf(c1));
        }
        return afterString;
    }




}
