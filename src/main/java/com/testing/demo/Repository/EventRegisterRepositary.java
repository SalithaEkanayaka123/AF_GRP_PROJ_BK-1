package com.testing.demo.Repository;

import com.testing.demo.Model.Request.EventRegister;
import com.testing.demo.Model.Request.Events;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRegisterRepositary extends MongoRepository<EventRegister, String> {
}
