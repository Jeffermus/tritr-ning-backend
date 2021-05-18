package com.example.demo.repository;

import com.example.demo.model.ActivityPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityPageRepository extends JpaRepository<ActivityPage, Integer> {
    ActivityPage findByTitle(String title);
    List<ActivityPage> findAllByTitle(String title);
}
