package syncd3;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleTreesetTest 
{
	public static void main(String[] args) 
	{
		// construct a shared object
		SimpleTreeset sharedTreeset = new SimpleTreeset(Integer.parseInt(args[0]));

		// create tasks to write to the shared object
		TreesetWriter writer1 = new TreesetWriter(sharedTreeset);
		TreesetWriter writer2 = new TreesetWriter(sharedTreeset);
		TreesetWriter writer3 = new TreesetWriter(sharedTreeset);

		// execute the tasks with an ExecutorService
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(writer1);
		executorService.execute(writer2);
		executorService.execute(writer3);

		executorService.shutdown();

		try 
		{
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded = executorService.awaitTermination(1,TimeUnit.MINUTES);

			if (tasksEnded) 
			{
				System.out.printf("%nHere's the list of %d Prime Numbers asked for :%n", Integer.parseInt(args[0]));
				System.out.println(sharedTreeset); // print contents
			} else
			{
				System.out.println("Timed out while waiting for tasks to finish.");
			}
		} catch (InterruptedException ex) 
		{
			ex.printStackTrace();
		}
	} // end main
} // end class SharedArrayTest
