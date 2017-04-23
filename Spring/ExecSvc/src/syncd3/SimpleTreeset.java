package syncd3;

import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleTreeset {
	private static final SecureRandom generator = new SecureRandom();
	private final int[] array; // the shared integer array
	private int writeIndex = 0; // index of next element to be written

	// construct a SimpleArray of a given size
	public SimpleTreeset(int size) {
		array = new int[size];
	}

	public synchronized int getIndex() {
		return writeIndex;
	}
	
	public synchronized boolean isArrayFull() {
		boolean retVal = false;
		if (writeIndex == array.length) {
			retVal = true;
		}
		return retVal;
	}
	
	// add a value to the shared array
	public synchronized void add(int value) {
//		System.out.printf("%s add(%2d) writeIndex(%2d).%n", Thread
//				.currentThread().getName(), value, writeIndex);
		int position = writeIndex; // store the write index

		try {
			if (! isArrayFull()) {
				// in real applications, you shouldn't sleep while holding a lock
				if (isPrime(value)) {
					array[position] = value;
					System.out.printf("%s ADDED %2d to element %d.%n", Thread
							.currentThread().getName(), value, writeIndex);

					++writeIndex; // increment index of element to be written next
					System.out.printf("\t\t\tNext write index: %d%n", writeIndex);
					Thread.sleep(generator.nextInt(1000)); // for demo only				
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
		return Arrays.toString(array);
	}
}