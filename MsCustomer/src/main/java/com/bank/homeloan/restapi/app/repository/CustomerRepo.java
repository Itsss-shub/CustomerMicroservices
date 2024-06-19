package com.bank.homeloan.restapi.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.homeloan.restapi.app.model.CustomerDetails;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDetails, Integer>{

	

	Optional<CustomerDetails> findByCustomerUsernameAndCustomerPassword(String customerUsername,
			String customerPassword);

	

}
