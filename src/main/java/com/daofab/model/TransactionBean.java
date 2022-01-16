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
@Entity
@Table(name = "transaction_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionBean {
	
	@Id
	@Column(name = "transaction_id")
//	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	Integer id;
	@Column(name = "sender_name")
	String sender;
	@Column(name = "receiver_name")
	String receiver;
	@Column(name = "total_amount")
	Float totalAmount;
//	@Column(insertable = false, updatable = false)
//	Float sum_paid_amount;
}
