package com.fortes.email_service.application;

import com.fortes.email_service.adapters.EmailSenderGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EmailSenderServiceTest {

  private EmailSenderGateway emailSenderGateway;
  private EmailSenderService emailSenderService;

  @BeforeEach
  void setUp() {
    emailSenderGateway = Mockito.mock(EmailSenderGateway.class);
    emailSenderService = new EmailSenderService(emailSenderGateway);
  }

  @Test
  void sendEmail_shouldDelegateToGateway() {
    String to = "test@example.com";
    String subject = "Test subject";
    String body = "Test body";

    emailSenderService.sendEmail(to, subject, body);

    Mockito.verify(emailSenderGateway).SendEmail(to, subject, body);
  }

}