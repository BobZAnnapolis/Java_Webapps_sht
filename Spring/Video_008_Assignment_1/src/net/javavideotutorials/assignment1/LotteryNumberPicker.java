package net.javavideotutorials.assignment1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LotteryNumberPicker 
{
	private static final int MIN = 1;
	private static final int MAX = 49;
	private static final String PROMPT_1 = "Enter number %d : ";
	private static final String PROMPT_2 = "%d has already been entered, enter a different number : ";
	private static final String PROMPT_3 = "%d is outside of expected range, please enter a value between %d - %d, inclusive : ";

  /**
   * This method should pull input from the user in the console.  It should
   * gather 6 Integers from the user and then store these numbers in a Set of
   * Integers that will then be returned by the method.
   * 
   * Hint: use the following code to get numbers:
   * 
   * Scanner in = new Scanner(System.in);
   * in.nextInt();
   * 
   * @return Set of 6 numbers that were chosen by the user
   * @throws IOException
   */
  public Set<Integer> promptUserForLotteryNumbers () throws IOException
  {
	Scanner in = new Scanner(System.in);
	System.out
			.println("Using Java Scanner object : Enter 6 different numbers between "
					+ MIN + " and " + MAX + ".");

	Set<Integer> lottery = new TreeSet<Integer>();
	int val = 0;
	boolean blnDupe = false;
	boolean blnInRange;

	for (int i = 0; i <= 5; i++) {
		do {
			blnInRange = false;
			System.out.format(PROMPT_1, (i + 1));
			do {
				try {
					val = in.nextInt();
				} catch (Exception e) {
//					e.printStackTrace();
					System.out.println("Error: Invalid value entered - converted to a 0.");
					val = 0;
					in.next();
				}
				if ((val < MIN) || (val > MAX)) {
					System.out.format(PROMPT_3, val, MIN, MAX);
				} else {
					blnInRange = true;
				}
			} while (!blnInRange);
			blnDupe = lottery.add(val);
			if (!blnDupe) {
				System.out.format(PROMPT_2, val);
			}
		} while (!blnDupe);
	} // endFor
	in.close();

	System.out.println("\nDone.\nUser entered the following values :");
	Iterator<Integer> it = lottery.iterator();
	while (it.hasNext()) {
		System.out.print(it.next() + " ");
	}
	System.out.println("\n");
		
	return lottery;
  }
}