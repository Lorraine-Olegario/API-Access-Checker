package com.lorraineolegario.apiaccesschecker.Service;

import org.springframework.web.client.RestTemplate;

public class APIService {

    private static APIService instance;
    private final RestTemplate restTemplate;

    private APIService() {
        this.restTemplate = new RestTemplate();
    }

    public static synchronized APIService getInstance() {
        if (instance == null) {
            instance = new APIService();
        }
        return instance;
    }

    public boolean isApiAccessible(String url) {
        try {
            restTemplate.getForEntity(url, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
