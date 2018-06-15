package com.mmdworks.recap.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.domain.Transaction;
import com.mmdworks.recap.enums.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public List<Transaction> findByProperty(Property property);
	
	public List<Transaction> findByPropertyAndTransactionType(Property property,TransactionType transactionType);
	
	
}
