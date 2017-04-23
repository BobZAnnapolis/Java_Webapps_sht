package net.javavideotutorials.assignment1;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LotteryNumberGenerator 
{
	private static final Integer MIN_NUMBER = 1;
	private static final Integer MAX_NUMBER = 49;
	private static final Integer NUMBER_OF_LOTTERY_NUMBERS = 6;
  /**
   * This method should return a Set of 6 different
   * integers.  
   * 
   * Hint: use the 'Random' class located here: java.util.Random
   *       to generate random numbers
   * @return
   */
  public Set<Integer> generateLotteryNumbers ()
  {
	  Set<Integer> lottery = new TreeSet<Integer>();
	  Random rand = new Random();
	  int randomNum;
	  int i = 1;
	  while (i <= NUMBER_OF_LOTTERY_NUMBERS) {
		  randomNum = rand.nextInt(MAX_NUMBER) + MIN_NUMBER;
		  if ( lottery.add(randomNum)) {
			  i++;
		  }
	  }
	  Iterator<Integer> itr = lottery.iterator();
	  System.out.println("Lottery Numbers generated are : ");
	  while (itr.hasNext()) {
		  System.out.print(itr.next() + " ");
	  }
	  System.out.println();
	  return lottery;
  }
}
