package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionFactory;
import domain.dao.UsuarioDAO;
import domain.models.Usuario;

public class UsuarioController {
	
    private Connection conn;
    private UsuarioDAO usuarioDAO;
	
	public UsuarioController() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		this.conn = connectionFactory.recuperarConexao();
		this.usuarioDAO = new UsuarioDAO(this.conn);
	}
	
	public void salvar(Usuario usuario) {
		this.usuarioDAO.salvar(usuario);
	}
	
	public List<Usuario> buscarTodos() {
		return  this.usuarioDAO.buscarTodos();
	}
	
	public Usuario buscarPorId(Long usuario_id) {
		return this.usuarioDAO.buscarPorId(usuario_id);
	}
	
	public String buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}
	
	public void alterar(Usuario usuario) {
		this.usuarioDAO.alterar(usuario);
	}
	
	public void deletar(Long usuario_id) {
		this.usuarioDAO.deletar(usuario_id);
	}
	
	public void desconectar() {
		try {
			if (this.conn!=null)this.conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
