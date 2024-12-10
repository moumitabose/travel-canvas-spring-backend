package com.tourism.travel_canvas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.EmailRequest;
import com.tourism.travel_canvas.service.EmailRequestService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class EmailRequestController {

	@Autowired
	private EmailRequestService emailRequestService;

	@PostMapping("/sendEmail")
	public ResponseEntity<Map<String, String>> sendEmail(@RequestBody EmailRequest emailRequest) {
		emailRequestService.sendEmail(emailRequest);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Email sent successfully!");
		return ResponseEntity.ok(response);
	}

	@PostMapping("/saveEmailDetails")
	public ResponseEntity<EmailRequest> saveEmailDetails(@RequestBody EmailRequest emailRequest) {
		EmailRequest saveEmailDetails = emailRequestService.saveEmailDetails(emailRequest);
		return new ResponseEntity<>(saveEmailDetails, HttpStatus.CREATED);
	}

	@PostMapping("/sendotp")
	public ResponseEntity<String> sendOtp(@RequestParam String email) {
		String otp = String.valueOf((int) (Math.random() * 9000) + 1000); // Generate 4-digit OTP
		emailRequestService.sendOtpEmail(email, otp);
		return ResponseEntity.ok("OTP sent successfully!");
	}

}
