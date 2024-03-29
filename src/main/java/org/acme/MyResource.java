package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080")
@Path("/412")
//@RegisterProvider(MyResponseExceptionMapper.class)
public interface MyResource {

    @GET
    Response failMe() throws MyException;

}
