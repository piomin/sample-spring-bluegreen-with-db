package pl.piomin.samples.spring.bluegreen.caller.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/caller")
public class CallerController {

    private RestTemplate restTemplate;

    public CallerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/call")
    public String call() {
        ResponseEntity<String> response = restTemplate
                .getForEntity("http://person:8080/persons/1", String.class);
        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        else
            return "Error: HTTP " + response.getStatusCodeValue();
    }
}
