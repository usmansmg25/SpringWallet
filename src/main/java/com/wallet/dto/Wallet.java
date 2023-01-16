package com.wallet.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
	@Id
	private Integer id;
	private String name;
	private Double balance;
	
	public Wallet() {
		super();
	}
	public Wallet(Integer id, String name, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Wallet [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
	
	

}
