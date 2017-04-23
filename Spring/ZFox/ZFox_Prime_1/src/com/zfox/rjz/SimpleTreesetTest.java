package com.zfox.rjz;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
//
// SimpleTreesetTest
//
// quick and dirty example to demo concurrent / multi-thread programming
// to have different threads calculate a unique set of prime numbers,
// determined by command  line parameter
//
public class SimpleTreesetTest 
{
	//
	// parameter validation vars
	//
	private static final Integer ARG_COUNT = 1;
	private static final Integer MIN_VALUE = 2;
	private static final String BAD_INVOCATION = "\nTry again.\nThe program "
				+ "requires a single integer value >= 2 to be provided, "
				+ "please try again.";
	//
	public static void main(String[] args) 
	{
		//
		// validate the program argument count
		//
		// requirement is 1 input parameter
		// check & handle appropriately
		//
		if (args.length == 0 || args.length > ARG_COUNT ) {
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		//
		// if we get here, we have our one parameter
		// make sure it is of the valid type, i.e., integer
		//
		int numPrimesAskedFor = 0;
		try 
		{
			numPrimesAskedFor = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		if (numPrimesAskedFor < MIN_VALUE) 
		{
			System.out.println(BAD_INVOCATION);
			System.exit(-1);
		}
		//
		// once we're here, we have a valid program invocation
		//
		// create our shared object
		SimpleTreeset sharedTreeset = new SimpleTreeset(numPrimesAskedFor);
		//
		// create tasks/threads to handle functionality
		//
		TreesetWriter writer1 = new TreesetWriter(sharedTreeset);
		TreesetWriter writer2 = new TreesetWriter(sharedTreeset);
		TreesetWriter writer3 = new TreesetWriter(sharedTreeset);
		//
		// execute the tasks with an ExecutorService
		//
		// lots of different ways you can start threads and handle concurrent
		// functionality in Java. I had never heard of these executor
		// thingies before so decided to give them a try. Of the few initial 
		// Java concurrent methodologies I looked into, this was the first
		// one that stuck in my head.
		//
		// I also saw Queue-ing mechanisms where you could publish 'messages'
		// to a queue with different "topics" and consumers could either 
		// deq a message and see if it was for them and then do something, or,
		// part of the configuration was to actually assign consumers to 'wait'
		// on messages for a specific topic. I was thinking about trying that
		// with "generate a prime" and "ignore" messages but went this route 
		// for time constraints.
		//
		// I also saw some implementations that used "wait()" and "notify()"
		// to handle jumping around between different threads. I would like
		// to try that some day as well.
		//
		// But I went with Executors. There are different kinds of 
		// "thread pools" you can use with an executor service. This one
		// is the easiest and like all of them, lets the class determine
		// how to create the thread when you the .execute() is called
		//
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(writer1);
		executorService.execute(writer2);
		executorService.execute(writer3);

		executorService.shutdown();
		//
		// when all the threads have stopped, display some statistics
		//
		try 
		{
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded = executorService.awaitTermination(1,TimeUnit.MINUTES);

			if (tasksEnded) 
			{
				System.out.printf("%nHere's the list of %d Prime Numbers asked for :%n", numPrimesAskedFor);
				System.out.println(sharedTreeset); // print contents
				sharedTreeset.threadStats();
			} else
			{
				System.out.println("Timed out while waiting for tasks to finish.");
			}
		} catch (InterruptedException ex) 
		{
			ex.printStackTrace();
		}
	} // end main
} // end SimpleTreesetTest
