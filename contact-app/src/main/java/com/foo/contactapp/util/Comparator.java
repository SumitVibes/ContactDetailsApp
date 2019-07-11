package com.foo.contactapp.util;

import java.util.Set;

import org.springframework.util.StringUtils;

import com.foo.contactapp.models.ContactDetails;
import com.foo.contactapp.models.Phone;

public class Comparator {

	/* Updates the desination object with non-null values in oriring */
	public static void mergeChanges(ContactDetails origin, ContactDetails dest) {

		if (!StringUtils.isEmpty(origin.email)) {
			dest.email = origin.email;
		}

		if (origin.address != null) {
			if (dest.address == null) {
				dest.address = origin.address;
			} else {
				if (!StringUtils.isEmpty(origin.address.street)) {
					dest.address.street = origin.address.street;
				}
				if (!StringUtils.isEmpty(origin.address.state)) {
					dest.address.state = origin.address.state;
				}
				if (!StringUtils.isEmpty(origin.address.zip)) {
					dest.address.zip = origin.address.zip;
				}
				if (!StringUtils.isEmpty(origin.address.city)) {
					dest.address.city = origin.address.city;
				}
			}
		}

		if (origin.name != null) {
			if (dest.name == null) {
				dest.name = origin.name;
			} else {
				if (!StringUtils.isEmpty(origin.name.first)) {
					dest.name.first = origin.name.first;
				}
				if (!StringUtils.isEmpty(origin.name.middle)) {
					dest.name.middle = origin.name.middle;
				}
				if (!StringUtils.isEmpty(origin.name.last)) {
					dest.name.last = origin.name.last;
				}
			}
		}

		if (origin.phone != null) {
			if (dest.phone == null) {
				dest.phone = origin.phone;
			} else {
				for (Phone p : origin.phone) {
					Phone oldPhone = getPhoneFromType(dest.phone, p.type);
					if(oldPhone != null) {
						oldPhone.number = p.number;						
					} else {
						dest.phone.add(p);
					}

				}
			}
		}

	}
	
	public static Phone getPhoneFromType(Set<Phone> phoneSet, String type) {
		for(Phone p : phoneSet) {
			if(p.type.equals(type)) {
				return p;
			}
		}
		return null;
		
		
	}
		
}
