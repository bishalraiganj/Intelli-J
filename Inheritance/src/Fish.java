public class Fish extends Animal {

private int gills;
private int fins;
  public Fish(int gills,int fins)
  {
      super("Fish","Small",1);
      this.gills=gills;
      this.fins=fins;
  }

    public Fish(String type, double weight, int gills,int fins) {
        super(type, "Small", weight);
        this.gills = gills;
        this.fins=fins;
    }
    private void moveMuscles()
    {
        System.out.print("Muscles moving");
    }
    private void moveBackFin()
    {
        System.out.print("Backfin Moving");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscles();
        if(speed == "fast")
        {
            moveBackFin();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }
}
