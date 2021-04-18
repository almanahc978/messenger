package org.kamil.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kamil.messenger.model.ErrorMessage;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable e) {
		// TODO Auto-generated method stub

		ErrorMessage errorMessage = new ErrorMessage("Exception thrown", 500,
				"http://messenger/documentation/");
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
