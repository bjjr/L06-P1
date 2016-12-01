/* Curriculum.java
 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Curriculum extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Curriculum() {
		super();
	}

	// Attributes -------------------------------------------------------------
	
	private String title;
	private String academicRecord;
	private String professionalRecord;
	private String hobbies;

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAcademicRecord() {
		return academicRecord;
	}

	public void setAcademicRecord(String academicRecord) {
		this.academicRecord = academicRecord;
	}

	public String getProfessionalRecord() {
		return professionalRecord;
	}

	public void setProfessionalRecord(String professionalRecord) {
		this.professionalRecord = professionalRecord;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	// Relationships ----------------------------------------------------------

	private Customer customer;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
