package com.example.demo.repository;

import com.example.demo.model.ImageTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository <ImageTable, Long> {
    Optional<ImageTable> findByName(String name);
}
