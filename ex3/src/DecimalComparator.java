public class DecimalComparator {
    public static void main(String[] args)
    {

        System.out.println(areEqualByThreeDecimalPlaces(+3.1756,+3.175));

    }

        public static  boolean  areEqualByThreeDecimalPlaces( double    numOne,double numTwo  )
        {
            if ((int) numOne==(int) numTwo)
            {
                int a1=(int) numOne;
                int a2=(int)numTwo;
                int a3=(int)( numOne*1000);
                int a4=(int)(numTwo*1000);
                System.out.println(a1+" "+a2+" "+a3+" "+a4+" "+(int) 175.00);
                if((int)((numOne -(int ) numOne)*1000)==(int)((numTwo -(int)numTwo)*1000))
                {return true;
                }
                else {
                    return false;
                }
            }
            else
                return false;

}
}