package com.testing.demo.Model.Request;

import org.springframework.data.annotation.Id;

public class EventRegister {

    @Id
    private String id;
    private String eventName;
    private String amount;
    private String userName;
    private String token;
    private String phoneNumber;

    public EventRegister(){

    }

    public EventRegister(String id, String eventName, String amount, String userName, String token, String phoneNumber) {
        this.id = id;
        this.eventName = eventName;
        this.amount = amount;
        this.userName = userName;
        this.token = token;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
