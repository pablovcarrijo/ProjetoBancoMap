package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Banco;
import model.entities.DbException;

public class App {

	public static void main(String[] args) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		Banco banco = new Banco();
		
		try {
			int num = 1;
			while (num != 6) {
				System.out.println("\n");
				System.out.println("1 - Criar conta");
				System.out.println("2 - Depositar");
				System.out.println("3 - Sacar");
				System.out.println("4 - Exibit saldo");
				System.out.println("5 - Listar contas");
				System.out.println("6 - Sair");
				System.out.print("Escolha uma opção: ");
				num = sc.nextInt();
				sc.nextLine();
				switch (num) {
				case 1:
					System.out.print("Numero da conta: ");
					int numConta = sc.nextInt();
					sc.nextLine();
					System.out.print("Nome: ");
					String name = sc.nextLine();
					System.out.print("Email: ");
					String email = sc.nextLine();
					System.out.print("Data de aniversário: ");
					LocalDate date = LocalDate.parse(sc.next(), fmt);

					banco.criarConta(numConta, name, email, date);
					break;

				case 2:
					System.out.print("Número da conta: ");
					int numDeposit = sc.nextInt();
					sc.nextLine();
					System.out.print("Valor do deposito: ");
					Double valueDeposito = sc.nextDouble();
					banco.depositar(numDeposit, valueDeposito);
					break;

				case 3:
					System.out.print("Numero da conta: ");
					int numSacar = sc.nextInt();
					sc.nextLine();
					System.out.print("Valor do saque: ");
					Double valueSaque = sc.nextDouble();
					banco.sacar(numSacar, valueSaque);
					break;

				case 4:
					System.out.print("Numero da conta: ");
					int exibirContaNumber = sc.nextInt();
					sc.nextLine();
					banco.exibirSaldo(exibirContaNumber);
					break;

				case 5:
					banco.listarContas();
					break;

				case 6:
					System.out.println("Programa encerrado!");
					System.exit(0);
					break;
				}
			}
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();
		}
		
	}

}
