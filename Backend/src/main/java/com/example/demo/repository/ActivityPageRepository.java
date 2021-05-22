package com.example.demo.repository;

import com.example.demo.model.Pages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityPageRepository extends JpaRepository<Pages, Integer> {
    Pages findByTitle(String title);
    List<Pages> findAllByTitle(String title);
}
