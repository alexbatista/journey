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

import com.webservice.server.bean.Visita;
import com.webservice.server.dao.VisitaDao;



@Path("/visita")
public class VisitaService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitas() throws JSONException{
		
		VisitaDao visita = new VisitaDao();
		List<Visita> visitas = visita.listarTodos();
		
		JSONArray array = new JSONArray();
		for(Visita v : visitas){
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("idUsuario", v.getIdUsuario());
			jsonObj.put("idLugar", v.getIdLugar());
			jsonObj.put("descricao", v.getDescricao());
			jsonObj.put("classificacao", v.getClassificacao());

			array.put(jsonObj);
		}
		
		JSONObject vlist = new JSONObject();
		vlist.put("visitas",array);
		return Response.status(200).entity(vlist.toString()).build();

	}
}
