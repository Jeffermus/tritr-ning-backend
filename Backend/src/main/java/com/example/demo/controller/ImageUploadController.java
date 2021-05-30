package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
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
    @Autowired
    PagesRepository pagesRepository;
    @Autowired
    BlogPageRepository blogPageRepository;
    @Autowired
    AboutRepository aboutRepository;

        CompressService compressService = new CompressService();

//    UPLOAD IMAGE -------
    @PostMapping(value="/upload", consumes =  "multipart/form-data")
    public BodyBuilder uploadImage(@RequestParam("imageFile")MultipartFile file, @RequestParam("author_id") int author_id, @RequestParam("page_id") int page_id, @RequestParam("blog_id") int blog_id, @RequestParam("about_id") int about_id) throws IOException {
        System.out.println("Orignal Image Byte Size - " + file.getBytes().length);

        if(author_id != 0){
            Review getReview = reviewRepository.getOne(author_id);

            ImageTable img = new ImageTable(file.getOriginalFilename(), file.getContentType(), compressService.compressBytes(file.getBytes()));
            img.setReview(getReview);
            imageRepository.save(img);
        }
        if(page_id != 0){
            Pages getPage = pagesRepository.getOne(page_id);

            ImageTable img = new ImageTable(file.getOriginalFilename(), file.getContentType(), compressService.compressBytes(file.getBytes()));
            img.setPages(getPage);
            imageRepository.save(img);
        }
        if(blog_id !=0){
            Blog getBlog = blogPageRepository.getOne(blog_id);

            ImageTable img = new ImageTable(file.getOriginalFilename(), file.getContentType(), compressService.compressBytes(file.getBytes()));
            img.setBlog(getBlog);
            imageRepository.save(img);
        }
        if(about_id !=0){
            About getAbout = aboutRepository.getOne(about_id);

            ImageTable img = new ImageTable(file.getOriginalFilename(), file.getContentType(), compressService.compressBytes(file.getBytes()));
            img.setAbout((getAbout));
            imageRepository.save(img);
        }


        return ResponseEntity.status(HttpStatus.OK);
    }

//    UPDATE IMAGE -------
    @PostMapping(value="/update", consumes = "multipart/form-data")
    public BodyBuilder updateImage(@RequestParam("imageFile")MultipartFile file, @RequestParam("author_id") int author_id) throws IOException {
//        System.out.println("Orignal Image Byte Size - " + file.getBytes().length);
        System.out.println("FIRST ID ======="+author_id);

        ImageTable objectToUpdate = imageRepository.findByActivityId(author_id);

        System.out.println("IMAGE========="+objectToUpdate);

        objectToUpdate.setName(file.getOriginalFilename());
        objectToUpdate.setType(file.getContentType());
        objectToUpdate.setPicByte(compressService.compressBytes(file.getBytes()));

        imageRepository.save(objectToUpdate);
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
