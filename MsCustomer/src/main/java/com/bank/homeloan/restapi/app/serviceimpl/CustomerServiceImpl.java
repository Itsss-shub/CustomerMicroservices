package com.bank.homeloan.restapi.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bank.homeloan.restapi.app.exception.CustomerApplicationsNotFoundException;
import com.bank.homeloan.restapi.app.model.CustomerDetails;
import com.bank.homeloan.restapi.app.repository.CustomerRepo;
import com.bank.homeloan.restapi.app.servicei.CustomerServiceI;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	@Autowired
	CustomerRepo cri;

	@Override
	public CustomerDetails getApplications(String customerUsername, String customerPassword) {
		Optional<CustomerDetails> app = cri.findByCustomerUsernameAndCustomerPassword(customerUsername,
				customerPassword);
		if (!app.isEmpty()) {
			CustomerDetails appl = app.get();
			return appl;
		} else {
			throw new CustomerApplicationsNotFoundException("No data present in database for this username and password ..!!!");
		}

	}

	@Override
	public CustomerDetails updateStatusAccepted(Integer customerDetailsId) {
		Optional<CustomerDetails> app = cri.findById(customerDetailsId);
		if (app.isPresent()) {
			CustomerDetails appl = app.get();
			appl.setStatus("accepted");
			return cri.save(appl);
		} else {
			throw new CustomerApplicationsNotFoundException("No data present in database for this id ..!!!");
		}

	}

	@Override
	public CustomerDetails updateStatusRejected(Integer customerDetailsId) {
		Optional<CustomerDetails> app = cri.findById(customerDetailsId);
		
		if(!app.isEmpty())
		{
			CustomerDetails appl = app.get();
			appl.setStatus("rejected");
			return cri.save(appl);
		}else {
			
			throw new CustomerApplicationsNotFoundException("No data present in database for this id ..!!!");
			
		}	
	}

}
