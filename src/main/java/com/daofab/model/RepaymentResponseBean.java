/**
 * 
 */
package com.daofab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sayan
 *
 */

@Data
@NoArgsConstructor
public class RepaymentResponseBean {

	Integer id;
	String Sender;
	String Receiver;
	Float totalAmount;
	Float paidAmount;
}
