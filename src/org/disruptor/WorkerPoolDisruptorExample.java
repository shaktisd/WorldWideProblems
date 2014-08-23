package org.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.FatalExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SingleThreadedClaimStrategy;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.YieldingWaitStrategy;

public class WorkerPoolDisruptorExample {

	private static final int NUM_WORKERS = 3;
	private static final int RING_BUFFER_SIZE = 1024;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		final Handler[] workHandlers = new Handler[NUM_WORKERS];
		for (int i = 0; i < NUM_WORKERS; i++) {
		      workHandlers[i] = new Handler(i);
		    }
		ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);
	    WorkerPool<ValueEvent> workerPool = new WorkerPool<ValueEvent>(ValueEvent.EVENT_FACTORY,
	                                           new SingleThreadedClaimStrategy(RING_BUFFER_SIZE),
	                                           new YieldingWaitStrategy(),
	                                           new FatalExceptionHandler(),
	                                           workHandlers);
	    
	 // starts WorkerPool workers in separate thread(s)
	    RingBuffer<ValueEvent> ringBuffer = workerPool.start(executor);
		for(int i=0;i < 1000000;i++){
			int randomNumber = (int) (Math.random() * 1000000000);
			long nextSequence = ringBuffer.next();
			ValueEvent valueEvent = ringBuffer.get(nextSequence);
			valueEvent.setValue(randomNumber);
			ringBuffer.publish(nextSequence);
			System.out.println("Published nextSequence " + nextSequence + " randomNumber " + randomNumber);
		}
		// wait until all published events are processed, then stop the workers
	    workerPool.drainAndHalt();
		executor.shutdown();
	}
}
