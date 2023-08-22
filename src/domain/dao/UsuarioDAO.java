package domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.models.Usuario;

public class UsuarioDAO {
private final Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Usuario usuario) {
		try {
			
			String sql = "INSERT INTO  usuarios (login, senha, isAdmin) VALUES(?, ?, ?)";
			
			try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstmt.setString(1, usuario.getLogin());
				pstmt.setString(2, usuario.getSenha());
				pstmt.setBoolean(3, true);
				
				pstmt.executeUpdate();
				pstmt.close();
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}
	public String buscarPorLogin(String usuario){
		String sql = "SELECT senha FROM usuarios WHERE login = ?";
		String senha="";
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			try {
				pstmt.setString(1, usuario);
				
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
			        senha = rst.getString("senha");
			    }
				pstmt.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
		return senha;
	}
	
	public List<Usuario> buscarTodos(){
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            try (ResultSet rst = pstmt.executeQuery();){
                while (rst.next()) {
                	Usuario usuario = new Usuario(rst.getLong("usuario_id"),rst.getString("login"),rst.getString("senha"),rst.getBoolean("isAdmin"));
                	usuarios.add(usuario);
                }
            }
            return usuarios;
        } catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
	
	public Usuario buscarPorId(Long usuario_id){
		String sql = "SELECT * FROM usuarios WHERE usuario_id = ?";
		Usuario usuario = new Usuario();
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			try {
				pstmt.setLong(1, usuario_id);
				
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
			        usuario.setId(usuario_id);
			        usuario.setLogin(rst.getString("login"));
					usuario.setSenha(rst.getString("senha"));
					usuario.setIsAdmin(rst.getBoolean("isAdmin"));
			    }
				pstmt.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
		return usuario;
	}
	
	
	public void alterar(Usuario usuario) {
		String sql = "UPDATE usuarios SET login = ?, senha = ? WHERE usuario_id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setString(1, usuario.getLogin());
				pstmt.setString(2, usuario.getSenha());
				pstmt.setLong(3, usuario.getId());
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Usuário não alterado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Usuário não alterado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
	}
	
	public void deletar(Long usuario_id) {
		String sql = "DELETE FROM usuarios WHERE Id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, usuario_id);
				 
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Usuário não deletado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Usuário não deletado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
	}
}
