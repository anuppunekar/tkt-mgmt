/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myhttp.client;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;

/**
 *
 * @author 
 */
public class MultipartRequest {

    public static void main(String[] args) throws Exception {
        
        /**
        * Create a Multipart request body with MultipartEntityBuilder.
        */
        HttpEntity httpEntity = MultipartEntityBuilder.create()
                // FORM
                .addPart("name",
                        new StringBody("<Spring Cloud>",
                                ContentType.create("application/x-www-form-urlencoded", StandardCharsets.UTF_8)))
                // JSON
                .addPart("info",
                        new StringBody("{\"site\": \"https://www.springcloud.io\"}", ContentType.APPLICATION_JSON))
                // FILE
                .addBinaryBody("logo", new File("C:\\Users\\xyz\\Desktop\\logo.png"), ContentType.IMAGE_PNG,
                        "logo.png")
                .build();

        /**
        * Use pipeline streams to write the encoded data directly to the network
        * instead of caching it in memory. Because Multipart request bodies contain
        * files, they can cause memory overflows if cached in memory.
        */
        Pipe pipe = Pipe.open();

        // Pipeline streams must be used in a multi-threaded environment. Using one
        // thread for simultaneous reads and writes can lead to deadlocks.
        new Thread(() -> {
            try (OutputStream outputStream = Channels.newOutputStream(pipe.sink())) {
                // Write the encoded data to the pipeline.
                httpEntity.writeTo(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(new URI("http://localhost/upload"))
                // The Content-Type header is important, don't forget to set it.
                .header("Content-Type", httpEntity.getContentType().getValue())
                // Reads data from a pipeline stream.
                .POST(BodyPublishers.ofInputStream(() -> Channels.newInputStream(pipe.source()))).build();

        HttpResponse<String> responseBody = httpClient.send(request, BodyHandlers.ofString(StandardCharsets.UTF_8));

        System.out.println(responseBody.body());
    }
}
