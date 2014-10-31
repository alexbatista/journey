package com.webservice.server.service;

import java.util.List;

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
import javax.xml.bind.JAXBElement;

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
		
//		JSONObject llist = new JSONObject();
//		llist.put("lugares",array);
		return Response.status(200).entity(array.toString()).build();

	}
	
	@Path("/{id}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public Response getLugar(@PathParam("id") int id) throws JSONException{
		
		LugarDao lugarDao = new LugarDao();
		Lugar lugar = lugarDao.listar(id);
		
		JSONObject json = new JSONObject();
		json.put("id", lugar.getId());
		json.put("nome", lugar.getNome());
		json.put("foto", lugar.getFoto());
		json.put("latitude", lugar.getLatitude());
		json.put("longitude", lugar.getLongitude());
		return Response.status(200).entity(json.toString()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setLugar(JAXBElement<Lugar> lugares) throws JSONException{
		LugarDao dao = new LugarDao();
		Lugar lugar = lugares.getValue();
//		lugar.setNome(obj.getString("nome"));
//		lugar.setFoto(obj.getString("foto"));
//		lugar.setLatitude(obj.getDouble("latitude"));
//		lugar.setLongitude(obj.getDouble("longitude"));
		System.out.println("entrou");
		dao.adicionar(lugar);
		
		return Response.status(200).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLugar(JSONObject obj) throws JSONException{
		LugarDao dao = new LugarDao();
		Lugar lugar = new Lugar();
		lugar.setId(obj.getInt("id"));
		lugar.setNome(obj.getString("nome"));
		lugar.setFoto(obj.getString("foto"));
		lugar.setLatitude(obj.getDouble("latitude"));
		lugar.setLongitude(obj.getDouble("longitude"));
		
		dao.atualizar(lugar);
		return Response.status(200).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeLugar(JSONObject obj) throws JSONException{
		LugarDao dao = new LugarDao();
		Lugar lugar = new Lugar();
		lugar.setId(obj.getInt("id"));
		
		dao.remover(lugar);
		return Response.status(200).build();

	}
	

	
	
}
