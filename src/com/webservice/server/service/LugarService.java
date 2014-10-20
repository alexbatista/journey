package com.webservice.server.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.webservice.server.bean.Lugar;
import com.webservice.server.dao.LugarDao;

@Path("/lugar")
public class LugarService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLugares() throws JSONException{
		
		LugarDao lugar = new LugarDao();
		List<Lugar> lugares = lugar.listarTodos();
		
		JSONArray array = new JSONArray();
		for(Lugar v : lugares){
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", v.getId());
			jsonObj.put("nome", v.getNome());
			jsonObj.put("foto", v.getFoto());
			jsonObj.put("latitude", v.getLatitude());
			jsonObj.put("longitude", v.getLongitude());

			array.put(jsonObj);
		}
		
		JSONObject llist = new JSONObject();
		llist.put("lugares",array);
		return Response.status(200).entity(llist.toString()).build();

	}
}
