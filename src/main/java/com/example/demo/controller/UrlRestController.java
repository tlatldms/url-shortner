package com.example.demo.controller;

import com.example.demo.domain.Url;
import com.example.demo.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin
public class UrlRestController {
    private UrlService service;


    @RequestMapping(method = RequestMethod.GET, value="/api/getall")
    public List<Url> redirectToOrigin(HttpServletResponse httpServletResponse) throws IOException {
        List<Url> urls = service.findAll();
        return urls;
    }

    @RequestMapping(method = RequestMethod.GET, value="/{shortened}")
    public void redirectToOrigin(@PathVariable String shortened, HttpServletResponse httpServletResponse) throws IOException {
        Url url = service.findUrlByShortened(shortened);
        if (url != null) {
            System.out.println("urls searched by shortened: " + url.getOrigin());
            httpServletResponse.sendRedirect(url.getOrigin());
        }
    }

    public static String sha256(String msg)  {
        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(msg.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    @RequestMapping(method = RequestMethod.POST, value="/",
    consumes = "application/json")
    public String postUrl(Model model, @RequestBody Url url) {
        //System.out.println("origin: " + origin.getOrigin());

        String ori=url.getOrigin();
        String[] li = ori.split("localhost:8080/");

        //String origin = li[1];
        //System.out.println("result: "+ origin);
        url.setOrigin(ori);
        String shortUrl = sha256(ori).substring(0,8);
        url.setShortened(shortUrl);
        service.insertUrl(url);
        return "http://localhost:8080/" + shortUrl;
    }

}
