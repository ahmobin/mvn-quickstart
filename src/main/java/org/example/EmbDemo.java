package org.example;

import org.example.entities.Certificate;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Certificate certificate = new Certificate();
        certificate.setCourse("Hibernate");
        certificate.setDuration("3 Days");

        Student student = new Student();
        student.setName("Mobin");
        student.setCity("Dhaka");
        student.setCertificate(certificate);

        session.beginTransaction();

        session.save(student);

        session.getTransaction().commit();

        session.close();
        factory.close();

    }
}
