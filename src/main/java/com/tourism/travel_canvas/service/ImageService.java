package com.tourism.travel_canvas.service;

import com.tourism.travel_canvas.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    public byte[] getImageById(Integer id);

    public Image saveImage(MultipartFile file) throws IOException;




}
