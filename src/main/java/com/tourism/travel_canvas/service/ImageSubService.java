package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.tourism.travel_canvas.model.ImageSub;

public interface ImageSubService {
	
	public ImageSub saveSubImage(MultipartFile file) throws IOException;
	
	public List<ImageSub> getAllSubImageDetailsByDestinationId(ImageSub imageSub);

}
