package com.elkammar.thattodo.model;

/**
 * A model that encapsulates date related to the user.
 * TODO Ideally, each user would have many todo lists, and each todo list would have many todo items,
 * and in this case, it would be used for authentication and the notification service will use the 
 * user contact info for sending emails, sms's,...etc. 
 * 
 * For the sake of simplicity and the scope of this project/task, I just included an optional 
 * field for a phone number with each todo item and exposed an API for assigning a phone number
 * with a task or a todo item.
 * 
 * @author elkammar
 *
 */
public class User {
	
	private String name;
	private String email;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
