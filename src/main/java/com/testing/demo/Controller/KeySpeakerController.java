package com.testing.demo.Controller;

import com.testing.demo.Model.Request.KeySpeakers;
import com.testing.demo.Service.KeySpeakerService.KeySpeakerService;
import com.testing.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
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

    @GetMapping("/keyspeakers")
    public ResponseEntity<?> getAllKeySpeaker(){
        List<KeySpeakers> keySpeakers = keySpeakerService.getAllKeySpeaker();
        if(keySpeakers.size() > 0){
            return new ResponseEntity<>(keySpeakers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No KeySpeakers", HttpStatus.NOT_FOUND);
        }
    }

    //Get Single Key Speaker
    @GetMapping("/getKeySpeakerById/{id}")
    public ResponseEntity<?> getKeySpeakerById(@PathVariable("id") String id){
        Optional<KeySpeakers> keySpeakersOptional = Optional.ofNullable(keySpeakerService.getKeySpeakerById(id));
        if(keySpeakersOptional.isPresent()){
            return new ResponseEntity<>(keySpeakersOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Key Speaker not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteKeySpeaker/{id}")
    public ResponseEntity<?> deleteKeySpeaker(@PathVariable String id){
        String response = keySpeakerService.deleteKeySpeaker(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }





}
