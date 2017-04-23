package net.javavideotutorials.com;

public class Loops {

	public static void main(String[] args) throws InterruptedException 
	{
		
		// for loops are used -> finite data
		// loop 10 times
		for ( int i = 1; i <= 10; i++)
		{
			System.out.println(i);
		}

		// nesting for loops
		for ( int i = 1; i <= 10; i++)
		{
			System.out.print(i + " - ");
			for (int j = 0; j < 10; j++) {
				System.out.print( j + " ");
			}
			System.out.println();
		}

	}

}
