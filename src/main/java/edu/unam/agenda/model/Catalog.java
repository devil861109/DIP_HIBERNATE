package edu.unam.agenda.model;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalog<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Integer id;
	protected String name;
	protected String status;

	abstract Integer getId();

	public void setId(Integer id) {
		this.id = id;
	}

	abstract String getName();

	public void setName(String name) {
		this.name = name;
	}

	abstract String getStatus();

	public void setStatus(String status) {
		this.status = status;
	}
}
