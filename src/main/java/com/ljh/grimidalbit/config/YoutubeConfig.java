package com.ljh.grimidalbit.config;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class YoutubeConfig {
    private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private final JsonFactory JSON_FACTORY = new JacksonFactory();

    @Bean
    public YouTube youTube(){
        return new YouTube(HTTP_TRANSPORT,JSON_FACTORY,new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {
            }
        });
    }
}
