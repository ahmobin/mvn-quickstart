package org.example.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 64)
    private String street;

    @Column(length = 64)
    private String city;

    @Column(name = "is_open")
    private boolean isOpen;

    @Transient //it means it property / column will not create in table
    private double x;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Lob //it means this column accept large object
    private byte[] image;

    public Address(int id, String street, String city, boolean isOpen, double x, Date createdAt, byte[] image) {
        super();
        this.id = id;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.createdAt = createdAt;
        this.image = image;
    }

    public Address() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX(double v) {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", createdAt=" + createdAt +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
