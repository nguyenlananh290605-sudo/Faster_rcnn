package com.example.animalrecognition.util;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
@Component
public class PythonModelClient {

    private final String FASTAPI_URL = "http://127.0.0.1:8000/detect";

    public String sendImageToModel(File imageFile) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(imageFile));

        HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(body, headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(
                FASTAPI_URL,
                HttpMethod.POST,
                requestEntity,
                byte[].class
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return Base64.getEncoder().encodeToString(response.getBody());
        }

        return null;
    }
}
