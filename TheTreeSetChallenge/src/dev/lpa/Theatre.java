package dev.lpa;

import java.util.*;

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
                return  Integer.compare(Integer.parseInt(name.substring(3)),Integer.parseInt(o.name.substring(3)));

            }

            return rowCompare;
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
            return String.valueOf(name.charAt(0)).hashCode();
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

    public void printSeatMap()
    {

        Set<Seat> seatHashSet = new HashSet<>(seatSet);
        int i = 65;

        for(Seat s: seatHashSet)
        {
            for(int c=65;c<=90;c++)
            {
                if(String.valueOf(s.name.charAt(0)).hashCode()==String.valueOf((char) c).hashCode())
                {
                  if(i!=c)
                  System.out.println();
                  System.out.print(s+" ");
                  i=c;
                  break;
                }
            }

//            System.out.print(s+"\n");



        }


    }


}
