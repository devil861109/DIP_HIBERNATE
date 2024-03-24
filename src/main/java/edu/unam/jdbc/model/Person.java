package edu.unam.jdbc.model;

public class Person {
	private Integer personId;
	private String lastName;
	private String firstName;

	public Person() {
	}

	public Person(Integer personId, String lastName, String firstName) {
		this.personId = personId;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Person{" +
				"personId=" + personId +
				", lastName='" + lastName + '\'' +
				", firstName='" + firstName + '\'' +
				'}';
	}
}
