/**
 * 
 */
package com.daofab.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.stereotype.Service;

import com.daofab.model.TransactionBean;
import com.daofab.model.TransactionResponseBean;
import com.daofab.repository.TransactionRepository;

/**
 * @author sayan
 *
 */

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;
	
	public List<TransactionResponseBean> list(Integer pageNumber) {
		System.out.println("Inside service");
		List<TransactionResponseBean> transactionPages = null;
		try {
//			Sort.by("transaction_id"))
			transactionPages = repository.findBySumPayment(PageRequest.of(pageNumber, 2)).getContent();
			System.out.println(transactionPages.toString());			
		}
		catch(PropertyReferenceException pre) {
			System.out.println(pre.getMessage());
			pre.printStackTrace();
		}
		return transactionPages;
    }

    public Iterable<TransactionBean> save(List<TransactionBean> transactions) {
        return repository.saveAll(transactions);
    }
}
