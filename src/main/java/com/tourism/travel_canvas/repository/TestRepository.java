package com.tourism.travel_canvas.repository;


import com.tourism.travel_canvas.model.Image;
import com.tourism.travel_canvas.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
