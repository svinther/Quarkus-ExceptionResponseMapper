package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ExampleResource {

    @Inject
    @RestClient
    MyResource myResource;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        try {
            Response response = myResource.failMe();
            return "Unexpected: No exception. Response status code was: " + response.getStatus();
        } catch (MyException e) {
            return "ExceptionResponseMapping is working correctly";
        } catch (Throwable e) {
            return "Exceptionmapping not working, caught:\n" + e;
        }
    }

    @GET
    @Path("/412")
    public Response fail() {
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }
}