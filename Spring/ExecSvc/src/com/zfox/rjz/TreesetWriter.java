package com.zfox.rjz;
//
// just a simple wrapper thread class that 
// calls our main object's methods looping
// until we generated all the primes
//
import java.lang.Runnable;
//
public class TreesetWriter implements Runnable {
	// declare as final cuz only want 1
	private final SimpleTreeset sharedTreeset;

	// save our main class
	public TreesetWriter(SimpleTreeset array) {
		sharedTreeset = array;
	}
	//
	// keep pumping numbers into our thread[s] and
	// looping until we've collected the number asked
	// for by the user - probably a better way to do 
	// this too
	//
	public synchronized void run() {
		int i = 1;
		while (! sharedTreeset.isSetFull()) {
			System.out.printf("\t\t\t%s calling add(%2d).%n", Thread
					.currentThread().getName(), i);
			sharedTreeset.add(i); // add an element to the shared array
			i++;
		}
	}
}
