public class PaintJobWithPassingArgumentsToMethod {
    public static void main(String[] args)
    {
        System.out.println(getBucketCount(3.4,2.1,1.5,2));
    }
    public static int getBucketCount(double width,double height,double areaPerBucket,int extraBuckets)
    {

          double nbc=(width*height)/areaPerBucket;
          int nbc2=(int) nbc;

          if(nbc-nbc2>0)
          {

              ++nbc2;
          }



        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0)
        {
            return -1;
        }
        if (extraBuckets == 0)
        {
            return getBucketCount(width, height, areaPerBucket);

        }
        if (nbc2==extraBuckets)
        {

            return nbc2;

        }
        else if(nbc2>extraBuckets)
        {
            return nbc2-extraBuckets;
        }

            return 0;

    }
public static int getBucketCount(double width,double height,double areaPerBucket)
{
    if(width<=0||height<=0||areaPerBucket<=0)
    {
        return -1;
    }
    double   d= ((width*height)/areaPerBucket);
    int   id=(int) d;
    //       System.out.println(d+" "+id+" "+(d-id)+" "+(++id));
    if(d-id>0)
    {
        return ++id;
    }
    return id;

}
public static int getBucketCount(double area, double areaPerBucket)
{

    if(area<=0||areaPerBucket<=0)
    {

        return -1;
    }

    double   d= (area/areaPerBucket);
    int   id=(int) d;
    //       System.out.println(d+" "+id+" "+(d-id)+" "+(++id));
    if(d-id>0)
    {
        return ++id;
    }
    return id;
}



}
