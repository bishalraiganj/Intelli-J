public class Main {


    public static void main(String[] args)
    {
  Printer printer=new Printer(5,false);
  System.out.println(printer.addToner(5));
   System.out.println(printer.printPages(7));
   System.out.println("Current Count of Printed Pages :"+printer.getPagesPrinted());
   printer.printPages(9);
   System.out.println("Current Count of pages Printed :"+printer.getPagesPrinted());

    }
}
