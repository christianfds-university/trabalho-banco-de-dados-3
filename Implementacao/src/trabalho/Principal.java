package trabalho;
import java.util.Scanner;

import trabalho.Driver;

public class Principal {

	private static Driver db;
	private static Scanner sc;
	
	private static void printSeparator() {
		System.out.println("***************************************");
	}
	
	/*
	 * Inteface para seleção de usuário
	 */
	private static void selectUser() {
		Integer Opcao;

		while(true) {
			printSeparator();
			System.out.println("[ 0] - Usuario Root - Usuário padrão");
			System.out.println("[ 1] - Usuario1     - Usuário com todos os privilégios");
			System.out.println("[ 2] - Usuario2     - Usuário com acesso apenas para consulta");
			System.out.println("[ 3] - Usuario3     - Usuário com acesso para consulta e update na tabela trabalho.envio");
			System.out.println("[-1] - Voltar");
			printSeparator();
			
			do {
				System.out.print("Seleção: ");
				Opcao = sc.nextInt();
			}while(Opcao < -1 || Opcao > 3);
			
			switch (Opcao) {
			case -1:
				return;
			case 0:
				db.setUserRoot();
				break;
			case 1:
				db.setUser1();
				break;
			case 2:
				db.setUser2();
				break;
			case 3:
				db.setUser3();
				break;
			}
		}

	}
	
	/*
	 * Inteface para interação com a tabela pais
	 */
	private static void interactPais() {
		Integer Opcao;

		while(true) {
			printSeparator();
			System.out.println("[ 0] - Listar Paises");
			System.out.println("[ 1] - Inserir Pais");
			System.out.println("[ 2] - Alterar Pais");
			System.out.println("[ 3] - Excluir Pais");
			System.out.println("[-1] - Voltar");
			printSeparator();
			
			do {
				System.out.print("Seleção: ");
				Opcao = sc.nextInt();
			}while(Opcao < -1 || Opcao > 3);
			
			switch (Opcao) {
			case -1:
				return;
			case 0:
				db.listarPais();
				break;
			case 1:
				System.out.println("Digite o nome do pais");
				String nomeInsert = sc.next();
				System.out.println("Digite o ddi do pais");
				Integer ddiInsert = sc.nextInt();
				
				db.inserirPais(nomeInsert, ddiInsert);
				break;
			case 2:
				System.out.println("Digite o id do pais a ser atualizado");
				Integer idUpdate = sc.nextInt();
				System.out.println("Digite o novo nome do pais");
				String nomeUpdate = sc.next();
				System.out.println("Digite o novo ddi do pais");
				Integer ddiUpdate = sc.nextInt();
				
				db.atualizarPais(idUpdate, nomeUpdate, ddiUpdate);
				break;
			case 3:
				System.out.println("Digite o id do pais a ser deletado");
				Integer idDelete = sc.nextInt();
	
				db.deletarPais(idDelete);
				break;
			}
		}
	}

	/*
	 * Inteface para interação com a tabela pais
	 */
	private static void interactEnvio() {
		Integer Opcao;

		while(true) {
			printSeparator();
			System.out.println("[ 0] - Listar envio");
			System.out.println("[ 1] - Inserir envio");
			System.out.println("[ 2] - Alterar envio");
			System.out.println("[ 3] - Excluir envio");
			System.out.println("[-1] - Sair");
			printSeparator();
			
			do {
				System.out.print("Seleção: ");
				Opcao = sc.nextInt();
			}while(Opcao < -1 || Opcao > 3);
			
			switch (Opcao) {
			case -1:
				return;
			case 0:
				db.listarEnvio();
				break;
			case 1:
				System.out.println("Digite o nome do envio");
				String nomeInsert = sc.next();
				
				db.inserirEnvio(nomeInsert);
				break;
			case 2:
				System.out.println("Digite o id do envio a ser atualizado");
				Integer idUpdate = sc.nextInt();
				System.out.println("Digite o novo nome do envio");
				String nomeUpdate = sc.next();
				
				db.atualizarEnvio(idUpdate, nomeUpdate);
				break;
			case 3:
				System.out.println("Digite o id do pais a ser deletado");
				Integer idDelete = sc.nextInt();
	
				db.deletarEnvio(idDelete);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			sc = new Scanner(System.in);
			Integer Opcao;
	
			db = new Driver();
			db.setUserRoot();
			
			do {
				printSeparator();
				System.out.println("[ 0] - Selecionar Usuário");
				System.out.println("[ 1] - Interagir com a Tabela 'pais'");
				System.out.println("[ 2] - Interagir com a Tabela 'envio'");
				System.out.println("[-1] - Sair");
				printSeparator();
				do {
					System.out.print("Seleção: ");
					Opcao = sc.nextInt();
				}while(Opcao < -1 || Opcao > 2);
	
				switch (Opcao) {
				case -1:
					break;
				case 0:
					selectUser();
					break;
				case 1:
					interactPais();
					break;
				case 2:
					interactEnvio();
					break;
				}
				
			}while(Opcao != -1);
			
			sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
