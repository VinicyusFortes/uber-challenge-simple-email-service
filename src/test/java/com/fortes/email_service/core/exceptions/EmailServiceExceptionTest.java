package com.fortes.email_service.core.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceExceptionTest {

  @Test
  void constructor_shouldStoreMessage() {
    String message = "Test exception message";
    EmailServiceException exception = new EmailServiceException(message);

    assertEquals(message, exception.getMessage());
  }

  @Test
  void constructor_shouldStoreMessageAndCause() {
    String message = "Test exception message";
    Throwable cause = new RuntimeException("Root cause");

    EmailServiceException exception = new EmailServiceException(message, cause);

    assertEquals(message, exception.getMessage());
    assertSame(cause, exception.getCause());
  }

}