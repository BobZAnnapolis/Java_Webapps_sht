import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;


public class TestPrimes {

	private static final Integer ARG_COUNT = 1;
	private static final Integer MIN_VALUE = 2;
	private static final String BAD_INVOCATION = "\nTry again.\nThe program requires a single integer value >= 2 to be provided, please try again. ";

	
	public static void main(String[] args) {

		//
		// validate the program argument count
		//
		// requirement is 1 input parameter
		// check & handle appropriately
		//
		if (args.length == 0 || args.length > ARG_COUNT ) {
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		//
		// if we get here, we have our one parameter
		// make sure it is of the valid type, i.e., integer
		//
		int numPrimes = 0;
		try {
			numPrimes = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		if (numPrimes < MIN_VALUE) 
		{
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		//
		// if we get here, we are ready to do the work
		// the 1st thing we need is an array of primes
		// use an object to handle all prime 
		// number-related activities
		//
		Primes objPrimes = new Primes();
		objPrimes.createPrimes(numPrimes);
		objPrimes.printPrimes();
	}
}
