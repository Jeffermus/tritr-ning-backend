package com.example.demo.repository;

import com.example.demo.model.ImageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository <ImageTable, Long> {

    @Query("FROM ImageTable WHERE review.id = ?1")
    Optional<ImageTable> findById(int id);

    @Query(value = "FROM  ImageTable order by review.id")
    List <ImageTable> findAllByReview();

    Optional<ImageTable> findByName(String name);
    @Query("FROM ImageTable WHERE review.id = ?1")
//    @Query(value = "SELECT * FROM image_table WHERE reference_id = ?1",nativeQuery = true)
    ImageTable findByActivityId(int id);

    @Query("FROM ImageTable WHERE pages.id = ?1 AND name = ?2")
    ImageTable findByPagesId(int id, String name);


//    LOOK FOR IMAGES FOR CHILD TABLE ==========
    @Query("FROM ImageTable WHERE name = ?1 and pages.id = ?2")
    ImageTable findPageImageWithName(String name, int id);

    @Query("FROM ImageTable WHERE name = ?1 and review.id = ?2")
    ImageTable findReviewImageWithName(String name, int id);

    @Query("FROM ImageTable WHERE name = ?1 and blog.id = ?2")
    ImageTable findBlogImageWithName(String name, int id);

//    LOOK FOR IMAGES FOR PARENT TABLE ==========
    @Query("FROM ImageTable WHERE id = ?1 and pages.id = ?2")
    ImageTable findPagesImageWithId(Long image_id, int pages_id);

    @Query("FROM ImageTable WHERE id = ?1 and review.id = ?2")
    ImageTable findReviewImage(Long image_id, int review_id);

    @Query("FROM ImageTable WHERE id = ?1 and blog.id = ?2")
    ImageTable findBlogImageWithId(Long image_id, int blog_id);


}
