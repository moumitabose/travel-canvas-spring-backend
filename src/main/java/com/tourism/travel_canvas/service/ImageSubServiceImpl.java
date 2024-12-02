package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tourism.travel_canvas.exception.ImageNotFoundException;
import com.tourism.travel_canvas.model.ImageSub;

import com.tourism.travel_canvas.repository.ImageSubRepository;

@Service
public class ImageSubServiceImpl implements ImageSubService {

	@Autowired
	private ImageSubRepository imageSubRepository;
	
	
	public ImageSubServiceImpl(ImageSubRepository imageSubRepository)
	{
		this.imageSubRepository= imageSubRepository;
	}

	@Override
	public ImageSub saveSubImage(MultipartFile file) throws IOException {

		byte[] imageSubData = file.getBytes();

		ImageSub imageSub = new ImageSub();

		imageSub.setImageSubName(file.getOriginalFilename());

		imageSub.setImageSubData(imageSubData);

		return imageSubRepository.save(imageSub);

	
	}

	@Override
	public List<ImageSub> getAllSubImageDetailsByDestinationId(ImageSub imageSub) {
		
		List<ImageSub> resultImageSub=
				imageSubRepository.getAllSubImageDetailsByDestinationId(imageSub.getDestinationid());
		
		if(resultImageSub.size()==0)
		{
			throw new ImageNotFoundException("Image not found for destination ID: " + imageSub.getDestinationid());
		}

		return resultImageSub;
	}

}
