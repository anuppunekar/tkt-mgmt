/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restapp;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.JsonObject;
import org.springframework.util.StreamUtils;

/**
 *
 * @author 
 * 15-Aug-2024  UploadController
 */

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public Object upload(@RequestPart("logo") MultipartFile logo, 
                        @RequestPart("name") String name,
                        @RequestPart("info") JsonObject info) throws IOException {
        
        try (InputStream inputStream = logo.getInputStream()){
            StreamUtils.drain(inputStream);
        }
        return "ok";

    }
}
