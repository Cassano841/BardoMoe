package br.com.ifrsrestinga.progii.entidades;

public class Produto {
	private int id;
	private int codigoProduto;
	private String nomeProduto;
	private int precoUnitario;
	
	//get ID
	public Integer getId() {
		return id;
	}
	//set ID
	public void setId(Integer id) {
		this.id = id;
	}
	//get CODIGO PRODUTO
	public Integer getcodigoProduto() {
		return codigoProduto;
	}
	//set CODIGO PRODUTO
	public void setcodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	//get NOME PRODUTO
	public String getnomeProduto() {
		return nomeProduto;
	}
	//set NOME PRODUTO
	public void setnomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	//get PRECO UNITARIO
	public int getprecoUnitario() {
		return precoUnitario;
	}
	//set PRECO UNITARIO
	public void setprecoUnitario(Integer precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
}
