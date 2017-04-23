package exec1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TaskExecutor {
	public static void main(String[] args) {
		// create and name each runnable
		PrintTask ptask1 = new PrintTask("PrintTask1");
//		PrintTask ptask2 = new PrintTask("PrintTask2");
//		PrintTask ptask3 = new PrintTask("PrintTask3");
		Genr8PrimeTask gtask1 = new Genr8PrimeTask("Genr8PrimeTask1");
		Genr8PrimeTask gtask2 = new Genr8PrimeTask("Genr8PrimeTask2");

		System.out.println("Starting Executor");
		// create ExecutorService to manage threads
		ExecutorService executorService = Executors.newCachedThreadPool();

		// start three Tasks
		executorService.execute(ptask1); // start task1
		executorService.execute(gtask1); // start task2
		executorService.execute(gtask2); // start task3

		// shut down ExecutorService--it decides when to shut down threads
		executorService.shutdown();

		System.out.printf("Tasks started, main ends.%n%n");
	}
} // end class TaskExecutor
