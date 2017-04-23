package msgthread;

import java.util.Vector;

public class Producer extends Thread {
	private static final int MAXQUEUE = 20;
	
	private int m_numPrimes = 0;
	
	private Vector messages = new Vector();

	Producer(Integer p_numPrimes) {
		m_numPrimes = p_numPrimes;
		System.out.println("Producer-Consumer example to use multi-threading and message passing to generate and print " + m_numPrimes + " prime values.");
	}

	@Override
	public void run() {
		try {
			while (true) {
				putMessage();
				sleep(1000);
			}
		} catch (InterruptedException e) {
		}
	}

	private synchronized void putMessage() throws InterruptedException {
		while (messages.size() == MAXQUEUE)
			wait();
		messages.addElement("genr8  prime " + new java.util.Date().toString());
		messages.addElement("sleep    msg " + new java.util.Date().toString());
		notify();
	}

	// Called by Consumer
	public synchronized String getMessage() throws InterruptedException {
		notify();
		while (messages.size() == 0) {
			wait();
		}
		String message = (String) messages.firstElement();
		messages.removeElement(message);
		return message;
	}
}
