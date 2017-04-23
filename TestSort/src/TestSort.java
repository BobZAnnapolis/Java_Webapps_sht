
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * Sample program to sort an array
 * 
 * Problem : Given a mixed array of numbers and alphanumeric terms, please implement a 
 * function \ method that will return a sorted array such that the numbers are in numeric 
 * order, and the alphanumeric terms are in alphabetical order subject to the following 
 * constraints:
 * 
 * [1] For any index n in the array, the type of value at index n must be the same in the input 
 * and result arrays, e.g., given the input array { 12, beta, 10, alpha } the 
 * positions (0, 2) are numeric, while the positions (1, 3) are alphanumeric, so the sorted 
 * result should be { 10, alpha, 12, beta }.
 * 
 * [2] The maximum size of the input array is 1,000,000 items.
*/
public class TestSort {

	// define useful constants
	private final static int MAX_ARRAY_SIZE = 1000000;
	private final static int NUMERICS = 0;
	private final static int STRINGS = 1;
	private final static String ERR_STR = ("\nTHE MAX ALLOWED DATA SET SIZE IS %d.\nBUT YOUR INPUT DATA SET HAS %d ITEMS.\n\nProgram stopping - Please check data set and try again");
	private final static String STARTING_STR = "Original";
	private final static String ENDING_STR = "Sorted";

	//
	// validate the data
	//
	// method to validate the data, add all known constraint checks here
	//
	public static void validateData(String[] p_unsortedInputArray) {
		// add tests for the constraints 
		// used a var so i could modify & test during debugging
		int inputLen = p_unsortedInputArray.length;
		if (inputLen > MAX_ARRAY_SIZE) {
			// plenty of ways to handle this too
			System.out.format(ERR_STR, MAX_ARRAY_SIZE, inputLen);
			System.exit(-1);
		}
	}

	//
	// utility method to display any stats/diagnostics we want to
	//
	public static void showStats(String p_label, String[] p_data) {
		// display the input order
		System.out.println("\n" + p_label + " Order :");
		for (int i = 0; i < p_data.length; i++) {
			System.out.print(p_data[i] + ", ");
		}
		System.out.println();
		
		// add additional info, as necessary
	}

