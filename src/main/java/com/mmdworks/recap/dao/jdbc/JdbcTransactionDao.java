package com.mmdworks.recap.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mmdworks.recap.dto.CashFlowInputDto;
import com.mmdworks.recap.dto.CashFlowResultDto;

@Repository
public class JdbcTransactionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String jdbcTest() {
		return jdbcTemplate.getClass().getName();
	}

	private static final String CASH_FLOW_QUERY =
			 "SELECT DATE_FORMAT(trns.date, \"%M\") as expenseMonth,DATE_FORMAT(trns.date, \"%Y\")as expenseYear"
			+" , SUM(COALESCE(CASE WHEN trns.trans_type = 'EXPENSE' THEN trns.amount END,0)) expanse"
			+" , SUM(COALESCE(CASE WHEN trns.trans_type = 'INCOME' THEN trns.amount END,0)) income"
			+" , SUM(COALESCE(CASE WHEN trns.trans_type = 'INCOME' THEN trns.amount END,0))"
			+" - SUM(COALESCE(CASE WHEN trns.trans_type = 'EXPENSE' THEN trns.amount END,0)) balance"
			+" ,prop.property_id as propertyId"
			+" ,prop.property_name as propertyName"
			+" FROM transactions trns"
			+" INNER JOIN property prop"
			+" on prop.property_id = trns.property_id"
			+" where prop.user_id=? and trns.date between ? and ?"
			+" GROUP BY expenseMonth,expenseYear,propertyId"
			+" order by propertyId,month(trns.date)";
	public List<CashFlowResultDto> getCashFlow(CashFlowInputDto cashFlowInputDto) {
		String query = CASH_FLOW_QUERY;
		return jdbcTemplate.query(query, new Object[]{cashFlowInputDto.getUserId(),cashFlowInputDto.getStartDate(), 
				cashFlowInputDto.getEndDate()}, new BeanPropertyRowMapper<>(CashFlowResultDto.class));		
	}
}
