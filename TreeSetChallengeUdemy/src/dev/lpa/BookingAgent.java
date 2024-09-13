package dev.lpa;

public class BookingAgent {

    public static void main(String... args)
    {
            int rows =10;
            int totalSeats = 100;
            Theatre rodgersNYC = new Theatre("Richard Rogers",rows,totalSeats);
            rodgersNYC.printSeatMap();
            bookSeat(rodgersNYC,'A',3);
        bookSeat(rodgersNYC,'A',3);
        bookSeat(rodgersNYC,'B',1);
        bookSeat(rodgersNYC,'B',11);
        bookSeat(rodgersNYC,'M',1);

        bookSeat(rodgersNYC,'E',9);
        bookSeat(rodgersNYC,'F',8);
        bookSeat(rodgersNYC,'G',7);

        bookSeat(rodgersNYC,7,'E','I',3,10);






    }

    public static void bookSeat(Theatre theatre,char row,int seatNo)
    {
        String seat = theatre.reserveSeat(row,seatNo);
        if(seat !=null)
        {
            System.out.println("Congratulations! Your reserved seat is "+seat);
            theatre.printSeatMap();

        }
        else
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
    }

    public static void bookSeats(Theatre theatre,int tickets,char minRow,int minSeat,int maxSeat)
    {
        bookSeat(theatre,tickets,minRow,minRow,minSeat,maxSeat);

    }
    public static void bookSeat(Theatre theatre,int tickets,char minRow,char maxRow,
                                 int minSeat,int maxSeat)
    {
        var seats =theatre.reserveSeats(tickets,minRow,maxRow,minSeat,maxSeat);
        if(seats!=null)
        {
            System.out.println("Congratulations! Your reserved seats are "+seats);
            theatre.printSeatMap();
        }
        else {
            System.out.println("Sorry! No matching contiguous seats in row :" + minRow
            + " - "+maxRow);
        }



    }


}
