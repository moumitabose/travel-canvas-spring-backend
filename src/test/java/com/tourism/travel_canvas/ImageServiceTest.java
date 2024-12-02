package com.tourism.travel_canvas;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.multipart.MultipartFile;

import com.tourism.travel_canvas.exception.ImageNotFoundException;
import com.tourism.travel_canvas.model.Image;
import com.tourism.travel_canvas.repository.ImageRepository;
import com.tourism.travel_canvas.service.ImageService;
import com.tourism.travel_canvas.service.ImageServiceImpl;

public class ImageServiceTest {

	private ImageRepository imageRepository;

	private ImageService imageService;

	private Image image;

	private MultipartFile file;

	@BeforeEach
	void setup() {
		imageRepository = Mockito.mock(ImageRepository.class);
		imageService = new ImageServiceImpl(imageRepository);

		image = new Image(1, "sample", new byte[] { 1, 2, 3 }, 1, 'Y', 1, LocalDateTime.now());

		file = mock(MultipartFile.class);
	}

	@Test
	void saveImage_test() throws IOException {

		when(file.getOriginalFilename()).thenReturn("sample.jpg");
		when(file.getSize()).thenReturn(3L); // Size of byte array
		when(file.getBytes()).thenReturn(new byte[] { 1, 2, 3 });

		Image savedImage = new Image(1, "sample", new byte[] { 1, 2, 3 }, 1, 'Y', 1, LocalDateTime.now());

		when(imageRepository.save(image)).thenReturn(savedImage);

		Image result = imageService.saveImage(file);

		assertEquals(savedImage.getName(), result.getName());

		verify(imageRepository, times(1)).save(image);
	}

	@Test
	void saveImage__emptyfile_test() throws IOException {
		when(file.getSize()).thenReturn(0L);
		when(file.getBytes()).thenReturn(new byte[0]);

		Image result = imageService.saveImage(file);

		assertNull(result);

		verify(imageRepository, times(1)).save(image);

	}

	@Test
	void getImageById_test() {

		when(imageRepository.findById(1)).thenReturn(Optional.of(image));

		byte[] resultImage = imageService.getImageById(1);

		assertArrayEquals(image.getImageData(), resultImage, "should return same image data");

		verify(imageRepository, times(1)).findById(1);

	}

	@Test
	void getImageById_notfound_test() {

		when(imageRepository.findById(1)).thenReturn(null);

		ImageNotFoundException imageNotFoundException = assertThrows(ImageNotFoundException.class, () -> {
			imageService.getImageById(1);
		});

		// Verify the exception message
		assertEquals("Image not found", imageNotFoundException.getMessage());

		// Verify that the repository's findById method was called once
		verify(imageRepository, times(1)).findById(1);

	}

	@Test
	void getImageDetailsByDestinationId_test() {

		when(imageRepository.getImageDetailsByDestinationId(1)).thenReturn(image);

		Image resultImage = imageService.getImageDetailsByDestinationId(image);

		assertNotNull(resultImage);

		assertEquals(resultImage.getDestinationid(), image.getDestinationid(), "Should return same destinationid");

		verify(imageRepository, times(1)).getImageDetailsByDestinationId(1);

	}

	@Test
	void getImageDetailsByDestinationId_notfound_test() {

		when(imageRepository.getImageDetailsByDestinationId(1)).thenReturn(null);

		ImageNotFoundException imageNotFoundException = assertThrows(ImageNotFoundException.class, () -> {
			imageService.getImageDetailsByDestinationId(image);
		});

		assertEquals("Image not found for destination ID: 1", imageNotFoundException.getMessage());

	}

}
