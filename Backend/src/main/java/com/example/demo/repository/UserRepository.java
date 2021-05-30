package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
//    List<Users> findAllById(int id);
    Users findById(int id);
    Users findByMail(String mail);
    Users deleteById(int id);
}
