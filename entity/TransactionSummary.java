package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


public class TransactionSummary {
	
	private double totalIncome;
    private double totalExpense;
    private double balance;
    private long totalTransactions;
    
    
	public double getTotalIncome() {
		return totalIncome;
	}


	public double getTotalExpense() {
		return totalExpense;
	}


	public double getBalance() {
		return balance;
	}


	public long getTotalTransactions() {
		return totalTransactions;
	}


	public TransactionSummary(double totalIncome, double totalExpense, double balance, long totalTransactions) {
		super();
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
		this.balance = balance;
		this.totalTransactions = totalTransactions;
	}
    
    

}
