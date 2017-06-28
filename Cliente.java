package br.com.ifrsrestinga.progii.entidades;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private Integer conta;
	private String senha;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF(){
		return cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getConta(){
		return conta;
	}
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
