/**
 * 
 */
package com.daofab.repository;

import com.daofab.model.RepaymentBean;
import com.daofab.model.RepaymentResponseBean;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author sayan
 *
 */
public interface RepaymentRepository extends JpaRepository<RepaymentBean, Integer> {

	@Query(value = "select s.repayment_id, t.sender_name, t.receiver_name, t.total_amount, s.paid_amount "
			+ "from transaction_master t, repayment_master s "
			+ "where t.transaction_id = s.parent_id "
			+ "and s.parent_id = ?1", nativeQuery = true)
	List<RepaymentResponseBean> findAllByParent(Integer id);
}