	//
	// the sorting method
	//
	// my initial solution was :
	//	create the return array
	//	determine & save the original pattern
	//	separate out the original input array into 2 separate arrays
	//	sort the separate arrays
	//	create the return array
	//	using the original pattern array, access appropriate separate arrays and move vals into return array
	//
	// this works but isn't that efficient
	//	Greg from WashPost suggested an in-place sort
	//	something along the following
	//	- determine a 'pivot' point for each 'type'
	//	- start at either end
	//	- compare vals from end backwards to pivot point
	//	- when a val from right side is < pivot
	//		- determine which val from left side needs to be moved
	//		- use temp vars to swap positions
	//	- this is : faster and saves memory
	//
	public static String[] sortMixedArray(String[] p_unsortedInputArray) {	
		// if we get here, we have a valid data set length
		// output some diagnostic information
//		System.out.println("\nSize of input array : \n" + p_unsortedInputArray.length);

		int inputLen = p_unsortedInputArray.length;
		// create the array to return
		String[] retArray = new String[ inputLen];
//		System.out.println("Size of array to return: \n" + retArray.length); // visually verify sizes match

		// once here, think about all the possible input permutations of numbers & strings and come up with a decent algorithm that 
		// handles them, e.g., (number, number, string,....) or (str, str, num, num, str, num, num, num, str, str...)
		// etc - it wasn't clear [to me] from the instructions that the input set would always follow a simple alternating num/string/num/string.... pattern 
		// so...i would write something here which would detect & preserve the original pattern,
		// then separate out the numbers and other entries into separate arrays, sort them, then
		// use the preserved pattern to move the sorted vals back into the return array	
		
		// create a pattern array which saves the original order
		// use constants to denote NUMERICS & STRINGS
		// create separate numeric and alpha arrays
		// move the original items into the correct array
		ArrayList<Integer> numericArray = new ArrayList<Integer>(1);
		ArrayList<String> alphaArray = new ArrayList<String>(1);
		int patternIdx = 0;
		int[] patternArray = new int[ inputLen];
		for ( String strItem : p_unsortedInputArray) {
			try {
				Integer.parseInt(strItem);
				patternArray[patternIdx] = NUMERICS;
				numericArray.add(Integer.parseInt(p_unsortedInputArray[patternIdx]));
			}
			catch (NumberFormatException e) {
				patternArray[patternIdx] = STRINGS;				
				alphaArray.add(p_unsortedInputArray[patternIdx]);
			}
			patternIdx++;
		}

		// make sure the dynamic structs contain only those elements that have been added
		// should be unnecessary since we initialized them to start at 1 but.......just in case
		numericArray.trimToSize();
		alphaArray.trimToSize();

		// sort our separate structs
		Collections.sort(numericArray);
		Collections.sort(alphaArray);
		// debugging help
//		for (int ii = 0; ii < numericArray.size(); ii++) {System.out.println(numericArray.get(ii));}
//		for (int ii = 0; ii < alphaArray.size(); ii++) {System.out.println(alphaArray.get(ii));}

		// move the sorted arrays back into the return array
		// 
		// the algorithm would go something like this
		// point to the 1st numeric string
		// point to the 1st alphanumeric
		// FOR each pattern
		//     IF this is a NUMERIC, THEN
		//         copy the next NUMERIC string into the return array
		//         bump up the NUMERIC string index
		//     ELSE
		//         copy the next ALPHANUMERIC string into the return array
		//         bump up the ALPHANUMERIC string index
		//     ENDIF
		// ENDIF
		int numIdx = 0;
		int alphaIdx = 0;
		for ( int patIdx = 0; patIdx < patternArray.length; patIdx++) {
			if ( patternArray[patIdx] == NUMERICS) {
				retArray[patIdx] = String.valueOf(numericArray.get(numIdx));
				numIdx++;
			}
			else {
				retArray[patIdx] = alphaArray.get(alphaIdx);
				alphaIdx++;
			}
		}

		// TODO: also, it was mentioned in the instructions about things like efficiency - could use either the 
		// IDE to profile the code to determine how to make it better - or, for e.g., if we had studies 
		// indicating that 90% of the time it would be against data sets with only 100 elements - we could 
		// decide on different data structures - i'd personally like to put more time into getting more 
		// information
		// about the data set coming in, the environment it is going to be used in, issues like that before
		// settling on 1 approach. And documenting why choices were made.
		//
		// That is, if any of that is even necessary, maybe this is just meant to be used as a utility
		// to help someone in which case, not that much time / thought should be put into it.
		
		return retArray;
	}
	
	/**
	 * @param args - unused,presently
	 */
	public static void main(String[] args) {
		// for quick testing purposes - i'm using a small statically built array
		// given more time, once the sorting functionality was implemented
		// we could change the creation of the array_to_sort to come from 
		// different places, e.g., a file, a db table, random generator, etc 
		String unsortedArray[] = {"zThis should work and be the last alpha string !!","0", "12", "beta", "10", "alpha", "8", "2", "100", "cat", "1", "aalpha", "0", "-1"};

		// many ways to implement a solution, i went with :
		// - locally initialize the dataset to sort
		// - validate against known constraints
		//   - we do this here so the sorting method can just implement an algorithm
		// - display starting stats
		// - sort the array
		// - display ending stats
		
		validateData(unsortedArray);
		showStats(STARTING_STR, unsortedArray);
		String[] sortedArray = sortMixedArray(unsortedArray);
		showStats(ENDING_STR, sortedArray);

		// TODO: given more time - could add timing diagnostics - which would
		// be useful for large data sets ; memory resource usage, etc
	}
}
