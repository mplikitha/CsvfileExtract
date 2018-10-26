package com.capgemini.gera.csv.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.gera.csv.dao.CustomerDao;
import com.capgemini.gera.csv.model.Customer;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class UploadCsvService {

@Autowired
private CustomerDao customerDao;


public List<Customer> uploadFile(MultipartFile multipartFile) throws IOException {
	
	File file= convertMultiPartToFile(multipartFile);
	List<Customer> missedCustomerList =new ArrayList<Customer>();
	
	try(Reader reader = new FileReader(file);){
		@SuppressWarnings("unchecked")
	CsvToBean<Customer> csvToBean = new CsvToBeanBuilder<Customer>(reader).withType(Customer.class)
			.withIgnoreLeadingWhiteSpace(true).build();
	List<Customer> customertList = csvToBean.parse();

	Iterator<Customer> customerListClone = customertList.iterator();
	while(customerListClone.hasNext()) {
		Customer customer=customerListClone.next();
		if(customer.getPhoneNo()==null || customer.getPhoneNo().isEmpty() || customer.getFirstName()==null
				|| customer.getFirstName().isEmpty()) {
			
			missedCustomerList.add(customer);
			customerListClone.remove();
			
		}
				
	}
	customerDao.batchStore(customertList);
	}
			return missedCustomerList;
}
	
private File convertMultiPartToFile(MultipartFile file) throws IOException {
	File convFile = new File(file.getOriginalFilename());
	FileOutputStream fos = new FileOutputStream(convFile);
	fos.write(file.getBytes());
	fos.close();
	return convFile;
}

	public List<Customer> getAllCustomer(){
		return customerDao.getCustomers();
	}
}

	