package com.mmdworks.recap.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmdworks.recap.dao.PropertyRepository;
import com.mmdworks.recap.dao.TransactionRepository;
import com.mmdworks.recap.dao.jdbc.JdbcTransactionDao;
import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.domain.Transaction;
import com.mmdworks.recap.dto.CashFlowInputDto;
import com.mmdworks.recap.dto.CashFlowResultDto;
import com.mmdworks.recap.dto.TransactionDto;
import com.mmdworks.recap.dto.TransactionTypeDto;
import com.mmdworks.recap.exception.CommonErrorMessages;
import com.mmdworks.recap.exception.InternalException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private JdbcTransactionDao jdbcTransactionDao;

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Transaction transformToEntity(TransactionDto transactionDto) {
		return modelMapper.map(transactionDto, Transaction.class);
	}

	@Transactional
	public Transaction createTransaction(TransactionDto transactionDto) {

		try {

			Property property = propertyRepository.findByPropertyId(transactionDto.getPropertyId());
			Transaction transaction = transformToEntity(transactionDto);
			transaction.setProperty(property);
			Transaction savedTranxObj = transactionRepository.save(transaction);
			return savedTranxObj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}
	}

	public List<Transaction> getTransactionsOfProperty(long propertyId) {
		try {
			Property property = propertyRepository.findByPropertyId(propertyId);
			List<Transaction> transactions = transactionRepository.findByProperty(property);
			return transactions;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}
	}

	public List<Transaction> getTransactionsByType(TransactionTypeDto transactionTypeDto) {
		try {
			Property property = propertyRepository.findByPropertyId(transactionTypeDto.getProperyId());
			List<Transaction> transactions = transactionRepository.findByPropertyAndTransactionType(property,
					transactionTypeDto.getTransactionType());
			return transactions;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}
	}

	public String jdbcTest() {
		return jdbcTransactionDao.jdbcTest();
	}

	public List<CashFlowResultDto> getCashFlow(CashFlowInputDto cashFlowInputDto) {
		try {

			List<CashFlowResultDto> cashFlowList = jdbcTransactionDao.getCashFlow(cashFlowInputDto);
			return cashFlowList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}
	}

}
