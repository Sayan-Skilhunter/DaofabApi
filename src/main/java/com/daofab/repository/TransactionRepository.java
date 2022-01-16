/**
 * 
 */
package com.daofab.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daofab.model.TransactionBean;
import com.daofab.model.TransactionResponseBean;

/**
 * @author sayan
 *
 */
public interface TransactionRepository extends JpaRepository<TransactionBean, Integer> {
	@Query(value = "select t.*,"
			+ "(select sum(s.paid_amount) sum from repayment_master s where t.transaction_id = s.parent_id) sum "
			+ "from transaction_master t order by t.transaction_id limit 2 offset ?1", nativeQuery = true)
	Page<TransactionResponseBean> findBySumPayment(Pageable pageable);
}
