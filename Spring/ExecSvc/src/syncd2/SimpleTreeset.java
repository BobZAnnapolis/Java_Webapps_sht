package syncd2;

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
		System.out.printf("%s add(%2d) writeIndex(%2d).%n", Thread
				.currentThread().getName(), value, writeIndex);
		int position = writeIndex; // store the write index

		try {
			if (! isArrayFull()) {
				// in real applications, you shouldn't sleep while holding a lock
				array[position] = value;
				System.out.printf("%s wrote %2d to element %d.%n", Thread
						.currentThread().getName(), value, writeIndex);

				++writeIndex; // increment index of element to be written next
				System.out.printf("Next write index: %d%n", writeIndex);
				Thread.sleep(generator.nextInt(1000)); // for demo only				
			}
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		// put value in the appropriate element
//		array[position] = value;
//		System.out.printf("%s wrote %2d to element %d.%n", Thread
//				.currentThread().getName(), value, position);
//
//		++writeIndex; // increment index of element to be written next
//		System.out.printf("Next write index: %d%n", writeIndex);
	}

	// used for outputting the contents of the shared integer array
	public synchronized String toString() {
		return Arrays.toString(array);
	}
} // end class SimpleArray