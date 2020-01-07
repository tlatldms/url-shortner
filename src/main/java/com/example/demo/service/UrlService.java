package com.example.demo.service;

import com.example.demo.domain.Url;
import com.example.demo.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UrlService {
    private UrlRepository repository;
    /*
    public Url findUrlByOrigin(String origin) {
        return repository.findOneByOrigin(origin);
    }
    */
    public Url findUrlByShortened(String shortened) {
        return repository.findOneByShortened(shortened);
    }

    public void insertUrl(Url url) {
        url.setId(String.valueOf(url.hashCode()));
        repository.save(url);
    }

    public List<Url> findAll() {
        return repository.findAll();
    }
}
