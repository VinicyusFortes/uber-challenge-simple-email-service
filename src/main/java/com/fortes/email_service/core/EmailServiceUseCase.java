package com.fortes.email_service.core;

import org.springframework.stereotype.Component;

//TODO add documentation
public interface EmailServiceUseCase {
  void sendEmail(String to, String sibject, String body);
}
