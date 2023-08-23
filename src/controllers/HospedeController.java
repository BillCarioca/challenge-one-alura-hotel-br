package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionFactory;
import domain.dao.HospedeDAO;
import domain.models.Hospede;

public class HospedeController {

	private Connection conn;
	private HospedeDAO hospedeDAO;
	
	public HospedeController() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		this.conn = connectionFactory.recuperarConexao();
		this.hospedeDAO = new HospedeDAO(this.conn);
	}
	
	public void salvar(Hospede hospede) {
		this.hospedeDAO.salvar(hospede);
	}
	
	public List<Hospede> buscarTodos(){
		return this.hospedeDAO.buscarTodos();
	}
	
	public Hospede buscarHospedePorReservaId(Long id){
		return this.hospedeDAO.buscarHospedePorReservaId(id);
	}
	
	public Hospede buscarPorId(Long hospedeId) {
		return this.hospedeDAO.buscarPorId(hospedeId);
	}
	
	public List<Hospede> buscarPorSobrenome(String sobrenome){
		return this.hospedeDAO.buscarPorSobrenome(sobrenome);
	}
	
	public void alterar(Hospede hospede){
		this.hospedeDAO.alterar(hospede);
	}
		
	public void deletar(Long id){
		this.hospedeDAO.deletar(id);
	}
	
	public void desconectar() {
		try {
			if (this.conn!=null)this.conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
