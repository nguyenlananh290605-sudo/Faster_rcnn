package com.example.animalrecognition.controller;

import com.example.animalrecognition.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;
import java.util.HashMap;
@RestController
@RequestMapping("/api/images")
public class ImageUploadController {

    @Autowired
    private VehicleService vehicleService;

    @CrossOrigin(origins = "*")
    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {

        try {
            String base64Image = vehicleService.processImage(file);

            Map<String, String> result = new HashMap<>();
            result.put("image", base64Image);

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
