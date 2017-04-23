package net.javavideotutorials.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataStructures {

	public static void main(String[] args) 
	{
		System.out.println("\nMap key-value example\n");
		// Map example
		// key - value pair
		//	Cars
		//		make : model
		//		key  : value
		//     Honda : Civic, Prelude
		//	   Ford  : Mustang, Focus
		//   Toyota  : Corolla, RAV4
		//     Audi  : R8, A4
		//
		//  Map(String, List<String>)
		Map<String, List<String>> makeModel = new HashMap<String, List<String>>();
		
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		
		List<String> hondaList = new ArrayList<String>();
		hondaList.add("Civic");
		hondaList.add("Prelude");
		
		makeModel.put("Honda", hondaList);

		List<String> toyotaList = new ArrayList<String>();
		toyotaList.add("Corolla");
		toyotaList.add("RAV4");
		
		makeModel.put("Toyota", toyotaList);

		System.out.println(makeModel.get("Honda"));
		System.out.println(makeModel.get("Toyota"));
		// haven't defined these so will get nulls - no exception
		System.out.println(makeModel.get("Ford"));
		System.out.println(makeModel.get("AUdi"));
		
		// call arrayListexample
		arrayList();
	}

	public static void arrayList() 
		{
		System.out.println("\nArrayList example\n");
		// ArrayList - don't need to define a size
		// cannot use primitive types in <>
		List<String> arrayList = new ArrayList<String>();
		
		arrayList.add("H");
		arrayList.add("E");
		arrayList.add("L");
		arrayList.add("L");
		arrayList.add("O");
		arrayList.add("!");
		
		System.out.println("arrayList.get(0) " + arrayList.get(0));
		
		if (! arrayList.isEmpty())
		{
			System.out.println("arrayList has " + arrayList.size() + " elements.");
		}
		
		System.out.println("system println arrayList");
		for (String s : arrayList)
		{
			System.out.print(s);
		}
		
		System.out.println();
		arrayList.remove(4);
		System.out.println("system println arrayList - removed O");
		for (String s : arrayList)
		{
			System.out.print(s);
		}
		
		// call original array
		arrayMethod();
	}

	public static void arrayMethod() 
	{
		System.out.println("\nArray example\n");
		char[] charArray = new char[5];
		
		charArray[0] = 'H';
		charArray[1] = 'E';
		charArray[2] = 'L';
		charArray[3] = 'L';
		charArray[4] = 'O';
		
		System.out.println("system println charArray");
		System.out.println(charArray);
		
		// using direct method
		System.out.println("system print for int i = 0; i < len; i++");
		for (int i = 0; i < charArray.length; i++)
		{
			System.out.print(charArray[i]);
		}
		
		System.out.println();
		// for-each loop
		System.out.println("system println for char c : charArray");
		for ( char c : charArray)
		{
			System.out.println(c);
		}
		
		Arrays.sort(charArray);
		System.out.println("system println for char c : Arrays.sort(charArray)");
		for ( char c : charArray)
		{
			System.out.println(c);
		}
		
	}

}
