package com.foo.contactapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foo.contactapp.exceptions.ValidatorException;
import com.foo.contactapp.models.ContactDetails;
import com.foo.contactapp.models.Phone;
import com.foo.contactapp.service.ContactService;
import com.foo.contactapp.util.Comparator;
import com.foo.contactapp.util.Constants;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("/{id}")
	public ContactDetails getContacts(@PathVariable("id") Long id) {
		return contactService.getEntity(id);
	}

	@GetMapping
	public Set<ContactDetails> getAlleContacts() {
		return contactService.getAllEntities();
	}

	@PostMapping
	public ContactDetails saveContacts(@RequestBody ContactDetails contactDetails) {
		validateBody(contactDetails);
		return contactService.saveEntity(contactDetails);
	}

	@PutMapping("/{id}")
	public ContactDetails updateContacts(@PathVariable("id") Long id, @RequestBody ContactDetails contactDetails) {
		validateBody(contactDetails);
		ContactDetails resp = contactService.getEntity(id);
		Comparator.mergeChanges(contactDetails, resp);
		return contactService.saveEntity(resp);

	}

	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable("id") Long id) {
		contactService.deleteEntity(id);
	}

	private void validateBody(ContactDetails contactDetails) {

		if (contactDetails != null && contactDetails.phone != null) {
			for (Phone p : contactDetails.phone) {
				if (!Constants.phoneTypes.contains(p.type)) {
					throw new ValidatorException("Phone can only be of mobile|home|work type");

				}
			}
		}

	}

}
