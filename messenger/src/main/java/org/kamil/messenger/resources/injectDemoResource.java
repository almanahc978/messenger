package org.kamil.messenger.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.message.internal.HttpHeaderReader;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class injectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("custom") String headerParam, @CookieParam("cookie") String cookieParam) {
		
		return "Matrix param: " + matrixParam + " || " + "Header param: " + headerParam + " || Cookie param: "
				+ cookieParam;
	}
	
	@GET
	@Path("context")
	public String getParmaUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path: " + path + " || " + "Cookies: " + cookies;
	}
}

/*
 * MatrixParam(rarely used) HeaderParam CookieParam FormParam(rarely used)
 */

/*
 * Context  
 * */