package com.example.animalrecognition.service;

import com.example.animalrecognition.util.PythonModelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
@Service
public class VehicleService {

    @Autowired
    private PythonModelClient modelClient;

    public String processImage(MultipartFile file) throws IOException {

        File tempFile = File.createTempFile("vehicle-", file.getOriginalFilename());
        file.transferTo(tempFile);

        String base64img = modelClient.sendImageToModel(tempFile);

        tempFile.delete();

        return base64img;
    }
}
