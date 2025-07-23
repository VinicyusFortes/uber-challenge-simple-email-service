package com.fortes.email_service.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailRequestTest {

  @Test
  void record_shouldStoreAndReturnFields() {
    String to = "example@example.com";
    String subject = "This is a test subject";
    String body = "This is a body content for test";

    EmailRequest request = new EmailRequest(to, subject, body);

    assertEquals(to, request.to());
    assertEquals(subject, request.subject());
    assertEquals(body, request.body());
  }

}