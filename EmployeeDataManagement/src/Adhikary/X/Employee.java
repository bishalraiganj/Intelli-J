package Adhikary.X;

public record Employee(int id, double salary,String firstName, String lastName) {

	@Override
	public String toString()
	{
		return "Employee id: "+ id +  " Salary: " + salary + " FirstName: " +firstName + " lastName: " + lastName;
	}


}
