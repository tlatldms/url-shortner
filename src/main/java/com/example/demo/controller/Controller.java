package com.example.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@CrossOrigin
public class Controller {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() throws Exception {
        return "index";
    }
}
