package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping("/api/index")
    public String index() throws Exception {
        return "Hello.... this is ";
    }
}
