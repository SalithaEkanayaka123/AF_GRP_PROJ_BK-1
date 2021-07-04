package com.testing.demo.Controller;

import com.testing.demo.Model.Request.DownloadCategory;
import com.testing.demo.Model.Request.DownloadItems.DownloadItem;
import com.testing.demo.Service.DownloadItemService.DownloadItemService;
import com.testing.demo.Service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class DownloadItemController {

    @Autowired
    DownloadItemService downloadItemService;

    @PostMapping("/download/item")
    public ResponseEntity<?> createDownloadItem (@RequestBody DownloadItem downloadItem){
        DownloadItem item = downloadItemService.createDownloadItem(downloadItem);
        return new ResponseEntity<>(downloadItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/item/{type}")
    public ResponseEntity<?> deleteItem(@PathVariable String type){
        String response = downloadItemService.deleteDownloadItem(type);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<?> getAllItems(){
        List<DownloadItem> downloadItems = downloadItemService.getAllDownloadItems();
        if(downloadItems.size() > 0){
            return new ResponseEntity<>(downloadItems, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Downloaded Items", HttpStatus.NOT_FOUND);
        }
    }
}
