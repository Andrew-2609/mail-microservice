package com.ndrewcoding.mailmicroservice.services;

import com.ndrewcoding.mailmicroservice.models.EmailModel;
import com.ndrewcoding.mailmicroservice.repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public void sendEmail(EmailModel emailModel) {

    }
}
