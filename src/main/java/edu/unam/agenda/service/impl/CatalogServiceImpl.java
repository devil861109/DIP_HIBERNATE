package edu.unam.agenda.service.impl;

import edu.unam.agenda.dao.ContactTypeDAO;
import edu.unam.agenda.dao.PhoneTypeDAO;
import edu.unam.agenda.dao.impl.ContactTypeDAOImpl;
import edu.unam.agenda.dao.impl.PhoneTypeDAOImpl;
import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.model.PhoneType;
import edu.unam.agenda.service.CatalogService;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

	private static CatalogServiceImpl instance;

	private CatalogServiceImpl() {
	}

	public static CatalogServiceImpl getInstance() {
		if (instance == null) {
			instance = new CatalogServiceImpl();
		}
		return instance;
	}

	@Override
	public ContactType getContactTypeById(Integer id) {
		ContactTypeDAO dao = new ContactTypeDAOImpl();
		return dao.get(id);
	}

	@Override
	public List<ContactType> getAllContactType() {
		ContactTypeDAO dao = new ContactTypeDAOImpl();
		return dao.findAll();
	}

	@Override
	public List<PhoneType> getAllPhoneType() {
		PhoneTypeDAO dao = new PhoneTypeDAOImpl();
		return dao.findAll();
	}

	@Override
	public PhoneType getPhoneTypeById(Integer id) {
		PhoneTypeDAO dao = new PhoneTypeDAOImpl();
		return dao.get(id);
	}
}
