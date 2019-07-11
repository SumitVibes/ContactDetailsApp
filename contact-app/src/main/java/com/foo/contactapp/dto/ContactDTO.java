package com.foo.contactapp.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="CONTACT")
public class ContactDTO {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private NameDTO name;

	@OneToOne(cascade=CascadeType.ALL)
	private AddressDTO address;

	@OneToMany(cascade=CascadeType.ALL)
	private Set<PhoneDTO> phone;
	
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NameDTO getName() {
		return name;
	}

	public void setName(NameDTO name) {
		this.name = name;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Set<PhoneDTO> getPhone() {
		return phone;
	}

	public void setPhone(Set<PhoneDTO> phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	
}


