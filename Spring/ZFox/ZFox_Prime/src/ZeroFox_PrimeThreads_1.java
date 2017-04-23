import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * PrimeThreads_1
 * 
 * This is a quick and dirty version just to demo threads
 * and test out the prime number generator as well as the
 * isPrime fcn.
 */

public class ZeroFox_PrimeThreads_1 extends Thread
{
	//
	// parameter validation vars
	//
	private static final Integer ARG_COUNT = 1;
	private static final Integer MIN_VALUE = 2;
	private static final String BAD_INVOCATION = "\nTry again.\nThe program "
				+ "requires a single integer value >= 2 to be provided, "
				+ "please try again.";
	private static final String SUMMARY = "\nThreads have finished."
			+ "\nThread 1 created %d prime numbers."
			+ "\nThread 2 created %d prime numbers."
			+ "\nThread 3 created %d prime numbers."
			+ "\nNumber of primes asked for is: %d"
			+ "\nNumber of primes generated is: %d";
	//
	// synchronized treeset to help make sure only unique primes are saved
	// individual thread identifier
	// number of prime number the user wishes to calculate
	// thread identifiers
	//
	private static Set<Integer>	m_set;
	private int 				m_threadID;
	private static int 			m_numPrimes;
	private static int 			m_thread_1 = 0;
	private static int 			m_thread_2 = 0;
	private static int 			m_thread_3 = 0;
	//
	// constructor
	//
	public ZeroFox_PrimeThreads_1(int p_threadID, Set<Integer> p_set, int p_numPrimes)
	{
		m_threadID = p_threadID;
		m_set = p_set;
		m_numPrimes = p_numPrimes;
	}
	/*
	 * this is a thread's main function, run(), does bulk of work
	 * 
	 * in this quick & dirty example, run() keeps incrementally generating 
	 * a number and checking to see if it is a prime; if not, it generates
	 * the next numberto check; if it is, it will attempt to add it into
	 * a synchronized TreeSet - because it has been defined as synchronized, 
	 * Java will satisfy the requirement and ensure that only unique prime 
	 * numbers will be added; when a successful add occurs, display 
	 * a msg displaying the prime value just added, which thread did it
	 * and inc that threadID's counter
	 */
	public void run() 
	{
		int i = 2;  // start with 1st prime number
		while (m_set.size() != m_numPrimes) 
		{
			// call util function to see if current val is a prime
//			if ((ZeroFox_PrimeThreads_1.isPrime(i))) 
			if (isPrime(i)) 
			{
				// if so, attempt to add to a treeset - will only succeed if 
				// input parm val doesn't exist
				if (m_set.add(i)) 
				{
					// increment appropriate thread counter, update 
					// threadID counter
					System.out.println("\tThread " + m_threadID 
									+ " generated prime : " + i);
					if (m_threadID == 1) 
					{
						m_thread_1++;
					} else
					{
						if (m_threadID == 2) 
						{
							m_thread_2++;
						}
						else 
						{
							m_thread_3++;
						}
					}
				} // endif prime has been successfully added
			} //endif successful prime has been found
			
			// keep incrementing counter looking for next prime value
			i++;

		} // end while(more prime numbers to fine) 
	} // end run()
	/*
	 * another 'generic' Google search found function that does the funky 
	 * math to determine and validate the next input value as a valid prime
	 */
	static boolean isPrime(long n) {
		if (n <= 1)
			return false;
		double limit = Math.sqrt(n);
		for (long i = 2; i <= limit; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	/*
	 * main program invocation
	 *
	 *  validate input parm
	 *  create a TreeSet collection
	 *  synchronize it to help the threads in storing unique Prime numbers
	 * 	create & start 'x'  threads
	 * 	call the Java join method to help asynchronize threads
	 * 	when they're done, report some stats
	 */
	public static void main(String[] args) 
	{
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
		int numPrimesAskedFor = 0;
		try 
		{
			numPrimesAskedFor = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		if (numPrimesAskedFor < MIN_VALUE) 
		{
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		//
		// once we're here, we have a valid program invocation
		//
		// create and then synchronize a TreeSet to help in storing 
		//				unique Prime numbers
		// create & start 'x'  threads
		// call the Java join method to allow threads to behave somewhat 
		//				asynchronously
		// when they're done, report some stats
		//
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		Set set = Collections.synchronizedSet(treeSet);
		Thread th1 = new ZeroFox_PrimeThreads_1(1, set, numPrimesAskedFor);
		Thread th2 = new ZeroFox_PrimeThreads_1(2, set, numPrimesAskedFor);
		Thread th3 = new ZeroFox_PrimeThreads_1(3, set, numPrimesAskedFor);
		th1.start();
		th2.start();
		th3.start();
		//
		// when I didn't have this group join section in, the below "summary 
		// reporting" section would not print, i'd have to spend some more
		// time figuring out why, has "something" to do when / how the threads
		// execute and stop [possibly]
		//
		try {
			th1.join();
		} catch (InterruptedException ie) {
		}
		try {
			th2.join();
		} catch (InterruptedException ie) {
		}
		try {
			th3.join();
		} catch (InterruptedException ie) {
		}
		//
		// print out some metrics
		//
		System.out.format(SUMMARY, m_thread_1, m_thread_2, m_thread_3
						 ,numPrimesAskedFor
						 ,(m_thread_1 + m_thread_2 + m_thread_3)
						 );
		//
		// print out the treeset, i.e., sorted prime numbers
		//
		System.out.print("\n\ntreeSet Prime Number elements : ");
		for (Integer i : treeSet) {
			System.out.print(i + "   ");
		}
		System.out.println();
	}
}
//
// Summary : In closing, this demonstrates splitting up a task into separate
// threads but this has issues I am uncomfortable with and also I don't think
// is exactly what the assignment was. There isn't any real messaging going
// on here, unless you take a huge leap of faith and consider the separate
// threads to be receiving "implied" messages to create a prime number each
// time they execute.
//
// The main issue I have with this is that when run, the output may look 
// like it divides the calculations into separate threads but my gut tells 
// me I'm just lucky. With what i remember from past multi-threading apps,
// I think there could be more synchronized structures and/or methods.
// And/or inside run(), maybe add "blocking" around the code sections that 
// create, validate the prime numbers and the set.add() calls, something
// that only allows one thread at a time to complete that entire block.
//
// i'm pretty sure if a code analyzer was run against this program i would
// see some issues with the threads, not necessarily memory leaks but
// possibly executing more than they should be. Lots of options to get
// this to work better I think, make run() synchronized and add in
// wait() and notify() calls in correct places. This works ok for this
// kind of homework assignment but for more memory and computing
// intensive tasks, it would fall apart.
//