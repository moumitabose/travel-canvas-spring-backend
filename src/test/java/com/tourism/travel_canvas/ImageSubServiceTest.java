package com.tourism.travel_canvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.multipart.MultipartFile;

import com.tourism.travel_canvas.exception.ImageNotFoundException;
import com.tourism.travel_canvas.model.ImageSub;
import com.tourism.travel_canvas.repository.ImageSubRepository;

import com.tourism.travel_canvas.service.ImageSubService;
import com.tourism.travel_canvas.service.ImageSubServiceImpl;

public class ImageSubServiceTest {

	private ImageSubRepository imageSubRepository;

	private ImageSubService imageSubService;

	private ImageSub imageSub;

	MultipartFile file = mock(MultipartFile.class);

	@BeforeEach
	void setup() {

		imageSubRepository = Mockito.mock(ImageSubRepository.class);
		imageSubService = new ImageSubServiceImpl(imageSubRepository);

		imageSub = new ImageSub(1, "sample", new byte[] { 1, 2, 3 }, 1, 'Y', 1, LocalDateTime.now());

	}

	@Test
	void saveSubImage_test() throws IOException {
		when(file.getOriginalFilename()).thenReturn("sample");
		when(file.getSize()).thenReturn(3L);
		when(file.getBytes()).thenReturn(new byte[] { 1, 2, 3 });

		ImageSub savedImage = new ImageSub(1, "sample", new byte[] { 1, 2, 3 }, 1, 'Y', 1, LocalDateTime.now());

		when(imageSubRepository.save(imageSub)).thenReturn(savedImage);

		ImageSub result = imageSubService.saveSubImage(file);

		assertEquals(savedImage.getImageSubName(), result.getImageSubName());

		verify(imageSubRepository, times(1)).save(imageSub);

	}

	@Test
	void saveSubImage_emptyfile_test() throws IOException {

		when(file.getSize()).thenReturn(0L);
		when(file.getBytes()).thenReturn(new byte[0]);

		ImageSub result = imageSubService.saveSubImage(file);

		assertNull(result);

		verify(imageSubRepository, times(1)).save(imageSub);
	}
	
	@Test
	void getAllSubImageDetailsByDestinationId_test()
	{
		List<ImageSub> imageList= List.of(new 
				ImageSub(1, "sample", new byte[] { 1, 2, 3 }, 1, 'Y', 1, LocalDateTime.now()),
				new 
				ImageSub(2, "sample_two", new byte[] { 4, 5 }, 2, 'Y', 1, LocalDateTime.now()));
		
		
		when(imageSubRepository.getAllSubImageDetailsByDestinationId(1)).thenReturn(imageList);
		
		List<ImageSub> resultImageList= imageSubRepository.getAllSubImageDetailsByDestinationId(1);
		
		assertEquals(imageList.size(), resultImageList.size(),"lengths are equal in both list");
		
		verify(imageSubRepository,timeout(1)).getAllSubImageDetailsByDestinationId(1);
				
				
	}
	
	@Test
	void getAllSubImageDetailsByDestinationId_notfound_test()
	{
		
		when(imageSubRepository.getAllSubImageDetailsByDestinationId(1)).thenReturn(null);
		
		ImageNotFoundException imageNotFoundException= assertThrows(ImageNotFoundException.class, ()->
		{
			imageSubService.getAllSubImageDetailsByDestinationId(imageSub);
		});
		
		assertEquals("Image not found for destination ID: 1", imageNotFoundException.getMessage());
	}
	
}
