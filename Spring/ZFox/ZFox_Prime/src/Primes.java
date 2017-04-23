//import java.util.Iterator;
import java.util.TreeSet;

//
// Primes
//
// local object to handle all prime number-related activities
//
public class Primes {

	private TreeSet<Integer> setPrimes;
	//
	// constructor
	//
	// called from the test program[s] to create our initial set of prime numbers to work with
	//
	public Primes() {
		System.out.println("Creating a Primes object.");
	}
	//
	// createPrimes
	//
	// utility function, 
	// takes an integer parameter
	// generates input_num of prime numbers and saves them in a treeset
	//
	// there's probably a bunch of 3rd party libs that handle this 
	// but I wanted to see the code
	//
	public void createPrimes(Integer p_numToCreate) 
	{
		System.out.println("...createPrimes called to create " + p_numToCreate + " prime numbers.");
		// create our initial set and add the 1st entry
		setPrimes = new TreeSet<Integer>();
		setPrimes.add(2);
		//
		// the following algorithm is taken from a web search
		// i found the same algorithm in a few different places
		// so decided to go with it
		//
		int status = 1, num = 3;
		//
		// outer loop is used to keep track of the number to create
		// inner loop does the funky math thing to find a prime and save it
		//
		for (int count = 2; count <= p_numToCreate; ) {
			for ( int j = 2; j <= Math.sqrt(num); j++) 
			{
				if ((num % j) == 0)
				{
					status = 0;
					break;
				}
			} //endFor funky prime math logic
			if (status != 0)
			{
				System.out.println("\tNext generated prime is : " + num);
				setPrimes.add(num);
				count++;
			}
			status = 1;
			num++;
			
		} // endFor p_numToCreate
	}
	//
	// printPrimes
	//
	// print our list of primes
	//
	public void printPrimes() 
	{
		System.out.println("...printPrimes called to display prime values.");
		System.out.println("Generated Prime numbers are : ");
		for (Integer prime : setPrimes) 
		{
			System.out.print(prime + " ");
		}
		System.out.println();
	}
	//
	// isPrime
	//
	// web search fcn utility to validate a prime number
	//
	public boolean isPrime(long p_primeCandidate)
	{
		if (p_primeCandidate < 2) return false;
		for (int i = 2; i <= Math.sqrt(p_primeCandidate); i++)
		{
			if ((p_primeCandidate % i) == 0) return false;
		}
		return true;		
	}
}
