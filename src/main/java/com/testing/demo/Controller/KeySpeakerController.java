package com.testing.demo.Controller;

import com.testing.demo.Model.Request.KeySpeakers;
import com.testing.demo.Service.KeySpeakerService.KeySpeakerService;
import com.testing.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class KeySpeakerController {
    @Autowired
    KeySpeakerService keySpeakerService;

    @Autowired
    private JwtUtil jwtUtil;

    public KeySpeakerController(){

    }

    @PostMapping("/keyspeaker")
    public ResponseEntity<?> createKeySpeaker(@RequestBody KeySpeakers keySpeakers){
        KeySpeakers addedKeySpeaker = keySpeakerService.createKeySpeaker(keySpeakers);
        return new ResponseEntity<>(keySpeakers, HttpStatus.OK);
    }
}
