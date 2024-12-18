package com.msc.notification_service.service;

import com.msc.notification_service.model.Email;
import com.msc.notification_service.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    @Override
    public void sendEmail(Email email) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email.getPatientEmail());
            mailMessage.setSubject(email.getSubject());
            mailMessage.setText(email.getMessage());
            this.mailSender.send(mailMessage);
            email.setStatus("SUCCESS");
        } catch (Exception e) {
            email.setStatus("FAILED");
        }
        this.emailRepository.save(email);
    }

    @Override
    public List<Email> getAllEmails() {
        // Fetch all saved emails from the database
        return emailRepository.findAll();
    }
}
