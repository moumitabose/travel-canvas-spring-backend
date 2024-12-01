package com.tourism.travel_canvas.repository;

import com.tourism.travel_canvas.model.Destination;
import com.tourism.travel_canvas.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>  {


}
