package com.elkammar.thattodo.events;

import org.springframework.stereotype.Component;

import com.elkammar.thattodo.model.Todo;
import com.google.common.eventbus.EventBus;

/**
 * 
 * @author elkammar
 *
 */
@Component
public class ThatEventManager {
	
	private EventBus eventBus;

	public ThatEventManager() {
		System.out.println("init EventManager...");
		eventBus = new EventBus();
	}
	
	public void register(Object subscriber) {
		eventBus.register(subscriber);
	}
	
	public void post(IEvent event) {
		System.out.println("firing "+event);
		eventBus.post(event);
	}
	
	/**
	 * An advantage of having a base interface for events in addition to polymorphism,
	 * is to identify scopes when loading the {@link ThatEventManager}, my plan is add 
	 * custom annotations and make the {@link ThatEventManager} scan for them and assign
	 * each event to it's own scope. An example of different scopes is Async and Syn event buses.
	 * Not sure if I will implement this, just wanted to elaborate on the idea.
	 * 
	 * @author elkammar
	 */
	public interface IEvent {}
	
	/**
	 * An event for changing the status of a {@link Todo} item.
	 * Encapsulates the title and a flag for whether the item was marked as done or not.
	 * 
	 * @author elkammar
	 */
	public static class TaskMarkedAsDoneEvent implements IEvent {
		private String phone;
		private String title;
		
		public TaskMarkedAsDoneEvent (String phone, String title) {
			this.title = title;
			this.phone = phone;
			System.out.println("TodoStatusChangedEvent event");
		}
		
		public String getTitle() {
			return title;
		}

		public String getPhone() {
			return phone;
		}
	}
}
