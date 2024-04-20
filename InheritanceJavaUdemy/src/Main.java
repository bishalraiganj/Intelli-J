public class Main {

    public static void main(String[] args)
    {
        Customer customer = new Customer("Bishal+Suparna",9000,"bishalsuparna@gmail.com");
        System.out.println(customer.getName()+" "+customer.getCreditLimit()+" "+customer.getEmail());
        Customer secondObject=  new Customer();
        System.out.println(secondObject.getName()+secondObject.getCreditLimit()+secondObject.getEmail());
        Customer thirdInstance=new Customer("Bishal3","bishaladhikary@gmail.com");
        System.out.println(thirdInstance.getName()+thirdInstance.getCreditLimit()+thirdInstance.getEmail());


    }
}
