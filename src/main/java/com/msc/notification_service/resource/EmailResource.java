package com.msc.notification_service.resource;

import com.msc.notification_service.model.Email;
import com.msc.notification_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailResource {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody Email email) {
        this.emailService.sendEmail(email);
        return ResponseEntity.ok("Notification sent successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emails = this.emailService.getAllEmails();
        return ResponseEntity.ok(emails);
    }
}
