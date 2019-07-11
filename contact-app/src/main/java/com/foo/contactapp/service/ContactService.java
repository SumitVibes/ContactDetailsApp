package com.foo.contactapp.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foo.contactapp.dao.Dao;
import com.foo.contactapp.dto.ContactDTO;
import com.foo.contactapp.exceptions.NotFoundException;
import com.foo.contactapp.models.ContactDetails;
import com.foo.contactapp.util.Converter;

@Service
public class ContactService {

	@Autowired
	Dao dao;

	public void deleteEntity(Long id) {
		dao.deleteById(id);
	}

	public Set<ContactDetails> getAllEntities() {

		List<ContactDTO> dtos = dao.getAll();
		
		if (dtos == null) {
			throw new NotFoundException();
		}
		
		return dtos.stream().map(d -> Converter.convertFromDto(d)).collect(Collectors.toSet());		

	}
	

	public ContactDetails getEntity(Long id) {

		ContactDTO contactDTO = dao.getEntityById(id);

		ContactDetails response = null;

		if (contactDTO != null) {
			response = Converter.convertFromDto(contactDTO);
		}

		if (response == null) {
			throw new NotFoundException();
		}
		return response;

	}

	public ContactDetails saveEntity(ContactDetails contactDetails) {

		ContactDTO contactDTO = Converter.convertToDto(contactDetails);

		ContactDTO saved = dao.saveEntity(contactDTO);
		return Converter.convertFromDto(saved);

	}
}
