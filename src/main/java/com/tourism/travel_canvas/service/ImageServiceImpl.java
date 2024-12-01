package com.tourism.travel_canvas.service;

import com.tourism.travel_canvas.model.Image;
import com.tourism.travel_canvas.repository.ImageRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@Service
public class ImageServiceImpl implements  ImageService{
   @Autowired
    private ImageRepository imageRepository;



    @Override
    public Image saveImage(MultipartFile file) throws IOException {
        // Log the file size to ensure it's being uploaded
        System.out.println("Uploading file: " + file.getOriginalFilename());
        System.out.println("File size: " + file.getSize());

        // Convert the file to byte array
        byte[] imageData = file.getBytes();
        System.out.println("Image data size: " + imageData.length);
        System.out.println("First few bytes: " + Arrays.toString(Arrays.copyOfRange(imageData, 0, Math.min(10, imageData.length))));

        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setImageData(imageData);


        // Save the image to the database
        return imageRepository.save(image);
    }


    @Override
    public byte[] getImageById(Integer id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        return image.getImageData(); // Return the image data (byte array)
    }


}
