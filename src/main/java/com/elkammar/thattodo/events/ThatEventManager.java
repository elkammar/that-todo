package com.elkammar.thattodo.events;

import com.google.common.eventbus.EventBus;

/**
 * 
 * @author elkammar
 *
 */
public class ThatEventManager {
	
	private static ThatEventManager instance;
	private static EventBus eventBus;
	
	private ThatEventManager() {
	}
	
	public static ThatEventManager getInstance() {
		if(instance == null) {
			instance = new ThatEventManager();
			eventBus = new EventBus();
		}
		return instance;
	}
	
	public void register(Object subscriber) {
		eventBus.register(subscriber);
	}
	
	public void post(IEvent event) {
		eventBus.post(event);
	}
	
	/**
	 * 
	 * @author elkammar
	 *
	 */
	public interface IEvent {}
	
	/**
	 * An event for changing the status of a todo item.
	 * Encapsulates the title and a flag for whether the item was marked as done or not.
	 * 
	 * @author elkammar
	 */
	public static class TodoStatusChangedEvent implements IEvent {
		private boolean isDone;
		private String title;
		
		public TodoStatusChangedEvent (String title, boolean isDone) {
			this.isDone = isDone;
			this.title = title;
			System.out.println("TodoStatusChangedEvent event "+isDone);
		}
		
		public boolean isDone() {
			return isDone;
		}
		
		public String getTitle() {
			return title;
		}
	}
}
