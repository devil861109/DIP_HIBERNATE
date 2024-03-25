package edu.unam.agenda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "means_contact")
public class MeansContacts {
	private Integer id;
	private String value;
	private Contact contact;
	private PhoneType phoneType;

	@Id
	@Column(name = "means_contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "value", length = 300)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id")
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@ManyToOne(targetEntity = PhoneType.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "phone_type_id", nullable = false, referencedColumnName = "phone_type_id")
	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	@Override
	public String toString() {
		return "ContactoMedio [id=" + id + ", valor=" + value + "]";
	}
}
