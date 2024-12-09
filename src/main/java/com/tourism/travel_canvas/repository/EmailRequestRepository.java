package com.tourism.travel_canvas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.EmailRequest;

@Repository
public interface EmailRequestRepository extends JpaRepository<EmailRequest, Integer> {

}
