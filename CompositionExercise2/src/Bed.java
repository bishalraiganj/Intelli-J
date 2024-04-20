public class Bed {

    private String style;
    private int pillows;
    private int height;
    private int sheets;
    private int quilt;
    public Bed(String style,int pillows,int height,int sheets
    ,int quilt)
    {
      this.style=style;
      this.height=height;
      this.pillows=pillows;
      this.sheets=sheets;
      this.quilt=quilt;
    }
    public void make()
    {
        System.out.println("Bed is being made");
    }
    public String getStyle()
    {

        return style;
    }
    public int getHeight()
    {
        return height;

    }
    public int getPillows()
    {

        return pillows;
    }
    public int getSheets()
    {

        return sheets;
    }
    public  int  quilt()
    {
        return quilt;
    }


}
