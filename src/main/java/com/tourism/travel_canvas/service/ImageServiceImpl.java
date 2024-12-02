package com.tourism.travel_canvas.service;

import com.tourism.travel_canvas.model.Image;
import com.tourism.travel_canvas.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tourism.travel_canvas.exception.ImageNotFoundException;


import java.util.Base64;

import java.io.IOException;
import java.util.Arrays;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageRepository imageRepository;

	public ImageServiceImpl(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

//	@Override
//	public Image saveImage(MultipartFile file) throws IOException {
//		// Log the file size to ensure it's being uploaded
//		System.out.println("Uploading file: " + file.getOriginalFilename());
//		System.out.println("File size: " + file.getSize());
//
//		// Convert the file to byte array
//		byte[] imageData = file.getBytes();
//		System.out.println("Image data size: " + imageData.length);
//		System.out.println("First few bytes: "
//				+ Arrays.toString(Arrays.copyOfRange(imageData, 0, Math.min(10, imageData.length))));
//
//		Image image = new Image();
//		image.setName(file.getOriginalFilename());
//		image.setImageData(imageData);
//
//		// Save the image to the database
//		return imageRepository.save(image);
//	}

//	@Override
//	public Image saveImage(MultipartFile file) {
//	    try {
//	        // Log the file size to ensure it's being uploaded
//	        System.out.println("Uploading file: " + file.getOriginalFilename());
//	        System.out.println("File size: " + file.getSize());
//
//	        // Convert the file to byte array
//	        byte[] imageData = file.getBytes();
//	        System.out.println("Image data size: " + imageData.length);
//	        System.out.println("First few bytes: "
//	                + Arrays.toString(Arrays.copyOfRange(imageData, 0, Math.min(10, imageData.length))));
//
//	        Image image = new Image();
//	        image.setName(file.getOriginalFilename());
//	        image.setImageData(imageData);
//
//	        // Save the image to the database
//	        return imageRepository.save(image);
//	    } catch (IOException e) {
//	        throw new ImageUploadException("Failed to upload the image file: " + file.getOriginalFilename(), e);
//	    } catch (Exception e) {
//	        throw new ImageUploadException("An unexpected error occurred while saving the image.", e);
//	    }
//	}

	@Override
	public Image saveImage(MultipartFile file) throws IOException {
		// Log the file size to ensure it's being uploaded
		System.out.println("Uploading file: " + file.getOriginalFilename());
		System.out.println("File size: " + file.getSize());

		// Convert the file to byte array
		byte[] imageData = file.getBytes();
		System.out.println("Image data size: " + imageData.length);
		System.out.println("First few bytes: "
				+ Arrays.toString(Arrays.copyOfRange(imageData, 0, Math.min(10, imageData.length))));

		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setImageData(imageData);

		// Save the image to the database
		return imageRepository.save(image);
	}

	@Override
	public byte[] getImageById(Integer imageid) {
		Image image = imageRepository.findById(imageid).orElseThrow(() -> new ImageNotFoundException("Image not found"));
		return image.getImageData(); // Return the image data (byte array)
	}

	@Override
	public Image getImageDetailsByDestinationId(Image image) {
		// Fetch the image by destination ID
		Image result = imageRepository.getImageDetailsByDestinationId(image.getDestinationid());

		// If no result is found, throw a custom exception
		if (result == null) {
			throw new ImageNotFoundException("Image not found for destination ID: " + image.getDestinationid());
		}
		
		 String base64Image = Base64.getEncoder().encodeToString(result.getImageData());
		    result.setImageData(base64Image.getBytes()); // Replace imageData with Base64 string

		return result;
	}

}
