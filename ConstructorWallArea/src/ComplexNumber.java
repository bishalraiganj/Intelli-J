public class ComplexNumber{

     private double real;
     private double imaginary;
     public ComplexNumber(double real,double imaginary)
     {
         this.real=real;
         this.imaginary=imaginary;

     }
     public double getImaginary()
     {

         return imaginary;
     }
     public double getReal()
     {
         return real;
     }
public void add(double real,double imaginary)
{
   this.real= this.real+real;
  this.imaginary=  this.imaginary+imaginary;


}
    public void add(ComplexNumber a)
    {   this.real= this.real+a.real;
       this.imaginary=this.imaginary+a.imaginary;
    }
    public void subtract(double real ,double imaginary)
    {
        this.real=this.real-real;
       this.imaginary=this.imaginary-imaginary;

    }
    public void subtract(ComplexNumber a1)
    {
        this.real=this.real-a1.real;
        this.imaginary=this.imaginary-a1.imaginary;

    }
}
