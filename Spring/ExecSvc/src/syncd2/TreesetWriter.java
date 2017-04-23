package syncd2;

import java.lang.Runnable;

public class TreesetWriter implements Runnable {
	private final SimpleTreeset sharedSimpleArray;
	private final int startValue;

	public TreesetWriter(int value, SimpleTreeset array) {
		startValue = value;
		sharedSimpleArray = array;
	}

	public synchronized void run() {
//		for (int i = startValue; i <= startValue + 3; i++) {
		while (! sharedSimpleArray.isArrayFull()) {
			System.out.printf("%s calling add(%2d).%n", Thread
					.currentThread().getName(), (sharedSimpleArray.getIndex()+1));
			sharedSimpleArray.add((sharedSimpleArray.getIndex()+1)); // add an element to the shared array
			//i++;
		}
	}
} // end class ArrayWriter
