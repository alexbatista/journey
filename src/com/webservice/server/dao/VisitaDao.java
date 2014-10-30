package com.webservice.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webservice.server.bean.Visita;


public class VisitaDao {
	
	Connection conexao;

	public VisitaDao(){
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Visita visita){
		String sql = "insert into visita (id_usuario,id_lugar,descricao,classificacao) value(?,?,?,?)";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, visita.getIdUsuario());
			stmt.setInt(2, visita.getIdLugar());
			stmt.setString(3,visita.getDescricao());
			stmt.setInt(4, visita.getClassificacao());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Visita visita){
		String sql ="UPDATE visita SET nome = ?  WHERE id = ?";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
		//	stmt.setString(1,);
		//	stmt.setInt(2, );
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Visita> listarTodos(){
		String sql ="select * from visita";
		List<Visita> visitas = new ArrayList<Visita>();
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Visita visita = new Visita();
				visita.setIdLugar(rs.getInt("id_lugar"));
				visita.setIdUsuario(rs.getInt("id_usuario"));
				visita.setDescricao(rs.getString("descricao"));
				visita.setClassificacao(rs.getInt("classificacao"));
				
				visitas.add(visita);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return visitas;
	}
	
	public Visita listar(int id_usuario,int id_lugar){
		String sql ="select * from visita where id_usuario = ? and id_lugar = ?";
		Visita visita = new Visita();
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, id_usuario);
			stmt.setInt(2,id_lugar);
			ResultSet rs = stmt.executeQuery();
			visita.setIdUsuario(rs.getInt("id_usuario"));
			visita.setIdLugar(rs.getInt("id_lugar"));
			visita.setDescricao(rs.getString("descricao"));
			visita.setClassificacao(rs.getInt("classificacao"));
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return visita;
	}
	
	public void remover(Visita visita){
		String sql = "DELETE FROM visita WHERE id_usuario = ? and id_lugar = ?";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, visita.getIdUsuario());
			stmt.setInt(2, visita.getIdLugar());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
