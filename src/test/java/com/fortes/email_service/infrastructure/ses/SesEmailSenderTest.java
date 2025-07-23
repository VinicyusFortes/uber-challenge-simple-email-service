package com.fortes.email_service.infrastructure.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.fortes.email_service.core.exceptions.EmailServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SesEmailSenderTest {
  private AmazonSimpleEmailService amazonSimpleEmailService;
  private SesEmailSender sesEmailSender;

  @BeforeEach
  void setUp() {
    amazonSimpleEmailService = mock(AmazonSimpleEmailService.class);
    sesEmailSender = new SesEmailSender(amazonSimpleEmailService);
  }

  @Test
  void sendEmail_shouldCallAmazonSESWithCorrectRequest() {
    String to = "recipient@example.com";
    String subject = "Test Subject";
    String body = "Test Body";

    sesEmailSender.SendEmail(to, subject, body);

    ArgumentCaptor<SendEmailRequest> captor = ArgumentCaptor.forClass(SendEmailRequest.class);
    verify(amazonSimpleEmailService).sendEmail(captor.capture());

    SendEmailRequest request = captor.getValue();
    assert request.getDestination().getToAddresses().contains(to);
    assert request.getMessage().getSubject().getData().equals(subject);
    assert request.getMessage().getBody().getText().getData().equals(body);
  }

  @Test
  void sendEmail_shouldThrowEmailServiceExceptionOnAmazonServiceException() {
    doThrow(new AmazonServiceException("AWS error"))
            .when(amazonSimpleEmailService)
            .sendEmail(any(SendEmailRequest.class));
    assertThrows(EmailServiceException.class, () ->
            sesEmailSender.SendEmail("to", "subject", "body"));
  }

}