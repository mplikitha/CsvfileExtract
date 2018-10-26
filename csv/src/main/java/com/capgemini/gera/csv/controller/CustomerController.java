package com.capgemini.gera.csv.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.gera.csv.model.Customer;
import com.capgemini.gera.csv.service.UploadCsvService;

@RestController
@RequestMapping("/api/v1/gera/csv")
public class CustomerController {
	
	@Autowired
	private UploadCsvService uploadCsvService;
	
	@Autowired
	public CustomerController(UploadCsvService uploadCsvService) {
		
		this.uploadCsvService = uploadCsvService;
	}

	@RequestMapping(value="/hii", method=RequestMethod.GET)
	public void hello() {
		System.out.println("hello, Working!!");
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public List<Customer> uploadFile(@RequestPart(value="file") MultipartFile multiPartFile) throws IOException{
		return uploadCsvService.uploadFile(multiPartFile);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	//@RequestMapping
	public List<Customer> getAllCustomers(){
		 List<Customer> res= uploadCsvService.getAllCustomer();
		 System.out.println(res);
		 return res;
	}
}


