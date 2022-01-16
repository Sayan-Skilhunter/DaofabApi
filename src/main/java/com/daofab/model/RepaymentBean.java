/**
 * 
 */
package com.daofab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sayan
 *
 */

@Data
@Entity
@Table(name = "repayment_master")
@NoArgsConstructor
@AllArgsConstructor
public class RepaymentBean {

	@Id
//	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "repayment_id")
	Integer id;
	@Column(name = "parent_id")
	Integer parentId;
	@Column(name = "paid_amount")
	Float paidAmount;
}
