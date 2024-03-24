package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.ContactDAO;
import edu.unam.agenda.model.Contact;
import edu.unam.agenda.model.MeansContacts;
import edu.unam.agenda.model.PhoneType;
import edu.unam.agenda.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
	private static ContactDAOImpl instance;

	private ContactDAOImpl() {
	}

	public static ContactDAOImpl getInstance() {
		if (instance == null) {
			instance = new ContactDAOImpl();
		}
		return instance;
	}

	@Override
	public Contact getContactById(Integer id) {
		Contact contact = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			contact = session.get(Contact.class, id);
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//catalogo = session.createQuery("FROM Contact").list();
			contactList = session.createQuery("FROM Contact", Contact.class).getResultList();
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return contactList;
	}

	@Override
	public Boolean insertContact(Contact contacto) {
		Boolean save = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//session.save(contacto);
			session.persist(contacto);
			save = contacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return save;
	}

	@Override
	public Boolean updateContact(Contact contacto) {
		Boolean update = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//session.update(contacto);
			session.merge(contacto);
			update = contacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return update;
	}

	@Override
	public Boolean deleteContact(Contact contacto) {
		Boolean delete = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(contacto);
			delete = contacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return delete;
	}

	@Override
	public List<MeansContacts> getPhoneTypes(PhoneType medioContacto) {
		List<MeansContacts> meansContactsList = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			//contactosMedio = (List<ContactoMedio>) session
			//		.createQuery("SELECT cm FROM ContactoMedio cm WHERE cm.medioContacto.id =:idMedioContacto")
			//		.setParameter("idMedioContacto", medioContacto.getId()).list();
			meansContactsList = session.createQuery("SELECT cm FROM MeansContacts cm WHERE cm.phoneType.id =:idMedioContacto",
					MeansContacts.class).setParameter("idMedioContacto", medioContacto.getId()).getResultList();
			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return meansContactsList;
	}
}

