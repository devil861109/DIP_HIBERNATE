package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.ContactTypeDAO;
import edu.unam.agenda.model.ContactType;

import java.util.List;

public class ContactTypeDAOImpl implements ContactTypeDAO {

	private static ContactTypeDAOImpl instance;

	private ContactTypeDAOImpl() {
	}

	public static ContactTypeDAOImpl getInstance() {
		if (instance == null)
			instance = new ContactTypeDAOImpl();
		return instance;
	}
	
	@Override
	public ContactType getContactTypeById(Integer id) {
		ContactType contactType = null;
		//completar código
		return contactType;
	}
	
	@Override
	public List<ContactType> getAllContactType() {
		List<ContactType> contactTypeList = null;
		//completar código
		return contactTypeList;
	}	
	
	@Override
	public Boolean insertContactType(ContactType contactType) {
		Boolean save = Boolean.FALSE;
		//Completar código
		return save;
	}
	
	@Override
	public Boolean updateContactType(ContactType contactType) {
		Boolean update = Boolean.FALSE;
		//Completar código
		return update;
	}
	
	@Override
	public Boolean deleteContactType(ContactType contactType) {
		Boolean delete = Boolean.FALSE;
		//Completar código
		return delete;
	}
}
