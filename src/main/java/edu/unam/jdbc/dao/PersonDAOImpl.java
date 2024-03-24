package edu.unam.jdbc.dao;

import edu.unam.jdbc.JDBCUtil;
import edu.unam.jdbc.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public List<Person> getAll() {
        List<Person> list = new ArrayList<>();
        String query = "SELECT person_id, last_name, first_name FROM person";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    list.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Person getById(Integer id) {
        String query = "SELECT person_id, last_name, first_name FROM person WHERE person_id = ?";
        Person person = null;
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Integer insert(Person person) {
        int id = 0;
        String query = "INSERT INTO person(last_name, first_name) VALUES (?,?)";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, person.getLastName());
            ps.setString(2, person.getFirstName());
            int affectedRows = ps.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Integer update(Person person) {
        int id = person.getPersonId();
        String query = "UPDATE person SET last_name = ?, first_name = ? WHERE person_id = ?";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, person.getLastName());
            ps.setString(2, person.getFirstName());
            ps.setInt(3, id);
            int affectedRows = ps.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
