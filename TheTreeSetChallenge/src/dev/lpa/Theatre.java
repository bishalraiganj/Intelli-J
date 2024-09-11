package dev.lpa;

import java.util.*;

public class Theatre {

    static class Seat implements Comparable<Seat>{

        String name;
        private boolean status;
        Seat(String name)
        {
            this.name = name;
        }
        public boolean getStatus()
        {
            return status;
        }

        public void setStatus(boolean s)
        {
            status =s;
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

            if(status==true)

                return name+" (Reserved)";
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


        public static void booking(Theatre t,String abc,int s)
        {

            if(abc.length()>26||abc.length()==0||s>abc.length()*t.seatCount
            )
            {
                System.out.println("Invalid Arguments passed for " +
                        "one or more of the paramerers based on the conditions " +
                        "specified in the static booking method in the" +
                        "theatre class");
                return ;
            }

            int reservedSeats =0;
            for(char c:abc.toCharArray())
            {
//                String s1= String.valueOf(c);
            for(Seat seat:t.seatSet)
            {
                if(c==seat.name.charAt(0)&&seat.getStatus()==false&&
                reservedSeats<=s)
                {
                    seat.status=true;

                }



            }




            }

        }


}