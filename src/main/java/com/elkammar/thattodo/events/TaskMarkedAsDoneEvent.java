package com.elkammar.thattodo.events;

import com.elkammar.thattodo.model.Todo;

/**
 * An event for changing the status of a {@link Todo} item.
 * Encapsulates the title and a flag for whether the item was marked as done or not.
 * 
 * @author elkammar
 */
public class TaskMarkedAsDoneEvent implements IEvent {

	private String phone;
	private String title;
	
	public TaskMarkedAsDoneEvent (String phone, String title) {
		this.title = title;
		this.phone = phone;
	}
	
	public String getTitle() {
		return title;
	}

	public String getPhone() {
		return phone;
	}

}
