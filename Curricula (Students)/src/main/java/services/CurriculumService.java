/* CurriculumService.java
 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.CurriculumRepository;
import domain.Curriculum;
import domain.Customer;

@Service
@Transactional
public class CurriculumService {

	// Managed repository -------------------------------------------------

	@Autowired
	private CurriculumRepository curriculumRepository;
	
	// Supporting services ------------------------------------------------
	
	@Autowired
	private CustomerService customerService;
		
	// Constructors -------------------------------------------------------
	
	public CurriculumService() {
		super();
	}

	// Simple CRUD methods ------------------------------------------------
	
	public Curriculum create() {
		Curriculum result;
		Customer customer;
		
		customer = customerService.findByPrincipal();
		result = new Curriculum();		
		result.setCustomer(customer);
		
		return result;
	}
	
	public Curriculum findOneToEdit(int curriculumId) {
		Curriculum result;
		
		result = curriculumRepository.findOne(curriculumId);
		checkPrincipal(result);
		
		return result;
	}

	public Collection<Curriculum> findByPrincipal() {
		Collection<Curriculum> result;
		Customer customer;
		
		customer = customerService.findByPrincipal();
		result = curriculumRepository.findByCustomerId(customer.getId());
		
		return result;
	}

	public void save(Curriculum curriculum) {
		checkPrincipal(curriculum);
		curriculumRepository.save(curriculum);		
	}
	
	public void delete(Curriculum curriculum) {
		checkPrincipal(curriculum);
		curriculumRepository.delete(curriculum);		
	}
			
	// Other business methods ---------------------------------------------


	private void checkPrincipal(Curriculum curriculum) {
		Customer customer;
		
		customer = customerService.findByPrincipal();
		Assert.isTrue(curriculum.getCustomer().equals(customer));		
	}
}
