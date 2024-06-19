package com.bank.homeloan.restapi.app.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.homeloan.restapi.app.model.CustomerDetails;
import com.bank.homeloan.restapi.app.servicei.CustomerServiceI;


import lombok.extern.slf4j.Slf4j;




@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/bank/homeloan/restapi/customer" )
public class CustomerController {
	
	@Autowired
	CustomerServiceI csi;
	
	
	@GetMapping("/getCustomerData/{customerUsername}/{customerPassword}")
	public ResponseEntity<CustomerDetails> getApplications(@PathVariable String customerUsername,@PathVariable String customerPassword  ){
		System.out.println(customerUsername);
		System.out.println(customerPassword);
		CustomerDetails customerList=	csi.getApplications(customerUsername,customerPassword);
		log.info("loan application fetch from database...!!!"+"namae : "+customerUsername+"password : "+customerPassword);
		
		return new ResponseEntity<CustomerDetails>(customerList,HttpStatus.OK);
	}
	
	
	
	@PatchMapping("/updateLoanAccepted/{customerDetailsId}")
	public ResponseEntity<CustomerDetails> updateStatusAccepted (@PathVariable Integer customerDetailsId,@RequestBody CustomerDetails c){
		
		CustomerDetails customer=	csi.updateStatusAccepted(customerDetailsId);
		log.info("loan application appoved......  "+customer.getStatus());
		
		return new ResponseEntity<CustomerDetails>(customer,HttpStatus.OK);
	}
	
	@PatchMapping("/updateLoanRejected/{customerDetailsId}")
	public ResponseEntity<CustomerDetails> updateStatusRejected(@PathVariable Integer customerDetailsId,@RequestBody CustomerDetails c){
		
		CustomerDetails customer=	csi.updateStatusRejected(customerDetailsId);
		log.info("loan application rejected......  "+customer.getStatus());
		
		return new ResponseEntity<CustomerDetails>(customer,HttpStatus.OK);
	}
	
	


}
