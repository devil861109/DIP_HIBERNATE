package edu.unam.agenda.dao;

import edu.unam.agenda.model.Contact;
import edu.unam.agenda.model.ContactType;

import java.util.List;

public interface ContactTypeDAO extends GenericDAO<ContactType, Integer> {
	Contact getContactById(Integer id);

	/*ContactType getContactTypeById(Integer id);

	List<ContactType> getAllContactType();

	Boolean insertContactType(ContactType contactType);

	Boolean updateContactType(ContactType contactType);

	Boolean deleteContactType(ContactType contactType);*/
}

