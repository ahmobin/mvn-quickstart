package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;

    private Certificate certificate;

    @OneToMany(mappedBy = "student")
    private List<Degree> degrees;


    public Student() {
        super();
    }

    public Student(int id, String name, String city, Certificate certificate, List<Degree> degrees) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.certificate = certificate;
        this.degrees = degrees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", certificate=" + certificate +
                ", degrees=" + degrees +
                '}';
    }
}
