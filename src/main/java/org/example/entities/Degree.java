package org.example.entities;


import javax.persistence.*;

@Entity
@Table(name = "degrees")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 64, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Degree() {
        super();
    }

    public Degree(int id, String name, Student student) {
        this.id = id;
        this.name = name;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
