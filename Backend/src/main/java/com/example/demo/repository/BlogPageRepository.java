package com.example.demo.repository;

import com.example.demo.model.BlogPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPageRepository extends JpaRepository<BlogPage, Integer> {
  List<BlogPage> findAllById(int id);
  BlogPage deleteById(int id);
  BlogPage findByTitle(String title);
  BlogPage findById(int id);
}
