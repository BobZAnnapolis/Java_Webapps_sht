package net.javavideotutorials.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
	exceptions

 	Runtime exceptions
 	==================
 	- unchecked exceptions
 	- e.g. OutOfMemory
 	- we don't have code to handle these, they occur 'unexpectedly'
 	
 	Exceptions
 	==========
 	- checked exceptions
 	- we're executing code that have 'expected' possible exceptions
 	- e.g., FileNotFound
 	- we can write code to handle these, e.g. - try-catch

*/
public class Runnable {

	public static void main(String[] p_args) {
		
		String msg = "\n\tVideo 10 - Handling Exceptions with try-catch blocks\n";
		System.out.println(msg);
		String strFN = "/Users/BobZawislak/Documents/_scans/test.rtf";

		try
		{
			FileReader fr = new FileReader(new File( strFN));
			System.out.println(strFN + " file was read successfully.");
			fr.close();
			//
			// other code
			//
		}
		catch (FileNotFoundException ex)
		{
			// catch will handle the exception[s] thrown by classes inside the try code area
			// look at the class hierarchies to determine what exceptions will be thrown
			System.out.println("Error: FileNotFoundException: new FileReader call failed for file : " + strFN);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: IOException: FileReader.close() on file : " + strFN);
		}
		
		System.out.println("\n\t*** Done ***");
	}
}
