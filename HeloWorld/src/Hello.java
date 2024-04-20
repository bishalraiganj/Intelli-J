public class Hello {

    public static void main(String[] args)
    {
        System.out.println("Hello world");
       boolean  isAlien= false;
       if (isAlien == false)
       {
           System.out.println("It is not an Alien");
           System.out.println("And I am Scared of Aliens");
       }

       int topScore = 100;
       if ( topScore >= 100)
       {
           System.out.println("You got the High Score !");
       }
       String makeOfCar = "Volkswagen";
       boolean isDomestic = makeOfCar == "Volkswagen" ?false : true ;
       if (isDomestic) {
           System.out.println("This car is domestic to our country ");
    }
    }
}
