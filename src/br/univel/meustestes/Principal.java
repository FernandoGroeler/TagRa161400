package br.univel.meustestes;

import java.math.BigDecimal;

import br.univel.minhaarvore.UniArvore;
import br.univel.minhaarvore.UniArvoreImpl;
import br.univel.minhaarvore.UniNode;
import br.univel.minhaarvore.UniNodeImpl;

public class Principal {
	public Principal() {
		Conta contaAgua = new Conta(1, "Água", new BigDecimal("85,00"));
		UniNode<Conta> noAgua = new UniNodeImpl<>(contaAgua);
		
		Conta contaAluguel = new Conta(2, "Aluguel", new BigDecimal("1165,00"));
		UniNode<Conta> noAluguel = new UniNodeImpl<>(contaAluguel);
		
		Conta contaInternetTelefone = new Conta(3, "Internet e Telefone", new BigDecimal("135,23"));
		UniNode<Conta> noInternetTelefone = new UniNodeImpl<>(contaInternetTelefone);
		
		Conta contaEnergiaEletrica = new Conta(4, "Energia Elétrica", new BigDecimal("238,00"));
		UniNode<Conta> noEnergiaEletrica  = new UniNodeImpl<>(contaEnergiaEletrica);
		
		Conta despesasAdministrativas = new Conta(1, "Despesas administrativas", new BigDecimal("0,00"));
		UniNode<Conta> noDespesasAdministrativas = new UniNodeImpl<>(despesasAdministrativas);
		noDespesasAdministrativas.addFilho(noAgua);
		noDespesasAdministrativas.addFilho(noAluguel);
		noDespesasAdministrativas.addFilho(noInternetTelefone);
		noDespesasAdministrativas.addFilho(noEnergiaEletrica);
		
		Conta despesasOperacionais = new Conta(1, "Despesas operacionais", new BigDecimal("0,00"));
		UniNode<Conta> noDespesasOperacionais = new UniNodeImpl<>(despesasOperacionais);
		noDespesasOperacionais.addFilho(noDespesasAdministrativas);
		
		UniArvore<Conta> planoContas = new UniArvoreImpl(noDespesasOperacionais);		
	}
	
	public static void main(String[] args) {
		new Principal();
	}
}
