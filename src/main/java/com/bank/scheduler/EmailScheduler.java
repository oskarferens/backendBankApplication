package com.bank.scheduler;

import com.bank.config.AdminConfig;
import com.bank.domain.Mail;
import com.bank.repository.StatisticRepository;
import com.bank.service.EmailService;
import com.bank.service.OperationStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "BankApplication: daily operation statistics";
    private final EmailService emailService;
    private final AdminConfig adminConfig;
    private final OperationStatService operationStatService;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long operationsNumber = operationStatService.getOperations();
        emailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Today were made "+operationsNumber+" operations.",
                        "juniordev8998@gmail.com"
                )
        );
    }
}
