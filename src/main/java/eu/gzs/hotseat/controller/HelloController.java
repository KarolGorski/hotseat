package eu.gzs.hotseat.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello Spring World!";
    }
}
