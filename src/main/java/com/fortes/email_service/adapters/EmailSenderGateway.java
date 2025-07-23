package com.fortes.email_service.adapters;

import org.springframework.stereotype.Component;

@Component
public interface EmailSenderGateway {

  void SendEmail(String to, String subject, String body);
}
