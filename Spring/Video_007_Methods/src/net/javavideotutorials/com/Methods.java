package net.javavideotutorials.com;

import java.util.ArrayList;
import java.util.List;

public class Methods {

	public static void main(String[] args) 
	{
		System.out.println("...this is the main() method\n");
		
		String uN = "user_";
		for (int i = 0; i < 5; i++) {
			login((uN + String.valueOf(i+1)));
		}
		
		List<String> userNames = new ArrayList<String>();
		userNames.add("BobZ");
		userNames.add("Melissa");
		userNames.add("Jeff");
		userNames.add("Kareen");
		userNames.add("Pauley");
		for (String name : userNames) {
			login(name);
		}
		
		String userNm = "BobZ";
		boolean userValid = isValidUser(userNm);
		if (userValid) {
			System.out.println(userNm + " is valid, please use our system.");
			login(userNm);
		}
		else {
			System.out.println(userNm + " is NOT valid, please use our system.");
		}
	}

	// private - most strict, only methods inside of this Methods class can access it
	// protected - 
	// public - most visible, accessible to every single class/object in this project, i.e., everthing in Video7
	
	// private - only visible to Methods class
	private static void login(String p_userName)
	{
		System.out.println("...calling login() method to login user : " + p_userName);
		
		// imagine a whole bunch of code here that logs a user into a system
		
	}
	
	private static boolean isValidUser(String p_userName) {
		boolean retValue = true;
		
		System.out.println("...calling isValidUser(" + p_userName + ")");
		
		// add code here to determine if input user was valid or not
		// boolean retVal = checkDatababaseForUser(p_userName);

		return retValue;
	}
}
