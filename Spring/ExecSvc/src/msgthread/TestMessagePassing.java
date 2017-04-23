package msgthread;

public class TestMessagePassing {

	private static final String PGM_INVOCATION = "\nInvalid Program Invocation.\nPlease re-run and provide a comannd line integer value greater than 2 representing the number of prime values you wish to generate.";
	private static final int EXPECTED_PARAM_COUNT = 1;

	public static void showErrorsAndLeave() {
		System.out.println(PGM_INVOCATION);
		System.exit(0);
	}
	
	public static void main(String args[]) 
	{
		if (args.length != EXPECTED_PARAM_COUNT) {
			showErrorsAndLeave();
		}

		int numPrimes = 0;
		try {
			numPrimes = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			showErrorsAndLeave();
		}
        Producer producer = new Producer(numPrimes);
        producer.start();
        new Consumer(1, producer).start();
        new Consumer(2, producer).start();
        new Consumer(3, producer).start();
    }
}
