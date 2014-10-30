package com.webservice.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.webservice.server.bean.Usuario;

public class UsuarioDao {

	private Connection conexao;
	
	public UsuarioDao(){
		this.conexao = new ConnectionFactory().getConnection();		
	}
	
	public void adicionar(Usuario usuario){
		String sql = "insert into usuario (nome) value(?)";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Usuario usuario){
		String sql ="UPDATE usuario SET nome = ?  WHERE id = ?";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("null")
	public List<Usuario> listarTodos(){
		String sql ="select * from usuario";
		List<Usuario> usuarios = null;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuarios.add(usuario);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuarios;
	}
	
	public Usuario listar(int id){
		String sql ="select * from usuario where id = ?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}
	
	public void remover(Usuario usuario){
		String sql = "DELETE FROM usuario WHERE id = ?";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
