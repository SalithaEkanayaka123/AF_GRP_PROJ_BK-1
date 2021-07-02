package com.testing.demo.Controller;
import com.testing.demo.Model.Request.DownloadCategory;
import com.testing.demo.Service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class DownloadController {
    @Autowired
    DownloadService downloadService;

    @PostMapping("/download/category")
    public ResponseEntity<?> createDownloadCategory (@RequestBody DownloadCategory downloadcategory){
        DownloadCategory downloadCategory = downloadService.createDownloadCategory(downloadcategory);
        return new ResponseEntity<>(downloadCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/category/{type}")
    public ResponseEntity<?> deleteCategory(@PathVariable String type){
        String response = downloadService.deleteDownloadCategory(type);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories(){
        List<DownloadCategory> downloadCategories = downloadService.getAllDownloadCategories();
        if(downloadCategories.size() > 0){
            return new ResponseEntity<>(downloadCategories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Categories", HttpStatus.NOT_FOUND);
        }
    }

    //Controllers for Download Resources.

}
