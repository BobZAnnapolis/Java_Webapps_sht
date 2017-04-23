import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * PrimeThreads_1
 * 
 * This is a quick and dirty version just to demo threads
 * and test out the prime number generator as well as the
 * isPrime fcn.
 * 
 * This uses the Java Thread class to demo multi-tasking.
 * 
 *  The main program creates 2 threads & starts each running.
 *  
 */

public class PrimeThreads_old extends Thread
{
	int m_threadID;
	static int m_numPrimes;
	static int m_thread_1 = 0;
	static int m_thread_2 = 0;
	static int m_thread_3 = 0;
	static Set m_set;

	public PrimeThreads_old(int p_threadID, Set p_set, int p_numPrimes) {
		m_threadID = p_threadID;
		m_set = p_set;
		m_numPrimes = p_numPrimes;
	}
	/*
	 * this is the main function which does the bulk of the work
	 * 
	 * in this quick & dirty example, we use some static vars
	 * to compare against the thread id to separate the work;
	 * the thread_id and prime number values are used to 
	 * divide the work into which thread does the checking & printing
	 */
	public void run() {
		int i = 2;  // start with 1st prime number
//		for (int i = 0; i < n; i++) {
		while (m_set.size() != m_numPrimes) {
			if ((PrimeThreads_old.isPrime(i))) {
				// attempt to add to our treeset which will only add it if it doesn't already exist
				if (m_set.add(i)) {
					// increment this thread counter
					System.out.println("\tThread " + m_threadID + " generated prime : " + i);
					if (m_threadID == 1) {
						m_thread_1++;
					} else
					{
						if (m_threadID == 2) {
							m_thread_2++;
						}
						else {
							m_thread_3++;
						}
					}
				}
			}

/*			
			
			if (m_threadID == 1) {
//				if (i < c) {
					if ((PrimeThreads.isPrime(i))) {
						// attempt to add to our treeset which will only add it if it doesn't already exist
						if (m_set.add(i)) {
							// increment this thread counter
							m_thread_1++;
							System.out.println("\tThread " + m_threadID + " generated prime : " + i);
						}
					}
//				}
			}
			if (m_threadID == 2) {
//				if (i >= c) {
					if ((PrimeThreads.isPrime(i))) {
						// attempt to add to our treeset which will only add it if it doesn't already exist
						if (m_set.add(i)) {
							// increment this thread counter
							m_thread_2++;
							System.out.println("\tThread " + m_threadID + " generated prime : " + i);
						}
					}
//				}
			}
*/
			// keep incrementing our base counter looking for next prime value
			i++;
		}
	}
	/*
	 * another 'generic' Google search found function
	 * that validates the input prime as a valid prime
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
	 * 	create 2 threads
	 * 	start the threads
	 * 	call the Java join method to allow threads to behave somewhat asynchronously
	 * 	when they're done, report some stats
	 */
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		Set set = Collections.synchronizedSet(treeSet);
		Thread th1 = new PrimeThreads_old(1, set, Integer.parseInt(args[0]));
		Thread th2 = new PrimeThreads_old(2, set, Integer.parseInt(args[0]));
		Thread th3 = new PrimeThreads_old(3, set, Integer.parseInt(args[0]));
		th1.start();
		th2.start();
		th3.start();
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

		System.out.println("\nThreads have finished");
		System.out.println("Thread 1 created " + m_thread_1 + " prime numbers ");
		System.out.println("Thread 2 created " + m_thread_2 + " prime numbers ");
		System.out.println("Thread 3 created " + m_thread_3 + " prime numbers ");
		int NumPrimes = m_thread_1 + m_thread_2 + m_thread_3;
		System.out.println(" Number of primes is: " + NumPrimes);
		
		System.out.print("\ntreeSet Prime Number elements : ");
		for (Integer i : treeSet) {
			System.out.print(i + "   ");
		}
		System.out.println();
	}
}
