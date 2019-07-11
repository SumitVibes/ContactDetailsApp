package com.foo.contactapp.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.foo.contactapp.dto.AddressDTO;
import com.foo.contactapp.dto.ContactDTO;
import com.foo.contactapp.dto.NameDTO;
import com.foo.contactapp.dto.PhoneDTO;
import com.foo.contactapp.models.Address;
import com.foo.contactapp.models.ContactDetails;
import com.foo.contactapp.models.Name;
import com.foo.contactapp.models.Phone;

public class Converter {
	
	public static ContactDetails convertFromDto(ContactDTO contactDTO) {
		
		if(contactDTO != null) {
			ContactDetails contactDetails = new ContactDetails();
			Name name = convertFromDto(contactDTO.getName());
			Address address = convertFromDto(contactDTO.getAddress());
			Set<Phone> phones = convertFromDto(contactDTO.getPhone());
			contactDetails.address = address;
			contactDetails.phone = phones;
			contactDetails.name = name;
			contactDetails.email = contactDTO.getEmail();
			contactDetails.id = contactDTO.getId();
			
			return contactDetails;
			
			
		}
			
			return null;
	}
	
	public static Address convertFromDto(AddressDTO addressDto) {
		
		if(addressDto != null) {
			Address address = new Address();
			address.street = addressDto.getStreet();
			address.state = addressDto.getState();
			address.city = addressDto.getCity();
			address.zip = addressDto.getZip();
			return address;
		}
		
		return null;
		
	}
	
	public static Set<Phone> convertFromDto(Set<PhoneDTO> phoneDtos) {
		
		if(phoneDtos != null && phoneDtos.size() > 0) {
			
			Set<Phone> phones = new HashSet<>();
			
			for(PhoneDTO p : phoneDtos) {
				Phone phone = new Phone();
				phone.number = p.getNumber();
				phone.type = p.getType();
				phones.add(phone);
			}
			return phones;
		}
		
		return null;
	}
	
	
	public static Name convertFromDto(NameDTO nameDto) {
		if(nameDto != null) {
			Name name = new Name();
			name.first = nameDto.getFirstName();
			name.middle = nameDto.getMiddleName();
			name.last = nameDto.getLastName();
			return name;
			
		}
		return null;
	}
	
	public static ContactDTO convertToDto(ContactDetails contactDetails) {
			
		if(contactDetails != null) {
			
			AddressDTO addressDTO = convertToDto(contactDetails.address);
			Set<PhoneDTO> phoneDTO = convertToDto(contactDetails.phone);			
			NameDTO nameDTO = convertToDto(contactDetails.name);			
			ContactDTO contactDTO = new ContactDTO();
			contactDTO.setAddress(addressDTO);
			contactDTO.setPhone(phoneDTO);
			contactDTO.setName(nameDTO);
			contactDTO.setEmail(contactDetails.email);
			contactDTO.setId(contactDetails.id);
			return contactDTO;
			
		}
			
			return null;
	}
	
	public static AddressDTO convertToDto(Address address) {
		
		if(address != null) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setStreet(address.street);
			addressDTO.setCity(address.city);
			addressDTO.setZip(address.zip);
			addressDTO.setState(address.state);
			return addressDTO;
		}
		
		return null;
		
	}
	
	public static Set<PhoneDTO> convertToDto(Set<Phone> phones) {
		
		if(phones != null && phones.size() > 0) {
			
			Set<PhoneDTO> phoneDTOs = new HashSet<>();
			
			for(Phone p : phones) {
				PhoneDTO phoneDTO = new PhoneDTO();
				phoneDTO.setNumber(p.number);
				phoneDTO.setType(p.type);
				phoneDTOs.add(phoneDTO);
			}
			return phoneDTOs;
		}
		
		return null;
	}
	
	public static NameDTO convertToDto(Name name) {
		if(name != null) {
			NameDTO nameDTO = new NameDTO();
			nameDTO.setFirstName(name.first);
			nameDTO.setMiddleName(name.middle);
			nameDTO.setLastName(name.last);
			return nameDTO;
		}
		return null;
	}
	
}
