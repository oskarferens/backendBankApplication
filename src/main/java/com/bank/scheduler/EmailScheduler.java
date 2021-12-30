package com.bank.scheduler;

import com.bank.config.AdminConfig;
import com.bank.domain.Mail;
import com.bank.service.AccountDbService;
import com.bank.service.EmailService;
import com.bank.service.OperationDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "BankApplication: daily operation statistics";
    private final EmailService emailService;
    private final AdminConfig adminConfig;
    private final AccountDbService accountDbService;
    private final OperationDbService operationDbService;

    //@Scheduled(cron = "0 0 10 * * *")
    @Scheduled(fixedDelay = 10000)
    public void sendInformationEmail() {
        Long operationsQuantity = operationDbService.getAllOperations().stream().count();
        emailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Today were made "+operationsQuantity+" operations.",
                        null
                )
        );
    }
}
