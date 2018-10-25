package com.capgemini.gera.csv.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.gera.csv.model.Customer;
import com.capgemini.gera.csv.repository.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo customerRepo;
	
	public void batchStore(List<Customer> customerList) {
		//customerRepo.save(customerList);
		customerRepo.saveAll(customerList);
	}
	
public List<Customer> getCustomers(){
	return customerRepo.findAll();
}

}



