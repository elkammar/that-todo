package com.elkammar.thattodo.services;

import com.elkammar.thattodo.exceptions.ThatException;
import com.elkammar.thattodo.model.Todo;
import com.elkammar.thattodo.persistance.TodoDbInMemory;

public class ThatServiceFacadeImpl implements ThatServiceFacade{

	TodoDbInMemory db;
	
	public ThatServiceFacadeImpl() {
		System.out.println("init Service...");
		db = TodoDbInMemory.getInstance();
	}

	@Override
	public Todo save(String phone, Todo todo) {
		return db.save(phone, todo);
	}

	@Override
	public Todo get(String phone, String title) {
		Todo todo = null;
		try {
			todo = db.get(phone, title);
		} catch (ThatException e) {
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public Todo delete(String phone, String title) {
		Todo todo = null;
		try {
			todo = db.delete(phone, title);
		} catch (ThatException e) {
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public Todo update(String phone, String title, Todo updatedTodo) {
		Todo todo = null;
		try {
			todo = db.update(phone, title, todo);
		} catch (ThatException e) {
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public void markAsDone(String phone, String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markAsUndone(String phone, String title) {
		// TODO Auto-generated method stub
		
	}
}
