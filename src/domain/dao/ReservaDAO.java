package domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import domain.models.Reserva;

public class ReservaDAO {
	
private Connection connection;
	
	public ReservaDAO (Connection connection) {
		this.connection = connection;
	}
	
	public Long salvar(Reserva reserva) {
		try {
			
			String sql = "INSERT INTO  reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES(?, ?, ?, ?)";
			
			try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstmt.setDate(1,  reserva.getDataEntrada());
				pstmt.setDate(2,  reserva.getDataSaida());
				pstmt.setDouble(3, reserva.getValor());
				pstmt.setString(4, reserva.getFormaPagamento());
				pstmt.executeUpdate();
				try (ResultSet rst = pstmt.getGeneratedKeys()) {
					while(rst.next()) {
						reserva.setId(rst.getLong(1));
					}
				}
				pstmt.close();
				return reserva.getId();
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Reserva não cadastrada!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> buscarTodas() {
		List<Reserva> reservas = new ArrayList<>();
		
		String sql = "SELECT reserva_id, data_entrada, data_saida, valor, forma_pagamento FROM reservas";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.execute();
			
			try(ResultSet rst = pstmt.getResultSet()) {
				while(rst.next()) {
					Reserva reserva = 
							new Reserva(rst.getLong(1), rst.getDate(2) , rst.getDate(3), rst.getDouble(4), rst.getString(5));
					
					reservas.add(reserva);
				}
			}
			pstmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Reservas não encontradas!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
		return reservas;
	}
	
	public Reserva buscarPorId (Long reserva_id){
		String sql = "SELECT * FROM reservas WHERE reserva_id = ?";
		Reserva reserva = new Reserva();
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			try {
				pstmt.setLong(1, reserva_id);
				
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
					reserva.setId(reserva_id);
					reserva.setDataEntrada(rst.getDate("data_entrada"));
					reserva.setDataSaida(rst.getDate("data_saida"));
					reserva.setValor(rst.getDouble("valor"));
					reserva.setFormaPagamento(rst.getString("forma_pagamento"));
			    }
				pstmt.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Reserva não encontrada!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Reserva não encontrada!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
		return reserva;		
	}
	
	public Reserva buscarPorDataEntrada (Date dataEntrada){
		String sql = "SELECT * FROM reservas WHERE data_entrada = ?";
		Reserva reserva = new Reserva();
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			try {
				pstmt.setDate(1, (java.sql.Date) dataEntrada);
				
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
					reserva.setId(rst.getLong("reserva_id"));
					reserva.setDataEntrada(rst.getDate("data_entrada"));
					reserva.setDataSaida(rst.getDate("data_saida"));
					reserva.setValor(rst.getDouble("valor"));
					reserva.setFormaPagamento(rst.getString("forma_pagamento"));
			    }
				pstmt.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Reserva não encontrada!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Reserva não encontrada!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
		return reserva;		
	}
	
	public void alterar(Reserva reserva) {
		String sql = "UPDATE reservas SET data_entrada = ?, data_saida = ?, valor = ?, forma_pagamento = ? WHERE reserva_id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setDate(1,  reserva.getDataEntrada());
				pstmt.setDate(2,  reserva.getDataSaida());
				pstmt.setDouble(3, reserva.getValor());
				pstmt.setString(4, reserva.getFormaPagamento());
				pstmt.setLong(5, reserva.getId());
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Reserva não alterada!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Reserva não alterada!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
	}
	
	public void deletar(Long id){
		String sql = "DELETE FROM reservas WHERE reserva_id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, id);
				 
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Não é permitido deletar a reserva de um hóspede existente!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Não foi possivel deletar a reserva!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(ex);
		}
	}
}
