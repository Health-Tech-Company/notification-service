package com.msc.notification_service.service;

import com.msc.notification_service.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {


    private final JavaMailSender mailSender;

    @Override
    public void sendNotification(Notification notification) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(notification.getPatientEmail());
        mailMessage.setSubject(notification.getSubject());
        mailMessage.setText(notification.getMessage());

        this.mailSender.send(mailMessage);
    }
}
