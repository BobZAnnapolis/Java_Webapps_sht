package rjz.executors;

public class WorkerThread implements Runnable { 
    private int m_id; 
    private String command; 

    public WorkerThread(int p_id, String s){ 
        this.m_id = p_id; 
        this.command=s; 
    } 

    @Override 
    public void run() { 
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command); 
        processCommand(); 
        System.out.println(Thread.currentThread().getName()+" End."); 
    } 

    private void processCommand() { 
        try { 
            System.out.println("\tThread id : " + m_id + " Processing command : " + command); 
            Thread.sleep(5000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    } 

    @Override 
    public String toString(){ 
        return this.command; 
    } 

} 
