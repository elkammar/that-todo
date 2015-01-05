package com.elkammar.thattodo.services.notifications;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elkammar.thattodo.events.ThatEventManager;
import com.elkammar.thattodo.events.TaskMarkedAsDoneEvent;
import com.elkammar.thattodo.exceptions.ThatException;
import com.google.common.eventbus.Subscribe;

@Component
public class ThatNotificationService {

	@Autowired
	NotificationUtil util;
	@Autowired
	ThatEventManager eventManager;
	
	@PostConstruct
	public void setup() {
		System.out.println("PostConstruct");
		System.out.println(eventManager);
		eventManager.register(this);
	}
	
	@Subscribe
	public void taskMarkedAsDoneListener(TaskMarkedAsDoneEvent event) {
		try {
			util.sendSms(event.getPhone(), "\""+event.getTitle()+"\" task was marked as done.");
		} catch (ThatException e) {
			// Sending SMS failed.
			e.printStackTrace();
		}
	}

	public NotificationUtil getUtil() {
		return util;
	}

	public void setUtil(NotificationUtil util) {
		this.util = util;
	}

	public ThatEventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(ThatEventManager eventManager) {
		this.eventManager = eventManager;
	}
}
