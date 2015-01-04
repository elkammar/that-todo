package com.elkammar.thattodo.persistance;

import com.elkammar.thattodo.exceptions.ThatException;
import com.elkammar.thattodo.model.Todo;

/**
 * 
 * @author elkammar
 *
 */
public interface ThatDao {
	
	public Todo save(String phone, Todo todo) throws ThatException;
	public Todo get(String phone, String title) throws ThatException;
	public Todo update (String phone, String oldItemTitle, Todo newItem) throws ThatException;
	public Todo delete (String phone, String title) throws ThatException;
}