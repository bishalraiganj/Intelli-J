public class Printer {

    private int tonerLevel=10;
    private int pagesPrinted;
    private boolean duplex=true;
public Printer(int tonerLevel,boolean duplex)
{
    this.tonerLevel=((tonerLevel>0&&tonerLevel<=100)?tonerLevel:-1);
    this.duplex=duplex;

}
   public int addToner(int tonerAmount)
   {   if((tonerLevel+tonerAmount)>100||(tonerLevel+tonerAmount)<0)
   {
       return -1;
   }
     return   tonerLevel+=tonerAmount;
   }
public int printPages (int pagesToPrint)
    {   int jobPages=((duplex)?(pagesToPrint/2)+(pagesToPrint%2):pagesToPrint);
        pagesPrinted+=jobPages;
        return jobPages;
    }

public int getPagesPrinted()
{

    return pagesPrinted;
}
}
