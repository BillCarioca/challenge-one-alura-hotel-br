package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import connection.ConnectionFactory;
import domain.dao.ReservaDAO;
import domain.models.Reserva;

public class ReservaController {

	private Connection conn;
	private ReservaDAO reservaDAO;
	
	public ReservaController() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		this.conn = connectionFactory.recuperarConexao();
		this.reservaDAO = new ReservaDAO(this.conn);
	}
	
	public void salvar(Reserva reserva) {
		this.reservaDAO.salvar(reserva);
	}
	
	public List<Reserva> buscarTodas(){
		return this.reservaDAO.buscarTodas();
	}
	
	public Reserva buscarPorId (Long reserva_id) {
		return this.reservaDAO.buscarPorId(reserva_id);
	}
	
	public Reserva buscarPorDataEntrada (Date dataEntrada){
		return this.reservaDAO.buscarPorDataEntrada(dataEntrada);
	}
	
	public void alterar(Reserva reserva){
		this.reservaDAO.alterar(reserva);
	}
	
	public void deletar(Long id) {
		this.reservaDAO.deletar(id);
	}
	
	public void desconectar() {
		try {
			if (this.conn!=null)this.conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
