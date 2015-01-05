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
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.elkammar.thattodo.exceptions.ThatException;
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
     * Retrieves a todo item using it's title. It takes the title as a pathParam.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{title}")
    public Todo get(@PathParam("title") String title) {
    	//TODO check if it accepts special chars
    	return service.get(phone, title);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Todo todo) {
    	if(service.save(phone, todo) != null) {
    		return Response.status(Status.OK).entity(todo.getTitle()+ " was saved successfully").build();
    	} else {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to save: "+todo.getTitle()).build();
    	}
        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{title}")
    public Response update(@PathParam("title") String title, Todo todo) {
    	if(service.update(phone, title, todo) != null) {
    		return Response.status(Status.OK).entity(todo.getTitle()+ " was updated").build();
    	} else {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to update: "+title).build();
    	}
    }
    
    @POST
    @Path("/{title}")
	public Response changeTodoStatus(@PathParam("title") String title,
			@QueryParam("isDone") boolean isDone) {
    	try {
			service.changeTodoStatus(title, title, isDone);
			return Response.status(Status.OK).entity("Status for todo item "+title+ " was updated").build();
		} catch (ThatException e) {
			e.printStackTrace();
			return Response.status(Status.OK).entity("Status for todo item "+title+ " was updated").build();
		}
    }
    
    @DELETE
    @Path("/{title}")
    public Response delete(@PathParam("title") String title) {
    	if(service.delete(title, title) != null) {
    		return Response.status(Status.OK).entity(title+ " was deleted").build();
    	} else {
    		//TODO return different status codes based on the error, i.e. not found,..etc
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Status for todo item "+title+ " was updated").build();
    	}
    }
}
