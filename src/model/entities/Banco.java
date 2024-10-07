package model.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Banco {

	private Map<Integer, Conta> map = new HashMap<>();
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public Banco() {
		this.map = new HashMap<>();
	}

	public Map<Integer, Conta> getMap() {
		return map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setMap(Map<Integer, Conta> map) {
		this.map = map;
	}

	public void criarConta(int number, String name, String email, LocalDate birthDate) {
		if(!map.containsKey(number)) {
			map.put(number, new Conta(number, name, email, birthDate));
			System.out.println("Conta criada com sucesso!");
		}
		else {
			throw new DbException("Conta já existente!");
		}
	}
	
	public void depositar(Integer number, Double valor) {
		Conta conta = map.get(number);
		if(conta != null) {
			conta.depositar(valor);
		}
		else {
			throw new DbException("Conta não encontrada!");
		}
	}

	public void sacar(Integer number, Double valor) {
		Conta conta = map.get(number);
		if(conta != null) {
			if(conta.getSaldo() > valor) {				
				conta.sacar(valor);
			}
			else {
				throw new DbException("Saldo insuficiente para o saque!");
			}
		}
		else {
			throw new DbException("Conta não encontrada!");
		}
	}
	
	public void exibirSaldo(int number) {
		Conta conta = map.get(number);
		if(conta != null) {
			System.out.println("Saldo: " + conta.getSaldo());
		}
		else {
			System.out.println("Conta inexistente");
		}
	}
	
	public void listarContas() {
		System.out.println("Contas cadastradas: ");
		for(Conta mp : map.values()) {
			System.out.println("Conta: " + mp.getNumber() + " - Name: " + mp.getName() + "; Saldo: "
		+ String.format("%.2f", mp.getSaldo()) +	"; Email: " + mp.getEmail() + "; Birth date: " + mp.getBirthDate());
		}
	}
	
}
