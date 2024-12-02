package com.tourism.travel_canvas.controller;

import com.tourism.travel_canvas.model.Image;
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

//    @PostMapping("/upload")
//    public String uploadImage(@RequestParam("file") MultipartFile file) {
//        try {
//            imageService.saveImage(file);
//            return "Image uploaded successfully";
//        } catch (IOException e) {
//            e.printStackTrace(); // This will help with debugging the error
//            return "Failed to upload image";
//        }
//    }
//    
//
//	@PostMapping("/upload")
//	public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//		imageService.saveImage(file);
//		return "Image uploaded successfully";
//
//	}
	
	
	@PostMapping("/uploadImage")
	public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
	    Image savedImage = imageService.saveImage(file);
	    return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
	}

//	@GetMapping("/image/{id}")
//	public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
//		try {
//			byte[] imageData = imageService.getImageById(id); // Get image data from the service layer
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.IMAGE_JPEG); // Set the correct MIME type (adjust for image format)
//			return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
//		} catch (RuntimeException e) {
//			// Return a 404 if the image is not found
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	
	@GetMapping("/image/{imageid}")
	public ResponseEntity<byte[]> getImageById(@PathVariable Integer imageid) {
	    byte[] imageData = imageService.getImageById(imageid); // This may throw ImageNotFoundException
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG); // Adjust MIME type based on the image format
	    return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
	}

	@PostMapping("/getImageDetailsByDestinationId")
	public ResponseEntity<Image> getImageDetailsByDestinationId(@RequestBody Image image) {
	    Image result = imageService.getImageDetailsByDestinationId(image);
	    return ResponseEntity.ok(result);
	}
}
