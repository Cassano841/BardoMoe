package br.com.ifrsrestinga.progii.entidades;
import java.util.GregorianCalendar;

public class Vendas {

	private Integer id;
	private int codVenda;
	GregorianCalendar horaVenda;
	private  Cliente objCliente;
	private Produto objProduto;
	private int quantiade;
		
		public int getCodVenda() {
			return codVenda;
		}
		public void setCodVenda(int codVenda) {
			this.codVenda = codVenda;
		}
		
		public GregorianCalendar getHoraVenda() {
			return horaVenda;
		}
		public void setHoraVenda(GregorianCalendar horaVenda) {
			this.horaVenda = horaVenda;
		}
		public Cliente getObjCliente() {
			return  objCliente;
		}
		public void setObjCliente( Cliente objCliente) {
			this.objCliente = objCliente;
		}
		
		public Produto getProdutos() {
			return objProduto;
		}
		public void setProdutos(Produto objProduto) {
			this.objProduto = objProduto;
		}
		
		public int getQuantiade() {
			return quantiade;
		}
		public void setQuantiade(int quantiade) {
			this.quantiade = quantiade;
		}
		
	}

	
	
	
	
	
	
