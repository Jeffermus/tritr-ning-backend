package com.example.demo.controller;

import com.example.demo.model.ImageModel;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.CompressService;
import javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "image")
public class ImageUploadController {

    @Autowired
    ImageRepository imageRepository;

    CompressService compressService = new CompressService();


//    UPLOAD IMAGE -------
    @PostMapping(value="/upload", consumes = "multipart/form-data")
    public BodyBuilder uploadImage(@RequestParam("imageFile")MultipartFile file) throws IOException {
        System.out.println("Orignal Image Byte Size - " + file.getBytes().length);
        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(), compressService.compressBytes(file.getBytes()));

        imageRepository.save(img);
        return ResponseEntity.status(HttpStatus.OK);
    }

//    GET IMAGE ------
    @GetMapping(path = {"/get/{imageName}"})
    public byte[] getImage(@PathVariable("imageName") String imageName) throws IOException{
        final Optional<ImageModel> retrivedImage = imageRepository.findByName(imageName);
        ImageModel img = new ImageModel(retrivedImage.get().getName(), retrivedImage.get().getType(), compressService.decompressBytes(retrivedImage.get().getPicByte()));
        return img.getPicByte();
    }
}
