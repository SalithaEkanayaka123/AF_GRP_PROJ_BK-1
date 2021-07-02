package com.testing.demo.Service;

import com.testing.demo.Model.Request.EventRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class EventRegisterServiceImpl implements EventRegisterService{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public EventRegister createEventRegister(EventRegister eventRegister) {
        EventRegister eventRegister1 = new EventRegister();
        eventRegister1.setEventName(eventRegister.getEventName());
        eventRegister1.setAmount(eventRegister.getAmount());
        eventRegister1.setToken(eventRegister.getToken());
        eventRegister1.setUserName(eventRegister.getUserName());
        eventRegister1.setPhoneNumber(eventRegister.getPhoneNumber());
        mongoTemplate.insert(eventRegister1);
        return eventRegister1;
    }

    @Override
    public List<EventRegister> getAllEventRegister() {
        return mongoTemplate.findAll(EventRegister.class);
    }

    @Override
    public EventRegister getEventRegisterById(String id) {
        EventRegister eventRegister = mongoTemplate.findOne(new Query(where("id").is(id)), EventRegister.class);
        return eventRegister;
    }

    @Override
    public String deleteEventRegister(String id) {
        mongoTemplate.remove(new Query(where("id").is(id)), EventRegister.class);
        return "Event Register id is " + id;
    }
}
