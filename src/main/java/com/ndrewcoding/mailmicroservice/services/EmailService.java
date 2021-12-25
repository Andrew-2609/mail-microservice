package com.ndrewcoding.mailmicroservice.services;

import com.ndrewcoding.mailmicroservice.repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

}
