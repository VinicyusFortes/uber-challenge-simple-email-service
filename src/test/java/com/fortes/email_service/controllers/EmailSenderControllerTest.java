package com.fortes.email_service.controllers;

import com.fortes.email_service.application.EmailSenderService;
import com.fortes.email_service.core.EmailRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class EmailSenderControllerTest {

  @Test
  void sendEmail_shouldReturnOkWhenServiceSucceeds() {
    EmailSenderService service = Mockito.mock(EmailSenderService.class);
    EmailSenderController controller = new EmailSenderController(service);

    EmailRequest request = new EmailRequest("to@example.com", "subject", "body");
    ResponseEntity<String> response = controller.sendEmail(request);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Email sent successfully!", response.getBody());
  }

  @Test
  void sendEmail_shouldReturnInternalServerErrorWhenServiceThrows() {
    EmailSenderService service = Mockito.mock(EmailSenderService.class);
    Mockito.doThrow(new RuntimeException("fail")).when(service)
            .sendEmail(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());

    EmailSenderController controller = new EmailSenderController(service);
    EmailRequest request = new EmailRequest("to@example.com", "subject", "body");
    ResponseEntity<String> response = controller.sendEmail(request);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertEquals("Error while trying to send email!", response.getBody());
  }

}