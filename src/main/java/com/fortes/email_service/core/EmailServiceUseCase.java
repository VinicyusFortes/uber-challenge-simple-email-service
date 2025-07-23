package com.fortes.email_service.core;

//TODO add documentation
public interface EmailServiceUseCase {
  void sendEmail(String to, String sibject, String body);
}
