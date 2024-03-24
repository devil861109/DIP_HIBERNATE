package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.ContactDAO;
import edu.unam.agenda.model.Contact;
import edu.unam.agenda.model.MeansContacts;
import edu.unam.agenda.model.PhoneType;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
	private static ContactDAOImpl instance;

	private ContactDAOImpl() {
	}

	public static ContactDAOImpl getInstance() {
		if (instance == null)
			instance = new ContactDAOImpl();
		return instance;
	}

	@Override
	public Contact getContactById(Integer id) {
		Contact contact = null;
		//completar
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = null;
		//completar
		return contactList;
	}

	@Override
	public Boolean insertContact(Contact contact) {
		Boolean save = Boolean.FALSE;
		//completar
		return save;
	}

	@Override
	public Boolean updateContact(Contact contact) {
		Boolean update = Boolean.FALSE;
		//completar
		return update;
	}

	@Override
	public Boolean deleteContact(Contact contact) {
		Boolean delete = Boolean.FALSE;
		//completar
		return delete;
	}

	@Override
	public List<MeansContacts> getPhoneTypes(PhoneType phoneType) {
		List<MeansContacts> meansContactsList = null;
		//completar
		return meansContactsList;
	}
}
