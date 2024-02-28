package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String []args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("---------------------------------------");
		System.out.println("--------[Bem vindo ao MazeBank]--------");
		System.out.println("_________[Selecione uma opção]_________");
		System.out.println("---------------------------------------");
		System.out.println("| Opção 1 - Criar Conta           |");
		System.out.println("| Opção 2 - Depositar             |");
		System.out.println("| Opção 3 - Sacar                 |");
		System.out.println("| Opção 4 - Transferir            |");
		System.out.println("| Opção 5 - Listar                |");
		System.out.println("| Opção 6 - Sair                  |");
		System.out.println("___________________________________");
		
		int operacao = sc.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break; 
		case 2:
			depositar();
		case 3:
			sacar();
		case 4:
			transferir();
		case 5:
			listarContas();
		case 6:
			System.out.println("Obrigado por utilizar o MazeBank!");
			System.exit(0);
			
		default:
			System.out.println("Opção Inválida!");
			operacoes();
			break;
			
		}
	}
	
	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = sc.next();
		
		System.out.println("\nCPF: ");
		String cpf = sc.next();
		
		System.out.println("\nEmail: ");
		String email = sc.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
		contasBancarias.add(conta);
		
		System.out.println("Sua conta foi criada com sucesso!");
		operacoes();
	}
	
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if (c.getNumeroConta() == numeroConta);
				conta = c;
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Número da Conta: ");
		int numeroConta = sc.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta !=null) {
			System.out.println("Valor a ser depositado: ");
			double valorDeposito = sc.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso! ");
		}
		else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Número da Conta: ");
		int numeroConta = sc.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Valor a ser sacado: ");
			double valorSaque = sc.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("Saque efetuado com Sucesso! ");
		}
		else {
			System.out.println(" Conta não encontrada ");
		}
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Número da Conta do Remetente: ");
		int numeroContaRemetente = sc.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Número da conta do Destinatário: ");
			int numeroContaDestinatario = sc.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if (contaDestinatario != null) {
				System.out.println("Valor da transferência: ");
				double valor = sc.nextDouble();
				
				contaRemetente.transferirConta(contaDestinatario, valor);
			}
		}
		operacoes();
	}
	
	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
		}
		
		else {
			System.out.println("Não há contas Cadastradas!");
		}
		operacoes();
	}
}
