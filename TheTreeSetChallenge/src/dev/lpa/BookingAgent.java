package dev.lpa;

public class BookingAgent {

    public BookingAgent(Theatre t,char row,int number)
    {
        if( row<65 || row >90)
        {
            System.out.println("Invalid row");
            return ;

        }
        if(number>t.seatCount||number<0)
        {
            System.out.println("Invalid Number");
//            return ;
        }

        Theatre.Seat s = new Theatre.Seat("%c00%d".formatted(row,number));
        t.seatSet.ceiling(s).setStatus(true);


    }

    public BookingAgent(Theatre t,String rows,int seatCount)
    {
        Theatre.booking(t,rows,seatCount);

    }
}
