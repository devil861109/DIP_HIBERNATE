package edu.unam.agenda;

import edu.unam.agenda.model.MeansContacts;
import edu.unam.agenda.model.PhoneType;
import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.service.CatalogService;
import edu.unam.agenda.service.ContactService;
import edu.unam.agenda.service.impl.CatalogServiceImpl;
import edu.unam.agenda.service.impl.ContactServiceImpl;

import java.util.List;

public class PhoneTypeAPP {

	public static void main(String[] args) {
		HibernateUtil.init();

		//PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
		CatalogService catalogService = CatalogServiceImpl.getInstance();
		ContactService contactService = ContactServiceImpl.getInstance();

		System.out.println("Carga Tipos Telefonos");
		List<PhoneType> listPhoneType = catalogService.getAllPhoneType();
		for (PhoneType phone : listPhoneType)
			System.out.println(phone.toString());

		System.out.println("Carga Tipos Telefonos por Id");
		PhoneType phoneType = catalogService.getPhoneTypeById(1);
		System.out.println(phoneType.toString());

		List<MeansContacts> contactosMedio = contactService.getPhoneTypes(phoneType);

		if (contactosMedio != null && ! contactosMedio.isEmpty()) {
			System.out.println("Los números de medio de contacto:" + phoneType.getName());
			for (MeansContacts meansContacts : contactosMedio) {
				System.out.println("El número es:"
						+ meansContacts.getValue()
						+ " y el nombre del contacto es:" + meansContacts.getContact().getName());
			}
		}
	}
}
