package org.disruptor.diningphilosophers;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;


public class DiningPhilosophers {
	private static int NO_OF_PHILOSOPHERS = 5;
	public static void main(String[] args) throws Exception{
		Philosopher[] philosophers = new Philosopher[NO_OF_PHILOSOPHERS];
		//Fork[] forks = new Fork[NO_OF_PHILOSOPHERS];
		ReentrantLock[] forks = new ReentrantLock[NO_OF_PHILOSOPHERS];
		for(int i=0; i< NO_OF_PHILOSOPHERS;i++){
			int leftForkId = i;
			int rightForkId =  i-1 < 0 ? NO_OF_PHILOSOPHERS-1 : i-1;
			if(forks[leftForkId] == null){
				forks[leftForkId] = new ReentrantLock();
			}
			
			if(forks[rightForkId] == null){
				forks[rightForkId] = new ReentrantLock();
			}
			philosophers[i] = new Philosopher(i, forks[leftForkId],forks[rightForkId]);
			Util.print("Init " + philosophers[i]);
			
		}
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(NO_OF_PHILOSOPHERS);
		for(int i=0;i<NO_OF_PHILOSOPHERS;i++){
			newFixedThreadPool.execute(philosophers[i]);
		}
		
		Thread.sleep(NO_OF_PHILOSOPHERS  * 1000 * 10);
		
		for(Philosopher p : philosophers){
			p.endOfSimulation.set(true);
		}
		
		Util.print("End of simulation");
		for(Philosopher p : philosophers){
			System.out.println(p);
		}
		newFixedThreadPool.shutdown();
	}
}

class Philosopher implements Runnable{
	private static final int WAIT_TO_ACQUIRE_LOCK = 10;
	private static final int THINKING_TIME = 10;
	private static final int EATING_TIME = 10;
	//To randomize eat/Think time
    private Random randomGenerator = new Random();
	private int philosopherId;
	private ReentrantLock leftFork;
	private ReentrantLock rightFork;
	private int foodCount;
	public AtomicBoolean endOfSimulation = new AtomicBoolean(false);

	public Philosopher(int philosopherId,ReentrantLock leftFork,ReentrantLock rightFork) {
		this.philosopherId = philosopherId;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	public int getPhilosopherId() {
		return philosopherId;
	}
	

	@Override
	public void run() {
		while(!endOfSimulation.get()){
			thinking();
			try {
				if(leftFork.tryLock(WAIT_TO_ACQUIRE_LOCK, TimeUnit.MILLISECONDS) && rightFork.tryLock(WAIT_TO_ACQUIRE_LOCK, TimeUnit.MILLISECONDS)){
					eating();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finishedEating();
			
		}
	}
	
	private void eating(){
		Util.print("Philosopher[" + philosopherId + "]" + " Eating with [" + this.leftFork + "," + this.rightFork + "]");
		try {
			Thread.sleep(randomGenerator.nextInt(EATING_TIME));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	private void thinking(){
		Util.print("Philosopher[" + philosopherId + "]" + " Thinking .... ");
		try {
			Thread.sleep(randomGenerator.nextInt(THINKING_TIME));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void finishedEating(){
		foodCount++;
		if(leftFork.isHeldByCurrentThread()){
			leftFork.unlock();
		}
		
		if(rightFork.isHeldByCurrentThread()){
			rightFork.unlock();
		}
		
	}

	@Override
	public String toString() {
		return "Philosopher [philosopherId=" + philosopherId + "foodCount= "
				+ foodCount +
				", leftFork="
				+ leftFork + ", rightFork=" + rightFork ;
	}
	
	
	
}

class Fork {
	private int forkId;
	private int ownedByPhilosopherId;
	private boolean isAvailable = true;
	
	public Fork(int forkId) {
		this.forkId = forkId;
	}
	public int getForkId() {
		return forkId;
	}
	public int getOwnedByPhilosopherId() {
		return ownedByPhilosopherId;
	}
	public void setOwnedByPhilosopherId(int ownedByPhilosopherId) {
		this.ownedByPhilosopherId = ownedByPhilosopherId;
	}
	
	public boolean isAvailable() { 
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Fork [forkId=" + forkId + ", ownedByPhilosopherId="
				+ ownedByPhilosopherId + ", isAvailable=" + isAvailable + "]";
	}
	
}