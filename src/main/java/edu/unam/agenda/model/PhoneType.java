package edu.unam.agenda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "phone_type")
public class PhoneType {
	private Integer id;
	private String name;
	private String status;

	@Id
	@Column(name = "phone_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", length = 50, nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TipoTelefono [id=" + id + ", nombre=" + name + ", estatus=" + status + "]";
	}
}
