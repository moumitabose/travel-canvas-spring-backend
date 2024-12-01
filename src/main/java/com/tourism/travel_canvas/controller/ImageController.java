package com.tourism.travel_canvas.controller;

import com.tourism.travel_canvas.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            imageService.saveImage(file);
            return "Image uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace(); // This will help with debugging the error
            return "Failed to upload image";
        }
    }


    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        try {
            byte[] imageData = imageService.getImageById(id); // Get image data from the service layer

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Set the correct MIME type (adjust for image format)
            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Return a 404 if the image is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
