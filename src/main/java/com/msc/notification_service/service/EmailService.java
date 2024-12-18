package com.msc.notification_service.service;

import com.msc.notification_service.model.Email;

import java.util.List;

public interface EmailService {
    void sendEmail(Email email);
    List<Email> getAllEmails();
}
