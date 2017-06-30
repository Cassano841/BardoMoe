package br.com.ifrsrestinga.progii.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifrsrestinga.progii.entidades.Cliente;
import br.com.ifrsrestinga.progii.entidades.Operacoes;
import br.com.ifrsrestinga.progii.entidades.Produto;

public class OperacoesDAO {
	private Connection con = Conexao.getConnection();
	
	public void salvarOperacoes(Operacoes operacoes) {
		//sql
		String sql = "INSERT INTO operacoes (deposito, transferencia, saldo) values (?,?,?)";
		try {
			PreparedStatement prepara = con.prepareStatement(sql);
			//substitui os ? por valores;
			
			//Integer id = produto.getId();
			Integer deposito = operacoes.getDeposito();
			Integer transferencia = operacoes.getTransferencia();
			Integer saldo = operacoes.getSaldo();
			
			//prepara.setInt(1, id);
			prepara.setInt(1, deposito);
			prepara.setInt(2, transferencia);
			prepara.setInt(3,saldo);
			
			prepara.execute();
			prepara.close();
			
			System.out.println("Operação realizada com sucesso");
		}catch(SQLException e){ 
			//se comando sql nao estiver correto ira imprimir o erro gerado
			e.printStackTrace();
	}
}
}
