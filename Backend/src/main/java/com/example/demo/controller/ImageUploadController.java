package com.example.demo.controller;

import com.example.demo.model.ImageTable;
import com.example.demo.model.Review;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.CompressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "image")
public class ImageUploadController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ReviewRepository reviewRepository;

    CompressService compressService = new CompressService();


//    UPLOAD IMAGE -------
    @PostMapping(value="/upload", consumes = "multipart/form-data")
    public BodyBuilder uploadImage(@RequestParam("imageFile")MultipartFile file, @RequestParam("author_id") int author_id) throws IOException {
        System.out.println("Orignal Image Byte Size - " + file.getBytes().length);
        System.out.println("FIRST ID ======="+author_id);

        Review getReview = reviewRepository.getOne(author_id);
        System.out.println("SECCOND ID =========="+getReview.getId());

        ImageTable img = new ImageTable(file.getOriginalFilename(), file.getContentType(), compressService.compressBytes(file.getBytes()));
        img.setReview(getReview);
        imageRepository.save(img);
        return ResponseEntity.status(HttpStatus.OK);
    }

//    GET IMAGE ------
    @GetMapping(path = {"/get/{imageName}"})
    public byte[] getImage(@PathVariable("imageName") String imageName) throws IOException{
        final Optional<ImageTable> retrivedImage = imageRepository.findByName(imageName);
        ImageTable img = new ImageTable(retrivedImage.get().getName(), retrivedImage.get().getType(), compressService.decompressBytes(retrivedImage.get().getPicByte()));
        return img.getPicByte();
    }
}
