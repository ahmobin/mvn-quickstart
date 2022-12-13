package org.example;

import org.example.entities.Certificate;
import org.example.entities.Degree;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyToOne {

    public static void main(String[] args) {

        Certificate certificate = new Certificate();
        certificate.setCourse("Hibernate");
        certificate.setDuration("3 Days");

        Student newStudent = new Student();
        newStudent.setName("Abu Horaira Mobin");
        newStudent.setCity("Dhaka");
        newStudent.setCity("Dhaka");
        newStudent.setCertificate(certificate);

        Degree degree1 = new Degree();
        degree1.setName("SSC");
        degree1.setStudent(newStudent);

        Degree degree2 = new Degree();
        degree2.setName("HSC");
        degree2.setStudent(newStudent);

        Degree degree3 = new Degree();
        degree3.setName("CSE");
        degree3.setStudent(newStudent);

        List<Degree> degrees = new ArrayList<Degree>();
        degrees.add(degree1);
        degrees.add(degree2);
        degrees.add(degree3);

        newStudent.setDegrees(degrees);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction trx = session.beginTransaction();

        session.save(degree1);
        session.save(degree2);
        session.save(degree3);

        session.save(newStudent);

        trx.commit();

        Student myStudent = session.get(Student.class, 1);
        System.out.println(myStudent.getCertificate().getCourse());

        for (Degree deg : myStudent.getDegrees()){
            System.out.println(deg.getName());
        }

        session.close();
        factory.close();

    }
}
