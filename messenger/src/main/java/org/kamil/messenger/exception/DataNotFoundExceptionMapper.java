package org.kamil.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kamil.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException e) {
		// TODO Auto-generated method stub

		ErrorMessage errorMessage = new ErrorMessage("Resource not found", 404,
				"http://messenger/documentation/messageNotFound");
		return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
	}

}
