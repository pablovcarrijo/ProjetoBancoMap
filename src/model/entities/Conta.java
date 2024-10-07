package model.entities;

import java.time.LocalDate;

public class Conta {

	private String name;
	private Double saldo;
	private String email;
	private LocalDate birthDate;
	private Integer number;
	
	public Conta(Integer number, String name, String email, LocalDate birthDate) {
		this.number = number;
		this.name = name;
		this.saldo = 0.0;
		this.email = email;
		this.birthDate = birthDate;
	}

	public Integer getNumber() {
		return this.number;
	}
	
	public String getName() {
		return name;
	}

	public Double getSaldo() {
		return saldo;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void depositar(Double amount) {
		this.saldo += amount;
	}
	
	public void sacar(Double amount) {
		this.saldo -= amount;
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "Saldo: " + String.format("%.2f", getSaldo())
		+ "; Email: " + getEmail() + "; Birth date: " + getBirthDate();
	}
	
}
