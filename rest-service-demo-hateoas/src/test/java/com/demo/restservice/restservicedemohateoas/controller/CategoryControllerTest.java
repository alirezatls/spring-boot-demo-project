package com.demo.restservice.restservicedemohateoas.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTest {

    @Test
    public void getAllCategory() {
        String url = "https://www.google.com";
        URI uri = URI.create(url);
        CloseableHttpClient http = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(uri);
        try {
            CloseableHttpResponse response = http.execute(get);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            System.out.println(stringBuffer.toString());
            assertEquals(200,response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void getCategory() {
    }

    @Test
    public void addNewCategory() {
    }
}