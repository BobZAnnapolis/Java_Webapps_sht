package net.javavideotutorials.com;


public class Objects {

	// main method is part of the blueprint of the Objects class
	// i.e., doesn't belong to an instance of the Objects class
	public static void main(String[] args) 
	{
		System.out.println("Methods and Static");
		Object obj = new Object();
		System.out.println("obj.getClass().getName() : " + obj.getClass().getName());
		System.out.println("obj.toString() : " + obj.toString());
		System.out.println("obj.hashCode() : " + obj.hashCode());

		System.out.println("\nObjects Example - User object\n");
		User u = new User("BobZ", "950Breakwater");
		System.out.println("User u = new User(BobZ, 950Breakwater)");
		System.out.println("u.getUsername : " + u.getUsername());
		System.out.println("u.getPassword : " + u.getPassword());

		User theUser = new User();
		System.out.println("User theUser = new User()");
		System.out.println("theUser.toString() : " + theUser.toString());
		theUser.setUsername("User_2");
		theUser.setPassword("User_2_password");
		System.out.println("theUser.setUsername(User_2) : getUsername : " + theUser.getUsername());
		System.out.println("theUser.setPassword(User_2_password) ;  getPassword : " + theUser.getPassword());
		
		// 	object versus class
		//
		//	class - blueprint of an object - the .java file defining the methods & member variables
		//	object - actual physical instantiation of the class
		//
		//	example, houses & blueprints - blueprints are just 'hypothetical' representation of something, i.e., the class,
		//			the actual house is the object  
		//
		//	static vs dynamic
		//
		//	static means not changing
		//	if something is declared as a static, you can reference it without it an instance of the object it belongs to
		
		System.out.println();
		// OK to call SuperUser because this var is declared static inside the class
		if (SuperUser.securityLevel > 1) {
			System.out.println("Give them access");
		}
		else {
			System.out.println("DON'T give them access");
		}
		
		// cannot call this because it is NOT static - it won't exist until Objects is instantiated
		// ok to be called from NeedsObjects - call will be ok if the method is made static
		// doSomething();
	}
	
	public void doSomething() {
		System.out.println("Doing something.");
	}

}
