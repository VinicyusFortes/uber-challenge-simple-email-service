package com.fortes.email_service.application;

import com.fortes.email_service.adapters.EmailSenderGateway;
import com.fortes.email_service.core.EmailServiceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// todo add javadoc
@Service
public class EmailSenderService implements EmailServiceUseCase {

  private final EmailSenderGateway emailSenderGateway;

  @Autowired
  public EmailSenderService(EmailSenderGateway emailSenderGateway) {
    this.emailSenderGateway = emailSenderGateway;
  }

  @Override
  public void sendEmail (String to, String subject, String body) {
    this.emailSenderGateway.SendEmail(to, subject, body);
  }
}
