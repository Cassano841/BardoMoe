package br.com.ifrsrestinga.progii.testes;

import br.com.ifrsrestinga.progii.jdbc.Conexao;

public class TestaConexao {
	
	public static void main (String[] args){
		Conexao.getConnection();
	}
}