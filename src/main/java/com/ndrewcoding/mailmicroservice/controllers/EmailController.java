package com.ndrewcoding.mailmicroservice.controllers;

import com.ndrewcoding.mailmicroservice.dtos.EmailDTO;
import com.ndrewcoding.mailmicroservice.models.EmailModel;
import com.ndrewcoding.mailmicroservice.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/mail-ms")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        EmailModel sentEmail = emailService.sendEmail(emailModel);
        return new ResponseEntity<>(sentEmail, HttpStatus.CREATED);
    }

}
