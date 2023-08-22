package domain.models;

import java.sql.Date;

public class Reserva {
	private Long id;
	private Date dataEntrada;
	private Date dataSaida;
	private Double valor;
	private String formaPagamento;
	
	public Reserva() {}

	public Reserva(Long id, Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", dataChegada=" + dataEntrada + ", dataSaida=" + dataSaida + ", valor=" + valor
				+ ", formaPagamento=" + formaPagamento + "]";
	}
	
	
}
