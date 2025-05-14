package Adhikary.X;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

	public static void main(String... args)
	{
 		Path dataFile = Path.of("data.dat");
		 writeData(dataFile);













	}

	private static void writeData(Path dataFile)
	{
		try(DataOutputStream dataOutputStream= new DataOutputStream(
										new BufferedOutputStream(
												new FileOutputStream(dataFile.toFile())
										)))

		{

			int myInt = 17;
			long myLong = 100_000_000_000_000L;
			boolean myBoolean = true;
			char myChar = 'Z';
			float myFloat = 77.7f;
			double myDouble = 98.6;
			String myString = "I am Bishal Adhikary";

			long position = 0;

			dataOutputStream.writeInt(myInt);
			System.out.println("writeInt() writes : " + (dataOutputStream.size()-position)  + " bytes");
			position = dataOutputStream.size();

			dataOutputStream.writeLong(myLong);
			System.out.println("writeLong() writes : " + (dataOutputStream.size()-position + " bytes"));
			position = dataOutputStream.size();

			dataOutputStream.writeBoolean(myBoolean);
			System.out.println("writeBoolean() writes : " + (dataOutputStream.size()-position) + " bytes");
			position = dataOutputStream.size();

			dataOutputStream.writeChar(myChar);
			System.out.println("writeChar() writes : " + (dataOutputStream.size()-position)  + " bytes");
			position = dataOutputStream.size();

			dataOutputStream.writeFloat(myFloat);
			System.out.println("writeFloat() writes : " + (dataOutputStream.size()- position) + " bytes");
			position = dataOutputStream.size();

			dataOutputStream.writeDouble(myDouble);
			System.out.println("writeDouble() writes: " + (dataOutputStream.size()-position) + " bytes");
			position = dataOutputStream.size();

			dataOutputStream.writeUTF(myString);
			System.out.println("writeUTF() writes: " + (dataOutputStream.size()-position) + " bytes");
			position = dataOutputStream.size();







		}catch(IOException e)
		{
			throw new RuntimeException(e);
		}





	}


}
