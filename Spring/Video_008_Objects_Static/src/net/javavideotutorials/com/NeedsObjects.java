package net.javavideotutorials.com;

public class NeedsObjects 
{
	public void createObjects()
	{
		// this invocation is OK because main is a static method of the Objects class
		Objects.main(null);
		
		// to create an instance
		Objects anInstance = new Objects();
		anInstance.doSomething();
	}
}
