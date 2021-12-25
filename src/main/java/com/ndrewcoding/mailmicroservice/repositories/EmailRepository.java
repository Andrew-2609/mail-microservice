package com.ndrewcoding.mailmicroservice.repositories;

import com.ndrewcoding.mailmicroservice.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
