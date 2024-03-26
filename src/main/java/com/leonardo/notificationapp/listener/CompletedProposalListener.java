package com.leonardo.notificationapp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.leonardo.notificationapp.domain.Proposal;
import com.leonardo.notificationapp.service.SnsNotificationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CompletedProposalListener {

    private final SnsNotificationService snsNotificationService;

    @RabbitListener(queues = "${rabbitmq.queue.completed.proposal}")
    public void proposalDone(Proposal proposal) {
        String message = proposal.getObservation();
        snsNotificationService.sendNotification(message, "5585989924491");
    }
}