package com.elkammar.thattodo.events;

import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;

/**
 * Contains EventBuses, and has the functionalities to post events and register listeners.
 * 
 * @author elkammar
 */
@Component
public class ThatEventManager {
	
	private EventBus eventBus;

	public ThatEventManager() {
		eventBus = new EventBus();
	}
	
	public void register(Object subscriber) {
		eventBus.register(subscriber);
	}
	
	public void post(IEvent event) {
		eventBus.post(event);
	}
}
