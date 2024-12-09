package com.tourism.travel_canvas.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.tourism.travel_canvas.exception.SaveFailedException;
import com.tourism.travel_canvas.model.EmailRequest;
import com.tourism.travel_canvas.repository.EmailRequestRepository;

@Service
public class EmailRequestServiceImpl implements EmailRequestService {

	@Autowired
	private EmailRequestRepository emailRequestRepository;

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendEmail(EmailRequest emailRequest) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailRequest.getRecipient());
		message.setSubject(emailRequest.getSubject());
		message.setText(emailRequest.getBody());
		emailSender.send(message);

	}

	@Override
	public EmailRequest saveEmailDetails(EmailRequest emailRequest) {
		
		EmailRequest saveEmailDetails= emailRequestRepository.save(emailRequest);
		
		if(saveEmailDetails==null)
		{
			throw new SaveFailedException("Fail to save email details");
		}
		
		return saveEmailDetails;
	}

}
