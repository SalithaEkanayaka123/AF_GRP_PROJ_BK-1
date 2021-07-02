package com.testing.demo.Service;

import com.testing.demo.Model.Request.EventRegister;
import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Response.BarChartModel;

import java.util.List;

public interface EventRegisterService {
    EventRegister createEventRegister(EventRegister eventRegister);
    List<EventRegister> getAllEventRegister();
    EventRegister getEventRegisterById(String id);
    String deleteEventRegister(String id);
}
