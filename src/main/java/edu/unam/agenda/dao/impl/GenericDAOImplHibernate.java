package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.GenericDAO;
import edu.unam.agenda.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {
	
	//private Class<T> persistenClass;
	SessionFactory sessionFactory;

	public GenericDAOImplHibernate() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
		//this.persistenClass = findEntityClass();
	}

	@Override
	public void save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} catch (Exception exc) {
				System.out.println("Fallo al hacer un rollback=" + exc);
			}
			throw ex;
		}
	}

	@Override
	public T get(ID id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			T entity = (T) session.get(findEntityClass(), id);
			session.getTransaction().commit();

			return entity;
		} catch (Exception ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} catch (Exception exc) {
				System.out.println("Fallo al hacer un rollback=" + exc);
			}
			throw ex;
		}
	}

	@Override
	public void delete(ID id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			T entity = (T) session.get(findEntityClass(), id);
			if (entity != null) {
				session.delete(entity);
				session.getTransaction().commit();
			}

		} catch (Exception ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} catch (Exception exc) {
				System.out.println("Fallo al hacer un rollback=" + exc);
			}
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> entities = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			entities = session.createQuery("SELECT e FROM " + findEntityClass().getName() + " e").getResultList();
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return entities;
	}

	@SuppressWarnings("unchecked")
	public final Class<T> findEntityClass() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		for (Type type : genericSuperClass.getActualTypeArguments()) {
			if (type instanceof ParameterizedType) {
				return (Class<T>)((ParameterizedType) type).getRawType();
			} else if (type instanceof Class<?>) {
				return (Class<T>)type;
			}
		}
		return null;
	}
}
