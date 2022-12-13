package org.example.entities;

import javax.persistence.Embeddable;

@Embeddable //mapped certificate object , those inject the object and all properties will insert as table
public class Certificate {

    private String course;
    private String duration;

    public Certificate() {
        super();
    }

    public Certificate(String course, String duration) {
        super();
        this.course = course;
        this.duration = duration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
