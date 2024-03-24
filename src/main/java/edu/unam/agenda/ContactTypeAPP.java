package edu.unam.agenda;

import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.service.ContactTypeService;
import edu.unam.agenda.service.impl.ContactTypeServiceImpl;

import java.util.List;

public class ContactTypeAPP {
	public static void main(String[] args) {
		HibernateUtil.init();

		ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();

		List<ContactType> listContactType = contactTypeService.getAllContactType();
		for (ContactType contactType : listContactType)
			System.out.println(contactType.toString());
	}
}
