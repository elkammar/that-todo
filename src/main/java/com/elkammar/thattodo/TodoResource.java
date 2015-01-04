package com.elkammar.thattodo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elkammar.thattodo.events.ThatEventManager;
import com.elkammar.thattodo.model.Todo;
import com.elkammar.thattodo.services.ThatServiceFacade;

/**
 * 
 * @author elkammar
 *
 */
@Path("/{phone}")
public class TodoResource {

	@PathParam("phone")
	private String phone;
	
	@Autowired
	private ThatServiceFacade service;
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{title}")
    public Todo get(@PathParam("title") String title) {
    	Todo todo = null;
    	//TODO check if it accepts special chars
    	//FIXME
//		try {
//			todo = TodoDbInMemory.getInstance().get(phone, title);
//			System.out.println(todo==null?"unable to find \""+title+"\" todo item" : "todo item: \""+title+ " was queried");
//		} catch (ThatException e) {
//			System.out.println("ERROR:  "+ e.getMessage());
//		}
    	
        return todo;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Todo todo) {
    	System.out.println("saving: \""+todo+"\"");
    	//FIXME
//    	TodoDbInMemory.getInstance().save(phone, todo);
        return Response.status(201).entity(todo.getTitle()+ " was saved").build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Todo todo) {
    	System.out.println("updating: \""+todo+"\"");
    	return Response.status(201).entity(todo.getTitle()+ " was updated").build();
    }
    
    @POST
    @Path("/{title}")
	public Response changeTodoStatus(@PathParam("title") String title,
			@QueryParam("isDone") boolean isDone) {
    	
    	if(isDone) {
    		service.markAsDone(phone, title);
    	} else {
    		service.markAsUndone(phone, title);
    	}
    	return Response.status(201).entity("Status for todo item "+title+ " was updated").build();
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    public Response delete(String title) {
    	return null;
    }
}
