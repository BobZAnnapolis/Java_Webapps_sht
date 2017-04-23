package rjz.executors;

import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 

public class SimpleThreadPool { 

    public static void main(String[] args) { 
        ExecutorService executor = Executors.newFixedThreadPool(7); 
        for (int i = 0; i < 10; i++) 
        {
        	Runnable worker = new WorkerThread((i+1)," " + i); 
            executor.execute(worker);
        } 
        executor.shutdown(); 
        while (!executor.isTerminated()) { 
        } 
        System.out.println("Finished all threads"); 
    } 
}