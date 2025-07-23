package com.fortes.email_service.application;

import com.fortes.email_service.adapters.EmailSenderGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EmailSenderServiceTestIT {

  @Autowired
  private EmailSenderService emailSenderService;

  @MockBean
  private EmailSenderGateway emailSenderGateway;

  @Test
  void sendEmail_shouldDelegateToGateway_inSpringContext() {
    String to = "integration@example.com";
    String subject = "Integration Test";
    String body = "Integration Body";

    emailSenderService.sendEmail(to, subject, body);

    verify(emailSenderGateway).SendEmail(to, subject, body);
  }


}