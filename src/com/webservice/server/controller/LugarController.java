package com.webservice.server.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.webservice.server.bean.Lugar;
import com.webservice.server.dao.LugarDao;


public class LugarController {

	public JSONArray getLugarJson() throws JSONException{
		LugarDao lugar = new LugarDao();
		List<Lugar> lugares = lugar.listarTodos();
		
		JSONArray array = new JSONArray();
		for(Lugar v : lugares){
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", v.getId());
			jsonObj.put("nome", v.getNome());
			jsonObj.put("latitude", v.getLatitude());
			jsonObj.put("longitude", v.getLongitude());
			jsonObj.put("descricao", v.getDescricao());
			jsonObj.put("classificacao", v.getClassificacao());
			array.put(jsonObj);
		}
		return array;
	}
	
	public JSONObject getLugarJson(int id) throws JSONException{
		LugarDao lugarDao = new LugarDao();
		Lugar lugar = lugarDao.listar(id);
		
		JSONObject json = new JSONObject();
		json.put("id", lugar.getId());
		json.put("nome", lugar.getNome());
		json.put("latitude", lugar.getLatitude());
		json.put("longitude", lugar.getLongitude());
		json.put("classificacao", lugar.getClassificacao());
		json.put("descricao",lugar.getDescricao());
		return json;
	}
	
	public void setLugar(Lugar lugar){
		LugarDao dao = new LugarDao();
		dao.adicionar(lugar);		
	}
	
	public void update(int id){
		LugarDao dao = new LugarDao();		
		dao.atualizar(id);	
	}
	
	public void delete(int id){
		LugarDao dao = new LugarDao();
		dao.remover(id);
	}
}
