package com.ndrewcoding.mailmicroservice.services;

import com.ndrewcoding.mailmicroservice.enums.EmailStatus;
import com.ndrewcoding.mailmicroservice.models.EmailModel;
import com.ndrewcoding.mailmicroservice.repositories.EmailRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());

            emailModel.setEmailStatus(EmailStatus.SENT);
        } catch (MailException me) {
            emailModel.setEmailStatus(EmailStatus.ERROR);
        }

        return emailRepository.save(emailModel);
    }
}
