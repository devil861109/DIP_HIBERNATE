package edu.unam.jdbc.dao;

import edu.unam.jdbc.model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAll();

    Person getById(Integer id);

    Integer insert(Person person);

    Integer update(Person person);
}
