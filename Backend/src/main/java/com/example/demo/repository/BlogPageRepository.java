package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPageRepository extends JpaRepository<Blog, Integer> {
  List<Blog> findAllById(int id);
  Blog deleteById(int id);
  Blog findByTitle(String title);
  Blog findById(int id);
}
