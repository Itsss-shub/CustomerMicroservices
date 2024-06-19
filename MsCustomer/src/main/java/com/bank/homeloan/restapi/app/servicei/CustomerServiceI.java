package com.bank.homeloan.restapi.app.servicei;

import java.util.List;

import com.bank.homeloan.restapi.app.model.CustomerDetails;

public interface CustomerServiceI {

	CustomerDetails getApplications(String customerUsername, String customerPassword);

	CustomerDetails updateStatusAccepted(Integer customerDetailsId);

	CustomerDetails updateStatusRejected(Integer customerDetailsId);

}
