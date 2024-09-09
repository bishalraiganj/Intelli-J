package dev.lpa;

import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

public class Theatre {

    static class Seat implements Comparable<Seat>{

        String name;
        Seat(String name)
        {
            this.name = name;
        }

        @Override
        public int compareTo(Seat o)
        {
            int rowCompare = "%c".formatted( name.charAt(0)).compareTo("%c".formatted(o.name.charAt(0)));
            if(rowCompare ==0)
            {
                return

            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Seat seat = (Seat) o;
            return name.equals(seat.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }


        @Override
        public String toString()
        {
            return name;

        }

    }

    public String name;
    public int seatCount;
    public NavigableSet<Seat> seatSet = new TreeSet<>();

    public Theatre(String name, int numOfRows,int totalSeats)
    {   if(numOfRows<=26&&numOfRows>=0) {
        this.name = name;
        this.seatCount = totalSeats/numOfRows;
        for (int i = 1,j=65,d=j; i <= totalSeats; i++) {
                if(i>1&&i%seatCount==0)
                {
                    d=j++;
                }

                seatSet.add(new Seat("%c00%d".formatted((char)d,i)));
                d=j;



        }

    }
    }

    


}
