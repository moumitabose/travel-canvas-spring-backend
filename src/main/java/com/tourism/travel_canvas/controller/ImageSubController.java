package com.tourism.travel_canvas.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tourism.travel_canvas.model.ImageSub;
import com.tourism.travel_canvas.service.ImageService;
import com.tourism.travel_canvas.service.ImageSubService;

@RestController
@CrossOrigin
public class ImageSubController {

	@Autowired
	private ImageSubService imageSubService;

	@PostMapping("/uploadSubImage")
	public ResponseEntity<ImageSub> uploadSubImage(@RequestParam("file") MultipartFile file) throws IOException {
		ImageSub savedImage = imageSubService.saveSubImage(file);
		return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
	}

	@GetMapping("/getAllSubImageDetailsByDestinationId")
	public ResponseEntity<List<ImageSub>> getAllSubImageDetailsByDestinationId(@RequestBody ImageSub imageSub) {

		List<ImageSub> resultImageSub = imageSubService.getAllSubImageDetailsByDestinationId(imageSub);
		return ResponseEntity.ok(resultImageSub);

	}

}
