package org.disruptor;

import com.lmax.disruptor.WorkHandler;

public class Handler implements WorkHandler<ValueEvent>{
	
	private int handlerId ;
	
	public Handler(int handlerId) {
		this.handlerId = handlerId;
	}

	@Override
	public void onEvent(ValueEvent event) throws Exception {
		System.out.println("Handler " + handlerId  + " Thread " + Thread.currentThread().getName() +  " ValueEvent: " 
	+ event.getValue() + " isPrime " + isPrime(event.getValue()));
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

}
