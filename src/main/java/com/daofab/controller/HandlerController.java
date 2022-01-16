/**
 * 
 */
package com.daofab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daofab.model.RepaymentResponseBean;
import com.daofab.model.TransactionResponseBean;
import com.daofab.service.RepaymentService;
import com.daofab.service.TransactionService;

/**
 * @author sayan
 *
 */

@Controller
public class HandlerController {

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	RepaymentService repaymentService;
	
	@GetMapping("/transactions/{index}")
	@ResponseBody
	public List<TransactionResponseBean> getAllTransactions(@PathVariable(name = "index") Integer pageNumber) {
		System.out.println("page : " + pageNumber);
		List<TransactionResponseBean> transactionList = null;
		try {
			transactionList = transactionService.list(pageNumber);
//			service.list(pageNumber).forEach(transactionList::add);
		}
		catch(Exception e) {
			e.getMessage();
		}		
		return transactionList;
//		return service.list(pageNumber);
	}
	
	@GetMapping("/repayments/{transactionId}")
	@ResponseBody
	public List<RepaymentResponseBean> getAllRepayments(@PathVariable(name = "transactionId") Integer id) {
		System.out.println("Parent Id : " + id);
		List<RepaymentResponseBean> transactionList = null;
		try {
			transactionList = repaymentService.list(id);
//			service.list(pageNumber).forEach(transactionList::add);
		}
		catch(Exception e) {
			e.getMessage();
		}		
		return transactionList;
	}
}
