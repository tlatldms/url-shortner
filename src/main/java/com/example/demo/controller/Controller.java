package com.example.demo.controller;


import com.example.demo.domain.Url;
import com.example.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@CrossOrigin
public class Controller {
    @Autowired
    private UrlService service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model) throws Exception {
        List<Url> urls = service.findAll();
        model.addAttribute("data", urls);
        return "index";
    }

}
