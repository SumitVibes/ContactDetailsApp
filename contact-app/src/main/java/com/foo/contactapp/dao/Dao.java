package com.foo.contactapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foo.contactapp.dto.ContactDTO;
import com.foo.contactapp.repo.ContactRepo;

@Service
public class Dao {

	@Autowired
	private ContactRepo contactRepo;
	
	public ContactDTO saveEntity(ContactDTO dto) {
		return contactRepo.save(dto);
	}
	
	public ContactDTO getEntityById(Long id) {
		Optional<ContactDTO> resp = contactRepo.findById(id);
		if(resp.isPresent()) {
			return resp.get();
		}else {
			return null;
		}
	}
	
	public List<ContactDTO> getAll(){
		return contactRepo.findAll();
	}
	
	
	public void deleteById(Long id) {
		contactRepo.deleteById(id);
	}
}
