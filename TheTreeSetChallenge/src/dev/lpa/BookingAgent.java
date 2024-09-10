package dev.lpa;

public class BookingAgent {

    public BookingAgent(Theatre t,char row,int number)
    {
        if( row<65 || row >90)
        {
            System.out.println("Invalid row");

        }
        if(number>t.seatSet.last().name.substring(3))



    }
}
