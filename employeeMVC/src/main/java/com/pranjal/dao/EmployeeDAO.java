package com.pranjal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pranjal.model.Employee;

@Repository
@Transactional
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.save(emp);
    }

    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class).list();
    }

    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    public void updateEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.update(emp);
    }

    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
        }
    }
}