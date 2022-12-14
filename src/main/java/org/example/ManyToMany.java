package org.example;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToMany {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Project project1 = new Project();
        Project project2 = new Project();

        employee1.setName("Mobin");
        employee2.setName("Horaira");

        project1.setName("ZiCharge");
        project2.setName("FastPay");

        List<Employee> employeeList = new ArrayList<Employee>();
        List<Project> projectList = new ArrayList<Project>();

        employeeList.add(employee1);
        employeeList.add(employee2);

        projectList.add(project1);
        projectList.add(project2);

        employee1.setProjects(projectList);
        project2.setEmployees(employeeList);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction trx = session.beginTransaction();
        session.getTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        trx.commit();

        session.close();
        factory.close();

    }
}
