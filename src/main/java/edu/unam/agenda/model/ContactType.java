package edu.unam.agenda.model;

import jakarta.persistence.*;

@Entity //definir la entidad
@Table(name = "contact_type") //indicar el nombre de la tabla que representa
public class ContactType {
	private Integer id;
	private String name;
	private String status;

	@Id //indicar que la propiedad es una llave
	@Column(name = "contact_type_id") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
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
		return "TipoContacto [id=" + id + ", nombre=" + name + ", estatus=" + status + ", hashCode()=" + hashCode()
				+ "]";
	}
}
