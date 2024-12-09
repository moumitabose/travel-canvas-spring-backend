package com.tourism.travel_canvas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.EmailRequest;
import com.tourism.travel_canvas.service.EmailRequestService;

@RestController
@CrossOrigin
public class EmailRequestController {

	@Autowired
	private EmailRequestService emailRequestService;

	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody EmailRequest emailRequest) {
		emailRequestService.sendEmail(emailRequest);
		return "Email sent successfully!";
	}

	@PostMapping("/saveEmailDetails")
	public ResponseEntity<EmailRequest> saveEmailDetails(@RequestBody EmailRequest emailRequest) {
		EmailRequest saveEmailDetails = emailRequestService.saveEmailDetails(emailRequest);
		return new ResponseEntity<>(saveEmailDetails, HttpStatus.CREATED);
	}

}
