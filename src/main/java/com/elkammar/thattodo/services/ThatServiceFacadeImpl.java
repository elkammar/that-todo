package com.elkammar.thattodo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elkammar.thattodo.events.ThatEventManager;
import com.elkammar.thattodo.exceptions.ThatException;
import com.elkammar.thattodo.model.Todo;
import com.elkammar.thattodo.persistance.ThatDao;
import com.elkammar.thattodo.services.notifications.ThatNotificationService;

/**
 * 
 * @author elkammar
 *
 */
@Component
public class ThatServiceFacadeImpl implements ThatServiceFacade {

	@Autowired
	ThatDao thatDao;
	@Autowired
	ThatEventManager eventManager;
	@Autowired
	ThatNotificationService notificationService;
	
	public ThatServiceFacadeImpl() {
		
	}

	@Override
	public Todo save(String phone, Todo todo) {
		try {
			return thatDao.save(phone, todo);
		} catch (ThatException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Todo get(String phone, String title) {
		try {
			return thatDao.get(phone, title);
		} catch (ThatException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Todo delete(String phone, String title) {
		try {
			return thatDao.delete(phone, title);
		} catch (ThatException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Todo update(String phone, String title, Todo updatedTodo) {
		try {
			return thatDao.update(phone, title, updatedTodo);
		} catch (ThatException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void markAsDone(String phone, String title) {
		// TODO fire an taskDone event.
		System.out.println(eventManager);
		System.out.println(notificationService);
		System.out.println(thatDao);
		eventManager.post(new ThatEventManager.TaskMarkedAsDoneEvent(phone, title));
	}

	@Override
	public void markAsUndone(String phone, String title) {
		
	}
	
	public ThatDao getThatDao() {
		return thatDao;
	}

	public void setThatDao(ThatDao thatDao) {
		this.thatDao = thatDao;
	}

	public ThatEventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(ThatEventManager eventManager) {
		this.eventManager = eventManager;
	}
	
	public ThatNotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(ThatNotificationService notificationService) {
		this.notificationService = notificationService;
	}

}
