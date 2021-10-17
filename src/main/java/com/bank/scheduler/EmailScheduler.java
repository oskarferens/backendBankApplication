package com.bank.scheduler;

import com.bank.config.AdminConfig;
import com.bank.domain.Mail;
import com.bank.repository.OperationRepository;
import com.bank.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "BankApplication: payment confirmation";
    private final EmailService emailService;
    private final OperationRepository operationRepository;
    private final AdminConfig adminConfig;

    @Scheduled
    public void sendInformationEmail() {
        //boolean paymentSent = operationRepository.;
        emailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Payment sent.",
                        null
                )
        );
    }
}
