package com.msc.notification_service.repository;

import com.msc.notification_service.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {

}