package edu.unam.agenda.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contact")
@NamedQueries(
		{@NamedQuery(name = "contactosAll", query = "FROM Contact"),
				@NamedQuery(name = "contactoById", query = "SELECT c FROM Contact c WHERE c.id = :id"),
				@NamedQuery(name ="contactosByTipo", query = "SELECT c FROM Contact c WHERE c.contactType.id = :idTipoContacto")
		})
public class Contact {
	private Integer id;
	private String name;
	private String lastName;
	private Integer age;
	private String address;
	private ContactType contactType;
	private Set<MeansContacts> meansContacts;

	@Id
	@Column(name = "contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "last_name", length = 200)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToOne(targetEntity = ContactType.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "contact_type_id", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN) //join al navegar en la propiedad
	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	public Set<MeansContacts> getMeansContacts() {
		return meansContacts;
	}

	public void setMeansContacts(Set<MeansContacts> meansContacts) {
		this.meansContacts = meansContacts;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + name + ", apellidos=" + lastName + ", edad=" + age
				+ ", direccion=" + address + ", tipoContacto=" + contactType + ", contactosMedios=" + meansContacts
				+ "]";
	}
}
