package edu.unam.agenda;

import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.service.CatalogService;
import edu.unam.agenda.service.impl.CatalogServiceImpl;

import java.util.List;

public class ContactTypeAPP {
	public static void main(String[] args) {
		HibernateUtil.init();

		//ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
		CatalogService catalogService = CatalogServiceImpl.getInstance();

		List<ContactType> listContactType = catalogService.getAllContactType();
		for (ContactType contactType : listContactType)
			System.out.println(contactType.toString());
	}
}
