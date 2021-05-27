package com.example.demo.repository;

import com.example.demo.model.ImageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository <ImageTable, Long> {
    Optional<ImageTable> findByName(String name);
    @Query("FROM ImageTable WHERE review.id = ?1")
//    @Query(value = "SELECT * FROM image_table WHERE reference_id = ?1",nativeQuery = true)
    ImageTable findByReferenceId(int id);


}
