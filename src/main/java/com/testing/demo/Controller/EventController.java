package com.testing.demo.Controller;

import com.testing.demo.Model.Request.DownloadItems.DownloadItem;
import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Service.EventService.EventService;
import com.testing.demo.Service.TotalUserCount.TotalUserCountService;
import com.testing.demo.Service.UserValidation;
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
public class EventController {

    @Autowired
    EventService eventService;


    @Autowired
    private JwtUtil jwtUtil;

    private AuthenticationManager authenticationManager;

    public EventController(){

    }

    @PostMapping("/event")
    public ResponseEntity<?> createEvent (@RequestBody Events events){
        Events addedEvent = eventService.createEvent(events);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/events")
    public ResponseEntity<?> getAllEvents(){
        List<Events> events = eventService.getAllEvents();
        if(events.size() > 0){
            return new ResponseEntity<>(events, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Events", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @GetMapping("/approveStatuses")
     *     public ResponseEntity<?> getApproveStatus(){
     *         int count1 = 0;
     *         int count2 = 0;
     *         List<DownloadItem> downloadItems = approveStatusService.getApproveStatus();
     *         if(downloadItems.size() >= 0){
     *             for (DownloadItem i : downloadItems){
     *                 if (i.getApprovalStatus().contentEquals("approve")){
     *                     count1++;
     *                 }else if (i.getApprovalStatus().contentEquals("reject")){
     *                     count2++;
     *                 }
     *             }
     *             ApproveStatus approveStatus = new ApproveStatus(String.valueOf(count1), String.valueOf(count2), String.valueOf(count1+count2));
     *             return new ResponseEntity<>(approveStatus, HttpStatus.OK);
     *         } else {
     *             return new ResponseEntity<>("No Categories", HttpStatus.NOT_FOUND);
     *         }
     *     }
     * @return
     */
//    @GetMapping("/eventcount")
//    public ResponseEntity<?> getEventsWithDate(){
//
//        List<Events> events = eventService.getAllEvents();
//        if(events.size() > 0){
//            for (Events i : events){
//                if (i.getApprovalStatus().contentEquals("approve")){
//                    count1++;
//                }else if (i.getApprovalStatus().contentEquals("reject")){
//                    count2++;
//                }
//            }
//            return new ResponseEntity<>(events, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No Events", HttpStatus.NOT_FOUND);
//        }
//    }

    //Get Single event
    @GetMapping("/getEventById/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") String id){
        Optional<Events> eventOptional = Optional.ofNullable(eventService.getEventById(id));
        if(eventOptional.isPresent()){
            return new ResponseEntity<>(eventOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Event not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable("id") String id, @RequestBody Events events){
        Optional<Events> eventUpdate = Optional.ofNullable(eventService.getEventById(id));
        System.out.println(eventUpdate.isPresent());
        if(eventUpdate.isPresent()){
            Events updateEvent = eventUpdate.get();
            updateEvent.setId(events.getId() != null ? events.getId() : updateEvent.getId());
            updateEvent.setEventName(events.getEventName() != null ? events.getEventName() : updateEvent.getEventName());
            updateEvent.setEventType(events.getEventType() != null ? events.getEventType() : updateEvent.getEventType());
            updateEvent.setEventPlace(events.getEventPlace() != null ? events.getEventPlace() : updateEvent.getEventPlace());
            updateEvent.setDescription(events.getDescription() != null ? events.getDescription() : updateEvent.getDescription());
            updateEvent.setStatus(events.getStatus() != null ? events.getStatus() : updateEvent.getStatus());
            updateEvent.setDatetime(events.getDatetime() != null ? events.getDatetime() : updateEvent.getDatetime());
            updateEvent.setMainSpeaker(events.getMainSpeaker() != null ? events.getMainSpeaker() : updateEvent.getMainSpeaker());
            updateEvent.setLimitOfPeople(events.getLimitOfPeople() != null ? events.getLimitOfPeople() : updateEvent.getLimitOfPeople());
            updateEvent.setOrganizerName(events.getOrganizerName() != null ? events.getOrganizerName() : updateEvent.getOrganizerName());
            eventService.createEvent(updateEvent);
            return new ResponseEntity<>("Update Successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update Unsuccessful", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable String id){
        String response = eventService.deleteEvent(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
