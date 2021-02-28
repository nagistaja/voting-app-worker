package com.bitweb.votingapp.worker;

import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    /**
     * GsonJsonParser
     * @return
     */
    @Bean
    public GsonJsonParser gsonJsonParser() {
        return new GsonJsonParser();
    }

    /**
     * Gson
     * @return
     */
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
