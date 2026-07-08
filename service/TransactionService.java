package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.TransactionSummary;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService {
	
	   @Autowired
	   private TransactionRepository transactionRepository;
	
	   //Save transactions
	   public Transaction saveTransaction(
	            Transaction transaction) {
	        return transactionRepository.save(transaction);
	    }

	    //Get all transactions
	    public List<Transaction> getAllTransactions() {
	        return transactionRepository.findAll();
	    }
	    
	    //Get transaction_history by userId
	    public List<Transaction> getTransactionHistory(Integer userId) {
	        return transactionRepository.findByUserId(userId);
	    }
	    
	    //Get transaction_summary by userId
	    public TransactionSummary getSummary(Integer userId) {

	        List<Transaction> transactions =
	                transactionRepository.findByUserId(userId);

	        double totalIncome = transactions.stream()
	                .filter(t -> "INCOME".equalsIgnoreCase(t.getType()))
	                .mapToDouble(Transaction::getAmount)
	                .sum();

	        double totalExpense = transactions.stream()
	                .filter(t -> "EXPENSE".equalsIgnoreCase(t.getType()))
	                .mapToDouble(Transaction::getAmount)
	                .sum();

	        double balance = totalIncome - totalExpense;

	        return new TransactionSummary(
	                totalIncome,
	                totalExpense,
	                balance,
	                transactions.size()
	        );
	    }
}
