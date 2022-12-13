package org.example;

import org.example.entities.Address;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {


    public static void main(String[] args) {

        System.out.println("=== Difference Between get() and load() ======");
        System.out.println("=== get() ===");
        System.out.println("Select the object from database and store to session for the first time, further if the object stored in session, it will fetch from session. ");
        System.out.println("If an object are not available in database get() will return -> null");
        System.out.println("=== load() ===");
        System.out.println("Select the object from database and copy as proxy, after it return object from the proxy.");
        System.out.println("If an object are not available in database load() will throw -> ObjectNotFoundException");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        //fetch user data using get().
        Student student = session.get(Student.class,1);
        Student studentNotInDb = session.get(Student.class,4);
        System.out.println(student);
        System.out.println(studentNotInDb);

        //fetch address data using load().
        Address address = session.load(Address.class,1);
        Address addressNotInDb = session.load(Address.class,4);
        System.out.println(address.getCity());
        System.out.println(addressNotInDb);

        session.close();
        factory.close();
    }
}
