package prodcons.src;

public class Calculator implements Runnable {

	private int m_number;
	
	public Calculator(int p_number) {
	    this.m_number = p_number;
	}
	
	@Override
	public void run() {
		for (int i=1; i<=10; i++)
		{
			System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),m_number,i,i*m_number);
		}
	}
}
