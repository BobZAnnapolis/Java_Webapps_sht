package syncd2;

//Fig. 23.7: SharedArrayTest.java
// Executing two Runnables to add elements to a shared SimpleArray.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedTreesetTest {
	public static void main(String[] args) {
		// construct the shared object
		SimpleTreeset sharedSimpleArray = new SimpleTreeset(Integer.parseInt(args[0]));

		// create tasks to write to the shared SimpleArray
		TreesetWriter writer1 = new TreesetWriter(1, sharedSimpleArray);
		TreesetWriter writer2 = new TreesetWriter(5, sharedSimpleArray);
		TreesetWriter writer3 = new TreesetWriter(9, sharedSimpleArray);

		// execute the tasks with an ExecutorService
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(writer1);
		executorService.execute(writer2);
		executorService.execute(writer3);

		executorService.shutdown();

		try {
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded = executorService.awaitTermination(1,
					TimeUnit.MINUTES);

			if (tasksEnded) {
				System.out.printf("%nContents of SimpleArray:%n");
				System.out.println(sharedSimpleArray); // print contents
			} else
				System.out
						.println("Timed out while waiting for tasks to finish.");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	} // end main
} // end class SharedArrayTest
