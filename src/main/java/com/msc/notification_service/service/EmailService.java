package com.msc.notification_service.service;

import com.msc.notification_service.model.Notification;

public interface NotificationService {
    void sendNotification(Notification notification);
}
