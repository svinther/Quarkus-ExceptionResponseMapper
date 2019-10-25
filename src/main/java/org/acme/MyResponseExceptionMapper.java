package org.acme;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class MyResponseExceptionMapper implements ResponseExceptionMapper<MyException> {

    private Logger logger = Logger.getLogger(MyResponseExceptionMapper.class);

    @Override
    public MyException toThrowable(Response response) {
        return new MyException(response.getHeaders().toString());
    }

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        logger.info("handles() method called");
        return status == 301;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
