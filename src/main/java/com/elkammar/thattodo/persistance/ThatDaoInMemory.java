package com.elkammar.thattodo.persistance;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.elkammar.thattodo.exceptions.ThatException;
import com.elkammar.thattodo.model.Todo;

/**
 * An in memory instant of the DB, used for testing and has a method to populate
 * mock data.
 * 
 * @author elkammar
 */
@Component
public class ThatDaoInMemory implements ThatDao {

	private HashMap<String, HashMap<String, Todo>> db;
	
	public ThatDaoInMemory() {
		db = new HashMap<String, HashMap<String,Todo>>();
		populateTestData();
	}
	
	@Override
	public Todo save(String phone, Todo todo) {
		HashMap<String, Todo> todoList = db.remove(phone);
		
		if(todoList == null) {
			todoList = new HashMap<String, Todo>();
		}
		
		todoList.put(todo.getTitle(), todo);
		db.put(phone, todoList);
		return todo;
	}
	
	@Override
	public Todo get(String phone, String title) throws ThatException {
		try {
			return db.get(phone).get(title);
		} catch (NullPointerException e) {
			// db.get returned null, no record was found under this user/phone.
			throw new ThatException("Record not found for user: "+phone);
		}
	}
	
	@Override
	public Todo update (String phone, String oldItemTitle, Todo newItem) throws ThatException {
		// Check if the old item is already saved and delete it.
		if(delete(phone, oldItemTitle) == null) {
			// if it's not already saved, don't update and throw an exception.
			throw new ThatException("Record not found for user: "+phone);
		}
		// if all passed, save the new item as the old one should be gone now.
		return save(phone, newItem);
	}
	
	@Override
	public Todo delete (String phone, String title) throws ThatException, IllegalArgumentException {
		if(phone == null || title == null) {
			throw new IllegalArgumentException("invalid item name.");
		}
		try {
			return db.get(phone).remove(title);
		} catch (NullPointerException e) {
			// db.get returned null, no record was found under this user/phone.
			throw new ThatException("Record not found for user: "+phone);
		}
	}
	
	@Deprecated
	private void populateTestData() {
		HashMap<String, Todo> todoMap = new HashMap<String, Todo>();
		Todo todo = new Todo("Finish this task", "May the task be with you", true);
		Todo anotherTodo = new Todo("Save humanity", "Make the world a better place and transfer Ibrahimovic back to Milan.", false);
		Todo oneLastTodo = new Todo("Do this one too", "Yeah", false);
		
		todoMap.put(todo.getTitle(), todo);
		todoMap.put(anotherTodo.getTitle(), anotherTodo);
		todoMap.put(oneLastTodo.getTitle(), oneLastTodo);
		
		db.put("+16518081900", todoMap);
	}
}
