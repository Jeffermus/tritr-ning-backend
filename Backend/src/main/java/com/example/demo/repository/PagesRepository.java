package com.example.demo.repository;

import com.example.demo.model.Pages;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PagesRepository extends JpaRepository<Pages, Integer> {
    Pages deleteById(int id);
    Pages findByTitle(String title);
}
