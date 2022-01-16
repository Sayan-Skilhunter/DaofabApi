/**
 * 
 */
package com.daofab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daofab.model.RepaymentBean;
import com.daofab.model.RepaymentResponseBean;
import com.daofab.repository.RepaymentRepository;

/**
 * @author sayan
 *
 */

@Service
public class RepaymentService {
	
	@Autowired
	RepaymentRepository repository;

	public List<RepaymentResponseBean> list(Integer id) {
        return repository.findAllByParent(id);
    }

	public Iterable<RepaymentBean> save(List<RepaymentBean> transactions) {
        return repository.saveAll(transactions);
    }
}
