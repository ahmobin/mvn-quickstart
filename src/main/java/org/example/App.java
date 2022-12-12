package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        //creating new student
        Student student1 = new Student(1, "Abu Horaira", "Dhaka");
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(student1);
        session.getTransaction().commit();

        session.close();
    }
}
