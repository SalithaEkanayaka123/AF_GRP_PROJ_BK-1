package com.testing.demo.Controller;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Service.EventService.EventService;
import com.testing.demo.Service.FeedBackService.FeedBackService;
import com.testing.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class FeedBackController {
    @Autowired
    FeedBackService feedBackService;

    @Autowired
    private JwtUtil jwtUtil;

    public FeedBackController(){

    }

    @PostMapping("/feedback")
    public ResponseEntity<?> createFeedback (@RequestBody Feedback feedback){
        Feedback addedFeedback = feedBackService.createFeedback(feedback);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<?> getAllFeedbacks(){
        List<Feedback> feedbacks = feedBackService.getAllFeedbacks();
        if(feedbacks.size() > 0){
            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Feedbacks", HttpStatus.NOT_FOUND);
        }
    }


    //Get Single event
    @GetMapping("/getFeedBackById/{id}")
    public ResponseEntity<?> getFeedBackById(@PathVariable("id") String id){
        Optional<Feedback> feedbackOptional = Optional.ofNullable(feedBackService.getFeedBackById(id));
        if(feedbackOptional.isPresent()){
            return new ResponseEntity<>(feedbackOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Feedback not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteFeedback/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id){
        String response = feedBackService.deleteFeedback(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
