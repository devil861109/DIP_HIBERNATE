package edu.unam.agenda.service;

import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.model.PhoneType;

import java.util.List;

public interface CatalogService {
	List<ContactType> getAllContactType();

	ContactType getContactTypeById(Integer id);

	List<PhoneType> getAllPhoneType();

	PhoneType getPhoneTypeById(Integer id);
}
