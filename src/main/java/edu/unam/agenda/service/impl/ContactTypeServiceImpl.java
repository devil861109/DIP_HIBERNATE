package edu.unam.agenda.service.impl;

import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.service.ContactTypeService;

import java.util.List;

public class ContactTypeServiceImpl implements ContactTypeService {
	
	private static ContactTypeServiceImpl instance;
	
	private ContactTypeServiceImpl() {
		
	}
	
	public static ContactTypeServiceImpl getInstance() {
		if (instance == null) {
			instance = new ContactTypeServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<ContactType> getAllContactType() {
		return null;
	}
	
	@Override
	public ContactType getContactTypeById(Integer id) {
		return null;
	}

	@Override
	public Boolean insertContactType(ContactType contactType) {
		return null;
	}
	
	@Override
	public Boolean updateContactType(ContactType contactType) {
		return null;
	}
	
	@Override
	public Boolean deleteContactType(ContactType contactType) {
		return null;
	}
}
