package net.javavideotutorials.com;

public class Primitives {

	// can't run the program in Spring w/o init'ing them 
	// in the main area - have to be here and made static 
	//
	// when here, they are considered "instance" variables
	// and are given default values BECAUSE Java sees them
	// as part of the "Primitives" class
	static int i;
	static boolean bln;
	static double d;
	static float f;
	static char c;
	static long l;
	
	static Integer i2 = 1;
	static Boolean bln2;
	static Double d2;
	static Float f2;
	static Character c2;
	
	public static void main(String[] args) 
	{
		// primitives	-	Object counterparts [Wrapper]
		//	int				Integer
		//	boolean			Boolean
		//	double			Double
		//	float			Float
		//	char			Character
		//
		//					Wrappers - can do same as primitive but have more methods, functionality, but slower
		//
		// some differences, default values when created
		//		e.g., int i;	// default val = 0
		//		int = 0				Integer i = null;
		//		double = 0.0		Double = null;
		//		char = '';			Character = null;
		//		float = 0.0;
		//
		System.out.println("\nPRIMITIVES\n");

		// can't run the program in Spring w/o init'ing them 
		// when they are defined within the main area
		//
		// have to move them into Class area
		System.out.println("uninitialized primitives vals");
		System.out.println("int " + i);
		System.out.println("boolean " + bln);
		System.out.println("double " + d);
		System.out.println("float " + f);
		System.out.println("char " + c);
		System.out.println("long " + l);
	
		System.out.println();
		
		System.out.println("uninitialized Wrapper vals");
		System.out.println("Integer " + i2);
		System.out.println("Boolean " + bln2);
		System.out.println("Double " + d2);
		System.out.println("Float " + f2);
		System.out.println("Character " + c2);
	
		System.out.println();
		
		// what are the benefits of using the Wrapper classes
		System.out.println("Integer.toString " + i2.toString());
		output(i2.toString());
		System.out.println("Integer.hashCode " + i2.hashCode());
	}

	private static void output(String p_o) {
		System.out.println("\n....output(String) called");
		System.out.println(p_o);
	}
	
}
