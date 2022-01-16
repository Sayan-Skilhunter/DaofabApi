/**
 * 
 */
package com.daofab.cfgs;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.daofab.model.RepaymentBean;
import com.daofab.model.TransactionBean;
import com.daofab.service.RepaymentService;
import com.daofab.service.TransactionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sayan
 *
 */

@Configuration
public class JsonToObjectAutoConfiguration {

	@Bean(name = "parent")
	CommandLineRunner runner(TransactionService service) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<HashMap<String, List<TransactionBean>>> typeReference = new TypeReference<HashMap<String, List<TransactionBean>>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Parent.json");
			try {
				HashMap<String, List<TransactionBean>> data = mapper.readValue(inputStream,typeReference);
				System.out.println(data);
				List<TransactionBean> transactions = data.get("data");
				service.save(transactions);
				System.out.println("Transactions Saved!");
			} catch (IOException e){
				System.out.println("Unable to save transactions: " + e.getMessage());
			}
		};
	}

	@Bean(name = "child")
	CommandLineRunner runner(RepaymentService service) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<HashMap<String, List<RepaymentBean>>> typeReference = new TypeReference<HashMap<String, List<RepaymentBean>>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Child.json");
			try {
				HashMap<String, List<RepaymentBean>> data = mapper.readValue(inputStream,typeReference);
				System.out.println(data);
				List<RepaymentBean> repayments = data.get("data");
				service.save(repayments);
				System.out.println("Repayments Saved!");
			} catch (IOException e){
				System.out.println("Unable to save repayments: " + e.getMessage());
			}
		};
	}

}
