package syncdtreeset;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.TreeSet;

public class SimpleTreeset {
	private static final SecureRandom generator = new SecureRandom();
	private final int[] array;  // the shared struct holding our primes
//	private int writeIndex = 0; // index of next element to be written
	private int m_numPrimes = 0; // index of next element to be written
	private TreeSet<Integer> m_treeset = new TreeSet<Integer>();

	// constructor,  a SimpleArray of a given size
	public SimpleTreeset(int size) {
		array = new int[size];
		m_numPrimes = size;
//		m_treeset.add(2);
	}

	public synchronized boolean isArrayFull() {
		boolean retVal = false;
		if (m_treeset.size() == m_numPrimes) {
			retVal = true;
		}
		return retVal;
	}
	
	// try to add our value
	public synchronized void add(int value) {
//		System.out.printf("%s add(%2d) writeIndex(%2d).%n", Thread
//				.currentThread().getName(), value, writeIndex);
//		int position = writeIndex; // store the write index

		try {
			if (! isArrayFull()) {
				// in real applications, you shouldn't sleep while holding a lock
				if (isPrime(value)) {
					if (m_treeset.add(value)) {
						System.out.printf("%s ADDED %2d to element %d.%n", Thread
								.currentThread().getName(), value, m_treeset.size());

						System.out.printf("\t\t\tNext element: %d%n", m_treeset.size());
						Thread.sleep(generator.nextInt(1000)); // for demo only
					}
					else
					{
						System.out.printf("\t\t\t%s REJECTED %2d - ALREADY EXISTS.%n", Thread
								.currentThread().getName(), value);
					}
/*					array[position] = value;
					System.out.printf("%s ADDED %2d to element %d.%n", Thread
							.currentThread().getName(), value, writeIndex);

					++writeIndex; // increment index of element to be written next
					System.out.printf("\t\t\tNext write index: %d%n", writeIndex);
					Thread.sleep(generator.nextInt(1000)); // for demo only
*/				
				}
				else
				{
					System.out.printf("\t\t\t%s REJECTED %2d - NOT A PRIME VALUE.%n", Thread
							.currentThread().getName(), value);
				}
			}
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
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
	// used for outputting the contents of the shared integer array
	public synchronized String toString() {
		String strPrimes = "";
		for (Integer val : m_treeset) {
			strPrimes += val + "  ";
		}
		return strPrimes;
	}
}