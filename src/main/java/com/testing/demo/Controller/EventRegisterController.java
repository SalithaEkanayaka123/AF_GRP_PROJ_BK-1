package com.testing.demo.Controller;

import com.testing.demo.Model.Request.EventRegister;
import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Service.EventRegisterService;
import com.testing.demo.Service.EventService.EventService;
import com.testing.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class EventRegisterController {

    @Autowired
    EventRegisterService eventRegisterService;

    @Autowired
    private JwtUtil jwtUtil;

    private AuthenticationManager authenticationManager;

    public EventRegisterController(){

    }

    @PostMapping("/eventRegister")
    public ResponseEntity<?> createEventRegister (@RequestBody EventRegister eventRegister){
        EventRegister addedEventRegister = eventRegisterService.createEventRegister(eventRegister);
        return new ResponseEntity<>(eventRegister, HttpStatus.OK);
    }

    @GetMapping("/eventRegisters")
    public ResponseEntity<?> getAllEventRegister(){
        List<EventRegister> eventRegisters = eventRegisterService.getAllEventRegister();
        if(eventRegisters.size() > 0){
            return new ResponseEntity<>(eventRegisters, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Event Registers", HttpStatus.NOT_FOUND);
        }
    }



}
