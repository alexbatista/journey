package com.webservice.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.webservice.server.bean.Lugar;
import com.webservice.server.controller.LugarController;

@Path("/lugar")
public class LugarResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLugares() throws JSONException{
		
		JSONArray array = new LugarController().getLugarJson();
		return Response.status(200).entity(array.toString()).build();

	}
	
	@Path("/{id}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public Response getLugar(@PathParam("id") int id) throws JSONException{
		
		JSONObject json = new LugarController().getLugarJson(id);
		return Response.status(200).entity(json.toString()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setLugar(Lugar lugar) throws JSONException{
		new LugarController().setLugar(lugar);
		return Response.status(200).build();
	}
	
	//@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateLugar(Lugar lugar) throws JSONException{
	
		new LugarController().update(lugar);
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeLugar(@PathParam("id") int id) throws JSONException{
		new LugarController().delete(id);
		
		return Response.status(200).build();

	}
	

	
	
}
