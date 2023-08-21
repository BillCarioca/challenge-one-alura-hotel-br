package domain.models;

import java.sql.Date;

public class Reserva {
	private Long id;
	private Date dataChegada;
	private Date dataSaida;
	private String valor;
	private String formaPagamento;
	
	public Reserva() {}

	public Reserva(Long id, Date dataChegada, Date dataSaida, String valor, String formaPagamento) {
		super();
		this.id = id;
		this.dataChegada = dataChegada;
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

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
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
		return "Reserva [id=" + id + ", dataChegada=" + dataChegada + ", dataSaida=" + dataSaida + ", valor=" + valor
				+ ", formaPagamento=" + formaPagamento + "]";
	}
	
	
}
