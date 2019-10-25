package org.acme;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RegisterRestClient
@Path("/failme")
public interface MyResource {

    @GET
    Response failMe() throws MyException;

}
