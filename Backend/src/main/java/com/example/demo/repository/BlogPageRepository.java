package com.example.demo.repository;

import com.example.demo.model.BlogPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPageRepository extends JpaRepository<BlogPage, Integer> {
  BlogPage findById(int id);
  List<BlogPage> findAllById(int id);
}
