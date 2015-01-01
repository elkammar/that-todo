package com.elkammar.thattodo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model
 * 
 * @author elkammar
 *
 */
@XmlRootElement
public class Todo {

	public String title;
	public String body;
	public boolean done;
	
	public Todo() {
	}

	public Todo(String title, String body, boolean isDone) {
		this.title = title;
		this.body = body;
		this.done = isDone;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean isDone) {
		this.done = isDone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Todo that = (Todo) obj;
		if(!title.equals(that.getTitle())) {
			return false;
		}
		if(!body.equals(that.getBody())) {
			return false;
		}
		if(!title.equals(that.getTitle())) {
			return false;
		}
		if(done != that.done) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
        result = 31 * result + body.hashCode();
        return result;
	}
	
	@Override
	public String toString() {
		return "{\"title\":"+title+", \"body\":"+body+", \"done\":"+done+" }"; 
	}
}
