package com.example.demo.repository;

import com.example.demo.model.Pages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PagesRepository extends JpaRepository<Pages, Integer> {
    List<Pages> findAllByTitle(String title);
    List<Pages> findAllById(int id);

    @Query(value = "SELECT * FROM pages WHERE id = ?1", nativeQuery = true)
    Pages asd(int id);
    Pages deleteById(int id);
    Pages findById(int id);
    Pages findByTitle(String title);

    @Query(value = "SELECT * FROM pages WHERE id = ?1", nativeQuery = true)
    Pages findSpecificBy(int id);
}
