package com.webservice.server.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;



@Path("/visita")
public class VisitaService {

	@GET
//	@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitas() throws JSONException{
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("valor1", 234);
		jsonObj.put("valor2", 334);
		jsonObj.put("valor3", 2634);
		
		//return Response.status(200).type(MediaType.APPLICATION_JSON).entity(jsonObj.toString()).build();
		return Response.status(200).entity(jsonObj.toString()).build();

	}
}
