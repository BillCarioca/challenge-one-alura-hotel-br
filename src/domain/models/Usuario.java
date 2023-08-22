package domain.models;

public class Usuario {
	private Long id;
	private String login;
	private String senha;
	private Boolean isAdmin;
	public Usuario() {
	}
	public Usuario(Long id, String login, String senha, Boolean isAdmin) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.isAdmin = isAdmin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
