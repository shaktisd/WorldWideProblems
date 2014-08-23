package org.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class BasicDisruptorExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Disruptor<ValueEvent> disruptor = new Disruptor<ValueEvent>(ValueEvent.EVENT_FACTORY, 1024, executor);
		final EventHandler<ValueEvent> handler = new EventHandler<ValueEvent>() {
			// event will eventually be recycled by the Disruptor after it wraps
			public void onEvent(final ValueEvent event, final long sequence,final boolean endOfBatch) throws Exception {
				System.out.println("Thread " + Thread.currentThread().getName() + " Sequence: " + sequence +  " ValueEvent: " + event.getValue() + " isPrime " + isPrime(event.getValue()));
			}
			private boolean isPrime(int number){
				if(number > 0 && number <=3 ) return true;
				else if(number % 2 == 0) return false;
				else {
					for(int i=3;i< Math.sqrt(number);i++){
						if(number % i ==0) return false;
					}
				}
				return true;
			}
			
			
		};
		disruptor.handleEventsWith(handler);
		RingBuffer<ValueEvent> ringBuffer = disruptor.start();
		for(int i=0;i < 1000000;i++){
			int randomNumber = (int) (Math.random() * 1000000000);
			long nextSequence = ringBuffer.next();
			ValueEvent valueEvent = ringBuffer.get(nextSequence);
			valueEvent.setValue(randomNumber);
			ringBuffer.publish(nextSequence);
			System.out.println("Published nextSequence " + nextSequence + " randomNumber " + randomNumber);
		}
		disruptor.shutdown();
		executor.shutdown();
		

	}

}
