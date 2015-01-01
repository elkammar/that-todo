package com.elkammar.thattodo;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.elkammar.thattodo.TodoResource;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(TodoResource.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
//    @Test
    public void testGet() {
        final String responseMsg = target().path("/").request().get(String.class);

//        assertEquals("Hello, Heroku!", responseMsg);
    }
}
