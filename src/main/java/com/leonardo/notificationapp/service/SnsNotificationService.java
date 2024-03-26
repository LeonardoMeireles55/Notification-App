package com.leonardo.notificationapp.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SnsNotificationService {

    private final AmazonSNS amazonSNS;
    
    public void sendNotification(String message, String tellPhone) {
        PublishRequest publishRequest = new PublishRequest().withMessage(message).withPhoneNumber(tellPhone);
        amazonSNS.publish(publishRequest);
    }
}
