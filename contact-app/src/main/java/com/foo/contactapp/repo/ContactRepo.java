package com.foo.contactapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foo.contactapp.dto.ContactDTO;

@Repository
public interface ContactRepo extends JpaRepository<ContactDTO, Long> {

	
}
