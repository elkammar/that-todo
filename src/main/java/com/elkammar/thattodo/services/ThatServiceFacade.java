package com.elkammar.thattodo.services;

import com.elkammar.thattodo.exceptions.ThatException;
import com.elkammar.thattodo.model.Todo;
/**
 * Main service class
 * 
 * @author elkammar
 *
 */

/**
 * Base class for services.
 * 
 * @author elkammar
 */
public interface ThatServiceFacade {

	public Todo save(String phone, Todo todo);
	public Todo get(String phone, String title);
	public Todo delete (String phone, String title);
	public Todo update(String phone, String title, Todo updatedTodo);
	public void changeTodoStatus(String phone, String title, boolean isDone) throws ThatException;
}
