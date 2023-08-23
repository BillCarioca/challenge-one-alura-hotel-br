package domain.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.models.Hospede;

public class HospedeDAO {
	
private Connection connection;
	
	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Hospede hospede) {
		try {
			
			String sql = "INSERT INTO  hospedes (nome, sobrenome, data_nascimento, nacionalidade, telefone, reserva_id) VALUES(?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstmt.setString(1, hospede.getNome());
				pstmt.setString(2, hospede.getSobrenome());
				pstmt.setDate(3, new Date( hospede.getDataNascimento().getTime()));
				pstmt.setString(4, hospede.getNacionalidade());
				pstmt.setString(5, hospede.getTelefone());
				pstmt.setLong(6, hospede.getIdReserva());
				
				pstmt.executeUpdate();
				pstmt.close();
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "hospede não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}
	
	public List<Hospede> buscarTodos(){
		List<Hospede> hospedes = new ArrayList<>();
	    String sql = "SELECT hospede_id, nome, sobrenome, data_nascimento, nacionalidade, telefone, reserva_id FROM hospedes";
	     
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.execute();
			try(ResultSet rst = pstmt.getResultSet()) {
				while(rst.next()) {
					Hospede hospede = 
							new Hospede(rst.getLong(1), rst.getString(2), rst.getString(3), 
									rst.getDate(4), rst.getString(5), rst.getString(6),rst.getLong(7));	
					hospedes.add(hospede);
				}
			}
			pstmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "hospedes não encontrados!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
		return hospedes;
	}
	
	public Hospede buscarHospedePorReservaId(Long reservaId){
		String sql = "SELECT * FROM hospedes WHERE reserva_id = ?";
		Hospede hospede = new Hospede();
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setLong(1, reservaId);
			try {
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
			        hospede.setId(rst.getLong("hospede_id")); 
			        hospede.setNome(rst.getString("nome"));
			        hospede.setSobrenome(rst.getString("sobrenome"));
			        hospede.setDataNascimento(rst.getDate("data_nascimento"));
			        hospede.setNacionalidade(rst.getString("nacionalidade"));
			        hospede.setTelefone(rst.getString("telefone"));
			        hospede.setIdReserva(reservaId);
			    }
				pstmt.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "hospede não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "hospede não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
		return hospede;
	}
	public Hospede buscarPorId(Long hospedeId){
		String sql = "SELECT * FROM hospedes WHERE hospede_id = ?";
		Hospede hospede = new Hospede();
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setLong(1, hospedeId);
			try {
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
			        hospede.setId(hospedeId); 
			        hospede.setNome(rst.getString("nome"));
			        hospede.setSobrenome(rst.getString("sobrenome"));
			        hospede.setDataNascimento(rst.getDate("data_nascimento"));
			        hospede.setNacionalidade(rst.getString("nacionalidade"));
			        hospede.setTelefone(rst.getString("telefone"));
			        hospede.setIdReserva(rst.getLong("reserva_id"));
			    }
				pstmt.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "hospede não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "hospede não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
		return hospede;
	}
	public Hospede buscarPorSobrenome(String sobrenome){
		String sql = "SELECT * FROM hospedes WHERE sobrenome = ?";
		Hospede hospede = new Hospede();
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, sobrenome);
			try {
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
			        hospede.setId(rst.getLong("hospede_id")); 
			        hospede.setNome(rst.getString("nome"));
			        hospede.setSobrenome(sobrenome);
			        hospede.setDataNascimento(rst.getDate("data_nascimento"));
			        hospede.setNacionalidade(rst.getString("nacionalidade"));
			        hospede.setTelefone(rst.getString("telefone"));
			        hospede.setIdReserva(rst.getLong("reserva_id"));
			    }
				pstmt.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "hospede não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "hospede não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
		return hospede;
	}
	
	public void alterar(Hospede hospede){
		String sql = "UPDATE hospedes SET , nome = ?, sobrenome = ?, data_nascimento = ?, nacionalidade = ?, telefone = ?, reserva_id = ? WHERE hospede_id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setString(1, hospede.getNome());
				pstmt.setString(2, hospede.getSobrenome());
				pstmt.setDate(3, new Date( hospede.getDataNascimento().getTime()));
				pstmt.setString(4, hospede.getNacionalidade());
				pstmt.setString(5, hospede.getTelefone());
				pstmt.setLong(6, hospede.getIdReserva());
				pstmt.setLong(7, hospede.getId());
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "hospede não alterado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "hospede não alterado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
	}
	
	
	public void deletar(Long id){
		String sql = "DELETE FROM hospedes WHERE hospede_id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, id);
				 
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "hospede não deletado!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "hospede não deletado!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
	}
}
