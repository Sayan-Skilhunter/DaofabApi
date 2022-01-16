/**
 * 
 */
package com.daofab.model;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sayan
 *
 */

@Data
@NoArgsConstructor
public class TransactionResponseBean {
	@Id
//	@Column(name = "transaction_id")
//	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	Integer id;
	String sender;
	String receiver;
	Float totalAmount;
	Float paidAmount;
}
