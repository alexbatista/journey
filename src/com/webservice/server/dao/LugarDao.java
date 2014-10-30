package com.webservice.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webservice.server.bean.Lugar;


public class LugarDao {
	
	Connection conexao;
	
	public LugarDao(){
		this.conexao = new ConnectionFactory().getConnection();
	}

	public void adicionar(Lugar lugar){
		String sql = "insert into lugar (nome,foto,latitude,longitude) value(?,?,?,?)";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, lugar.getNome());
			stmt.setString(2, lugar.getFoto());
			stmt.setDouble(3,lugar.getLatitude());
			stmt.setDouble(4, lugar.getLongitude());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Lugar lugar){
		String sql ="UPDATE lugar SET nome = ?  WHERE id = ?";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, lugar.getNome());
			stmt.setInt(2, lugar.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Lugar> listarTodos(){
		String sql ="select * from lugar";
		List<Lugar> lugares = new ArrayList<Lugar>();
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Lugar lugar = new Lugar();
				lugar.setId(rs.getInt("id"));
				lugar.setNome(rs.getString("nome"));
				lugar.setFoto(rs.getString("foto"));
				lugar.setLatitude(rs.getDouble("latitude"));
				lugar.setLongitude(rs.getDouble("longitude"));
				
				lugares.add(lugar);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lugares;
	}
	
	public Lugar listar(int id){
		String sql ="select * from lugar where id = ?";
		Lugar lugar = new Lugar();
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
			lugar.setId(rs.getInt("id"));
			lugar.setNome(rs.getString("nome"));
			lugar.setFoto(rs.getString("foto"));
			lugar.setLatitude(rs.getDouble("latitude"));
			lugar.setLongitude(rs.getDouble("longitude"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lugar;
	}
	
	public void remover(Lugar lugar){
		String sql = "DELETE FROM lugar WHERE id = ?";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, lugar.getId());
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
