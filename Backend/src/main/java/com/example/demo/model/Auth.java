package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    public Auth(){ super();
    }

    public Auth(String role) {
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
                ", role='" + role + '\'' +
                ", users=" + users +
                '}';
    }
}
