package org.disruptor;

import com.lmax.disruptor.EventFactory;

public final class ValueEvent {
	public static final EventFactory<ValueEvent> EVENT_FACTORY = new EventFactory<ValueEvent>() {
		@Override
		public ValueEvent newInstance() {
			return new ValueEvent();
		}
	};
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}