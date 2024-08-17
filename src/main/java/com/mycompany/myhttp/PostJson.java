/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myhttp;

import java.io.BufferedReader;
import static java.lang.System.out;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author 
 */
public class PostJson {
    
    public static void main(String[] args) {

        try {
            /*
            {
                "animal": "dog",
                "name": "biff"
            }
             */
            String content = "{ \"animal\": \"dog\", \"name\": \"biff\" }";
            String path = "http://httpbin.org/post";
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setDoOutput(true);
            
            DataOutputStream dout = new DataOutputStream( connection.getOutputStream() );
            dout.writeBytes(content);
            dout.flush();
            dout.close();
            
            int responseCode = connection.getResponseCode();
            out.println("Code: " + responseCode);
            if (responseCode != HttpURLConnection.HTTP_OK) {
                out.println("Got an unexpected response code");
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
            }
            in.close();            

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        
        
    }

}
