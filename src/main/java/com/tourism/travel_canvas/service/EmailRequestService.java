package com.tourism.travel_canvas.service;

import com.tourism.travel_canvas.model.EmailRequest;

public interface EmailRequestService {

	public void sendEmail(EmailRequest emailRequest);

	public EmailRequest saveEmailDetails(EmailRequest emailRequest);

}
