package br.univel.meustestes;

import java.math.BigDecimal;
import br.univel.minhaarvore.UniArvore;
import br.univel.minhaarvore.UniArvoreImpl;
import br.univel.minhaarvore.UniNode;
import br.univel.minhaarvore.UniNodeImpl;

public class Principal {
	public Principal() {
		Conta contaAgua = new Conta(1, "Água", new BigDecimal("85.00"));
		UniNode<Conta> noAgua = new UniNodeImpl<>(contaAgua);
		
		Conta contaAluguel = new Conta(2, "Aluguel", new BigDecimal("1165.00"));
		UniNode<Conta> noAluguel = new UniNodeImpl<>(contaAluguel);
		
		Conta contaInternetTelefone = new Conta(3, "Internet e Telefone", new BigDecimal("135.23"));
		UniNode<Conta> noInternetTelefone = new UniNodeImpl<>(contaInternetTelefone);
		
		Conta contaEnergiaEletrica = new Conta(4, "Energia Elétrica", new BigDecimal("238.00"));
		UniNode<Conta> noEnergiaEletrica  = new UniNodeImpl<>(contaEnergiaEletrica);
		
		Conta despesasAdministrativas = new Conta(1, "Despesas administrativas", new BigDecimal("0.00"));
		UniNode<Conta> noDespesasAdministrativas = new UniNodeImpl<>(despesasAdministrativas);
		noDespesasAdministrativas.addFilho(noAgua);
		noDespesasAdministrativas.addFilho(noAluguel);
		noDespesasAdministrativas.addFilho(noInternetTelefone);
		noDespesasAdministrativas.addFilho(noEnergiaEletrica);
		
		Conta contaBeneficios = new Conta(1, "Benefícios", new BigDecimal("10.00"));
		UniNode<Conta> noBeneficios = new UniNodeImpl<>(contaBeneficios);
		
		Conta contaEncargos = new Conta(2, "Encargos", new BigDecimal("11.00"));
		UniNode<Conta> noEncargos = new UniNodeImpl<>(contaEncargos);
		
		Conta contaSalario = new Conta(3, "Salário", new BigDecimal("500.00"));
		UniNode<Conta> noSalario = new UniNodeImpl<>(contaSalario);
		
		Conta gastosComPessoal = new Conta(2, "Gastos com pessoal", new BigDecimal("0.00"));
		UniNode<Conta> noGastosComPessoal = new UniNodeImpl<>(gastosComPessoal);
		noGastosComPessoal.addFilho(noBeneficios);		
		noGastosComPessoal.addFilho(noEncargos);
		noGastosComPessoal.addFilho(noSalario);
		
		Conta servicosLimpeza = new Conta(1, "Serviços de limpeza", new BigDecimal("120.00"));
		UniNode<Conta> noServicosLimpeza = new UniNodeImpl<>(servicosLimpeza);
		
		Conta servicosManutencao = new Conta(2, "Serviços de manutenção", new BigDecimal("200.00"));
		UniNode<Conta> noServicosManutencao = new UniNodeImpl<>(servicosManutencao);
		
		Conta manutencaoELimpeza = new Conta(3, "Manutenção e limpeza", new BigDecimal("0.00"));
		UniNode<Conta> noManutencaoELimpeza = new UniNodeImpl<>(manutencaoELimpeza);
		noManutencaoELimpeza.addFilho(noServicosLimpeza);
		noManutencaoELimpeza.addFilho(noServicosManutencao);
		
        Conta materiaisDeEscritorio = new Conta(1, "Materiais de escritório", new BigDecimal("350.00"));
        UniNode<Conta> noMateriaisDeEscritorio = new UniNodeImpl<>(materiaisDeEscritorio);
        
        Conta materiaisDeLimpeza = new Conta(2, "Materiais de limpeza", new BigDecimal("450.00"));
        UniNode<Conta> noMateriaisDeLimpeza = new UniNodeImpl<>(materiaisDeLimpeza);
        
        Conta materiais = new Conta(4, "Materiais", new BigDecimal("0.00"));
        UniNode<Conta> noMateriais = new UniNodeImpl<>(materiais);
        noMateriais.addFilho(noMateriaisDeEscritorio);
        noMateriais.addFilho(noMateriaisDeLimpeza);
		
		Conta despesasOperacionais = new Conta(1, "Despesas operacionais", new BigDecimal("0.00"));
		UniNode<Conta> noDespesasOperacionais = new UniNodeImpl<>(despesasOperacionais);
		noDespesasOperacionais.addFilho(noDespesasAdministrativas);
		noDespesasOperacionais.addFilho(noGastosComPessoal);
		noDespesasOperacionais.addFilho(noManutencaoELimpeza);
		noDespesasOperacionais.addFilho(noMateriais);
		
//		UniArvore<Conta> planoContas = new UniArvoreImpl<Conta>(noDespesasOperacionais);
		UniArvore<Conta> planoContas = new UniArvoreImpl(noDespesasOperacionais);
		/**
		 * Adicione aqui o restante das contas.
		 */
		
		//somarFilhos(planoContas);
		
		/**
		 * Mostra todo o plano de contas, inclusive com tabulações (\t) a cada nível.
		 */
		planoContas.mostrarTodosConsole();

		/**
		 * O exercício consiste em identificar a necessidade 
		 * de novos métodos para finalizar a tarefa, sempre lembrando
		 * de coesão, acoplamento e encapsulamento.
		 * Entregar link do repositóario para fernandod@univel.br com assunto:
		 * TrabalhoComplementar 3o Sem
		 */
	}
	
	/**
	 * 
	 * Percorre toda a árvore, recursivamente, encontra
	 * todas as contas análiticas (isLeaf() == true), soma
	 * seus valores e atribui o total na conta pai.
	 * 
	 * Depois pega todos os pais e somam no avô.
	 */
	private void somarFilhos(UniArvore<Conta> planoContas) {
		/*
		UniNode<Conta> nodeRaiz = planoContas.getNoRaiz();

		if (nodeRaiz != null) {
			if (!nodeRaiz.isLeaf()) {
				BigDecimal valor = new BigDecimal(0);
				
				for (UniNode<Conta> node : nodeRaiz.getFilhos()) {
					valor.add(node.getConteudo().getValor());
					node.getPai().getConteudo().setValor(valor);
				}
			}
		}
		*/			
		
		/* todo:
		if (nodeRaiz.getFilhos() != null) {
			BigDecimal valor = new BigDecimal(0);
			UniArvore<Conta> proximo = null;
			
			if (!nodeRaiz.isLeaf()) {
				for (UniNode<Conta> node : nodeRaiz.getFilhos()) {
					valor.add(node.getConteudo().getValor());
					nodeRaiz.getConteudo().setValor(valor);
					
					if (proximo == null)
						proximo = new UniArvoreImpl<Conta>(node);
				}
				
				if (proximo != null)
					somarFilhos(proximo);
			}
		}
		*/
	}

	public static void main(String[] args) {
		new Principal();
	}
}
