package com.example.demo.repository;

import com.example.demo.model.Pages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityPageRepository extends JpaRepository<Pages, Integer> {
    List<Pages> findAllByTitle(String title);
    Pages deleteById(int id);
//    Pages findById(int id);
    Pages findByTitle(String title);
}
