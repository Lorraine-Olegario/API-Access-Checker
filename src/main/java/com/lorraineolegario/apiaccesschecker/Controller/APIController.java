package com.lorraineolegario.apiaccesschecker.Controller;

import com.lorraineolegario.apiaccesschecker.Service.APIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class APIController {

    @GetMapping("/check-api")
    public String checkApi(@RequestParam String url) {
        APIService apiService = APIService.getInstance();
        boolean isAccessible = apiService.isApiAccessible(url);
        return isAccessible ? "API is accessible" : "API is not accessible";
    }
}
