package edu.unam.agenda.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	void save(T entity);
	T get(ID id);
	void delete(ID id);
	List<T> findAll();
}
