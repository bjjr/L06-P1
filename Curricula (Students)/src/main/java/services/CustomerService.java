/* CustomerService.java
 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.CustomerRepository;
import security.LoginService;
import security.UserAccount;
import domain.Customer;

@Service
@Transactional
public class CustomerService {

	// Repositories -----------------------------------------------------------

	@Autowired
	private CustomerRepository customerRepository;
	
	// Supporting services ----------------------------------------------------
	
	// Constructors -----------------------------------------------------------

	public CustomerService() {
		super();
	}
	
	// Simple CRUD methods ----------------------------------------------------
	
	// Other business methods -------------------------------------------------

	public Customer findByPrincipal() {
		Customer result;
		UserAccount userAccount;
	
		userAccount = LoginService.getPrincipal();
		result = customerRepository.findByUserAccountId(userAccount.getId());
	
		return result;
	}

}
