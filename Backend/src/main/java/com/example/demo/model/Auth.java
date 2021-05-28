package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mail;
    private String role;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users users;

    public Auth(){ super();
    }

    public Auth(String mail, String role) {
        this.mail = mail;
        this.role = role;
    }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", role='" + role + '\'' +
                ", users=" + users +
                '}';
    }
}
