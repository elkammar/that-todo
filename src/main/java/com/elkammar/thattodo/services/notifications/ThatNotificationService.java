package com.elkammar.thattodo.services.notifications;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elkammar.thattodo.events.ThatEventManager;
import com.elkammar.thattodo.events.ThatEventManager.TaskMarkedAsDoneEvent;
import com.google.common.eventbus.Subscribe;

@Component
public class ThatNotificationService {

	@Autowired
	NotificationUtil util;
	@Autowired
	ThatEventManager eventManager;
	
	public ThatNotificationService() {
		
		System.out.println("init ThatNotificationService");
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void setup() {
		System.out.println("PostConstruct");
		System.out.println(eventManager);
		eventManager.register(this);
	}
	
	@Subscribe
	public void taskMarkedAsDoneListener(TaskMarkedAsDoneEvent event) {
		System.out.println("taskMarkedAsDoneListener");
		System.out.println(util);
		System.out.println(eventManager);
		System.out.println("taskMarkedAsDoneListener: sending sms to "+event.getPhone());
		util.sendSms(event.getPhone(), "\""+event.getTitle()+"\" task was marked as done.");
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
