package com.mmdworks.recap.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmdworks.recap.domain.Transaction;
import com.mmdworks.recap.dto.CashFlowInputDto;
import com.mmdworks.recap.dto.CashFlowResultDto;
import com.mmdworks.recap.dto.TransactionDto;
import com.mmdworks.recap.dto.TransactionTypeDto;
import com.mmdworks.recap.service.TransactionService;

@RestController
@RequestMapping("/transaction-services")
public class TransactionEndpoint {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/create-transaction")
	private ResponseEntity<?> createTransaction(@RequestBody TransactionDto transactionDto) {	
		Transaction savedTransaction =  transactionService.createTransaction(transactionDto);
		return new ResponseEntity<Transaction>(savedTransaction, HttpStatus.OK);
	}
	
	@GetMapping("/get-transactions-of-property/{propertyId}")
	public ResponseEntity<?> getTransactionsOfProperty(@PathVariable long propertyId) {
		return new ResponseEntity<List<Transaction>>(transactionService.getTransactionsOfProperty(propertyId), HttpStatus.OK);
	}
	
	@PostMapping("/get-transactions-by-type")
	public ResponseEntity<?> getTransactionsOfType(@RequestBody TransactionTypeDto transactionTypeDto) {
		return new ResponseEntity<List<Transaction>>(transactionService.getTransactionsByType(transactionTypeDto), HttpStatus.OK);
	}
	
	@GetMapping("/test-jdbc-mapping")
	public String testJdbc() {
		return transactionService.jdbcTest();
	}
	
	@PostMapping("/get-cash-flow")
	public ResponseEntity<?> getCashFlow(@RequestBody CashFlowInputDto cashFlowInputDto){
		return new ResponseEntity<List<CashFlowResultDto>>(transactionService.getCashFlow(cashFlowInputDto), HttpStatus.OK);
		
	}
	
}
