package syncd3;
//
// just a simple wrapper class that calls the synchronized objects
// 
//
import java.lang.Runnable;

public class TreesetWriter implements Runnable {
	private final SimpleTreeset sharedTreeset;

	public TreesetWriter(SimpleTreeset array) {
		sharedTreeset = array;
	}

	public void run() {
		int i = 2;
		while (! sharedTreeset.isArrayFull()) {
			System.out.printf("\t\t\t%s calling add(%2d).%n", Thread
					.currentThread().getName(), (sharedTreeset.getIndex()+1));
			sharedTreeset.add(i); // add an element to the shared array
			i++;
		}
	}
}
