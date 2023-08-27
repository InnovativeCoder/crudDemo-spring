package dev.jerry.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String Lastname;

    @Column(name="email")
    private String email;

    //define constructors

    public Student(){

    }

    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        Lastname = lastname;
        this.email = email;
    }

    //define getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname=" + firstname +
                ", Lastname=" + Lastname +
                ", email=" + email +
                '}';
    }
}
