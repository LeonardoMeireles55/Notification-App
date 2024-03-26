package com.leonardo.notificationapp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.leonardo.notificationapp.constants.Messages;
import com.leonardo.notificationapp.domain.Proposal;
import com.leonardo.notificationapp.service.SnsNotificationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PendingProposalListener {

    private final SnsNotificationService snsNotificationService;

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void pendingProposal(Proposal proposal) {
        String message = String.format(Messages.PENDING_PROPOSAL,  proposal.getUser().getName()); 
        snsNotificationService.sendNotification(message, "5585989924491");
    }
}
