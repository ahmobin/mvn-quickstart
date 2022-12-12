package org.example;

import org.example.entities.Address;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        //creating new student
        Student student1 = new Student(1, "Abu Horaira", "Dhaka");
        Address address1 = new Address();
        address1.setStreet("street name");
        address1.setCity("city name");
        address1.setOpen(true);
        address1.setX(5841211.545100);
        address1.setCreatedAt(new Date());
        FileInputStream fs = new FileInputStream("src/main/resources/starter.jpg");
        byte[] data = new byte[fs.available()];
        fs.read(data);
        address1.setImage(data);

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(student1);
        session.save(address1);
        session.getTransaction().commit();

        session.close();
    }
}
