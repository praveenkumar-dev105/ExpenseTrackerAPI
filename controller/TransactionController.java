package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.TransactionSummary;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	
	     @Autowired
	     private TransactionService transactionService;
	
	    @PostMapping("/save")
	    public Transaction saveTransaction(
	            @RequestBody Transaction transaction) {
	        return transactionService
	                .saveTransaction(transaction);
	    }

	    @GetMapping("/user/{userId}")
	    public List<Transaction> getAllTransactions() {

	        return transactionService
	                .getAllTransactions();
	    }
       
	    @GetMapping("/history/{userId}")
	    public List<Transaction> getTransactionHistory(
	            @PathVariable Integer userId) {

	        return transactionService.getTransactionHistory(userId);
	    }
	    
	    @GetMapping("/summary/{userId}")
	    public TransactionSummary getSummary(
	            @PathVariable Integer userId) {
	        return transactionService.getSummary(userId);
	    }
}
