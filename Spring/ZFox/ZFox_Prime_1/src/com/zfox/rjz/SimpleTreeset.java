package com.zfox.rjz;

import java.security.SecureRandom;
import java.util.TreeSet;
//
//	SimpleTreeset
//
//	this is pretty much a wrapper object around my data structure to handle 
//	all the functionality associated with :
//		- determining if a number is a prime
//		- adding new primes into our collection
//		- collecting thread-specific stats
//		- handling unexpected conditions
//
public class SimpleTreeset 
{
	//
	// a bunch of thread statistic messages to display after program execution
	// there are better ways to do this but these came in after the fact to 
	// use as a justification that multiple threads were executing. I 
	// hard-coded the program to use 3 threads so that's why these are like 
	// this. 
	//
	private static final String MSG_THREAD_1_ADDED = "\t\tThread_1 ADDED %d Primes.\n";
	private static final String MSG_THREAD_2_ADDED = "\t\tThread_2 ADDED %d Primes.\n";
	private static final String MSG_THREAD_3_ADDED = "\t\tThread_3 ADDED %d Primes.\n";
	private static final String MSG_THREAD_1_NOT_PRIME = "\t\tThread_1 tried to add %d non-prime vals.\n";
	private static final String MSG_THREAD_2_NOT_PRIME = "\t\tThread_2 tried to add %d non-prime vals.\n";
	private static final String MSG_THREAD_3_NOT_PRIME = "\t\tThread_3 tried to add %d non-prime vals.\n";
	private static final String MSG_THREAD_1_DUPES = "\t\tThread_1 tried to add %d already existing primes.\n";
	private static final String MSG_THREAD_2_DUPES = "\t\tThread_2 tried to add %d already existing primes.\n";
	private static final String MSG_THREAD_3_DUPES = "\t\tThread_3 tried to add %d already existing primes.\n";
	//
	// 	secureRandom # generator to use in timeouts [explained why below]
	// 	save number of primes asked for by user
	// 	treeset to store primes
	//		- treeset only allow unique vals to be added so used this to 
	//				satisfy requirement that vals only get saved/printed 
	//				once
	//  a bunch of vars to keep track of thread stats
	//
	private static final SecureRandom generator = new SecureRandom();
	private int m_numPrimes = 0; // keeps track of # primes to create
	private TreeSet<Integer> m_treeset = new TreeSet<Integer>();
	private int added1, added2, added3 = 0;
	private int exists1, exists2, exists3 = 0;
	private int noPrime1, noPrime2, noPrime3 = 0;
	//
	// constructor
	//
	//	save the number of primes to compute
	//
	public SimpleTreeset(int p_numPrimesToCompute) 
	{
		m_numPrimes = p_numPrimesToCompute;
	}
	//
	// synchronized add(val)
	//
	// this is the method that does the bulk of the work
	// we use the "synchronized" keyword so that when any thread starts
	// executing it - the other threads wait until the current one 
	// finishes
	//
	// 	Basically, the logic here is that for each thread:
	// 	IF we're not done (there are more prime #s to compute), THEN
	//		IF the current value to add is a PRIME, THEN
	//			IF this is a brand new prime #, THEN
	//				inc "successful prime num calculated" stats
	//				sleep for a bit [a no-no, see below]
	//			ELSE
	//				inc "duplicate prime attempt" stats
	//			ENDIF (new prime handling)
	//		ELSE
	//			inc "not a prime" stats
	//		ENDIF (current val is prime)
	//	ENDIF (more primes to compute)
	//
	public synchronized void add(int value) 
	{
		System.out.printf("\t\t\t%s add(%2d) element(%2d).%n", Thread
				.currentThread().getName(), value, m_treeset.size());
		try 
		{
			if (! isSetFull()) 
			{
				if (isPrime(value)) 
				{
					if (m_treeset.add(value)) 
					{
						System.out.printf("%s ADDED %2d to element %d.%n", Thread
								.currentThread().getName(), value, m_treeset.size());
						incAdded(Thread.currentThread().getName());
						System.out.printf("\t\t\tNext element: %d%n", m_treeset.size());
						//
						// in "real" applications you should NOT sleep
						// this was the quickest way I could think of
						// to help cause the other threads to start
						// executing
						//
						Thread.sleep(generator.nextInt(500)); // for demo only
						//
						// also, another anomaly with this implementation, it 
						// wasn't until i started adding in the different 
						// System.out calls that I started to get more and
						// more thread participation - without the System.out
						// calls, when I ran it, more times than not, 1 thread
						// thread would be responsible for generating most of
						// the primes
						//
						// since this doesn't do a lot of processing is why
						// i'm guessing that you really only need 1 thread
						// to do this kind of stuff with today's machine
						//
					}
					else
					{
						System.out.printf("\t\t\t%s REJECTED %2d - ALREADY EXISTS.%n", Thread
								.currentThread().getName(), value);
						incExists(Thread.currentThread().getName());
					}
				}
				else
				{
					System.out.printf("\t\t\t%s REJECTED %2d - NOT A PRIME VALUE.%n", Thread
							.currentThread().getName(), value);
					incNoPrime(Thread.currentThread().getName());
				}
			} // endif - only attempt to add when more numbers needed
		} catch (InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	} // end add(val)
	//
	// isPrime
	//
	// web search fcn utility to do the funky math that
	// determines if a number is prime
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
	//
	// util function to do a quick check to see if we've collected all
	// the prime numbers asked for by the user, return answer to caller
	//
	public synchronized boolean isSetFull() 
	{
		boolean retVal = false;
		if (m_treeset.size() == m_numPrimes) 
		{
			retVal = true;
		}
		return retVal;
	}	
	//
	// util fcn to create the asked-for string of primes to display to user
	//
	public String toString() {
		String strPrimes = "";
		for (Integer val : m_treeset) {
			strPrimes += val + "  ";
		}
		return strPrimes;
	}
	//
	// util fcn to display some stats to the user
	//
	// primarily wrote this to verify to me that multiple threads were
	// actually being executed - better ways of doing this
	//
	public void threadStats() {
		int totalTries = added1+added2+added3+exists1+exists2+exists3+noPrime1+noPrime2+noPrime3;
		System.out.format("\n\t*** Thread Stats for (%d) Primes took (%d) attempts ***\n", m_numPrimes, totalTries);	
		System.out.format("\n"+MSG_THREAD_1_ADDED, added1);
		System.out.format(MSG_THREAD_2_ADDED, added2);
		System.out.format(MSG_THREAD_3_ADDED, added3);

		System.out.format("\n"+MSG_THREAD_1_DUPES, exists1);
		System.out.format(MSG_THREAD_2_DUPES, exists2);
		System.out.format(MSG_THREAD_3_DUPES, exists3);

		System.out.format("\n"+MSG_THREAD_1_NOT_PRIME, noPrime1);
		System.out.format(MSG_THREAD_2_NOT_PRIME, noPrime2);
		System.out.format(MSG_THREAD_3_NOT_PRIME, noPrime3);
	}
	//
	// the following util fcns are solely called to help
	// create thread-specific stats that will get displayed
	// at program completion - again, better ways to do this
	//
	private synchronized void incAdded(String p_threadID) {
		if (p_threadID.contains("thread-1")) 
			added1++;
		else 
		{
			if (p_threadID.contains("thread-2")) 
				added2++;
			else
				added3++;
		}
	}	
	private synchronized void incExists(String p_threadID) {
		if (p_threadID.contains("thread-1")) 
			exists1++;
		else 
		{
			if (p_threadID.contains("thread-2")) 
				exists2++;
			else
				exists3++;
		}
	}
	private synchronized void incNoPrime(String p_threadID) {
		if (p_threadID.contains("thread-1")) 
			noPrime1++;
		else 
		{
			if (p_threadID.contains("thread-2")) 
				noPrime2++;
			else
				noPrime3++;
		}
	}
}