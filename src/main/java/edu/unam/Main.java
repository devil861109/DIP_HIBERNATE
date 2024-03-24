package edu.unam;

import edu.unam.jdbc.dao.PersonDAO;
import edu.unam.jdbc.dao.PersonDAOImpl;
import edu.unam.jdbc.model.Person;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonDAO personDAO = new PersonDAOImpl();

        // Get By Id
        System.out.println("-- Get By Id --");
        System.out.println("Dame registro a buscar: ");
        int rec = scanner.nextInt();
        Person person = personDAO.getById(rec);
        if (person == null)
            System.out.println("No existe registro con ese id: " + rec);
        else
            System.out.println(person);

        // Get All
        System.out.println("\n\n-- Get All --");
        List<Person> list = personDAO.getAll();
        for (Person single : list) {
            System.out.println(single.toString());
        }

        // Insert
        System.out.println("\n\n-- Insert --");
        Person personInsert = new Person();
        System.out.println("Dame apellido: ");
        String scan = scanner.next();
        personInsert.setLastName(scan);
        System.out.println("Dame nombre: ");
        scan = scanner.next();
        personInsert.setFirstName(scan);
        int record = personDAO.insert(personInsert);
        personInsert.setPersonId(record);
        System.out.println("Elemento insertado ok, llave generada: " + record);
        System.out.println(personInsert);

        // Update
        System.out.println("\n\n-- Update --");
        System.out.println("Dame registro a actualizar: ");
        int recUp = scanner.nextInt();
        Person personUpdate = personDAO.getById(recUp);
        if (person == null)
            System.out.println("No existe registro con ese id: " + recUp);
        else {
            System.out.println("Dame apellido: ");
            String scanUp = scanner.next();
            personUpdate.setLastName(scanUp);
            System.out.println("Dame nombre: ");
            scanUp = scanner.next();
            personUpdate.setFirstName(scanUp);
            int recrd = personDAO.update(personUpdate);
            System.out.println("Elemento actualizado ok, id: " + recrd);
            System.out.println(personUpdate);
        }
    }
}