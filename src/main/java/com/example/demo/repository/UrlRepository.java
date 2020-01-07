package com.example.demo.repository;

import com.example.demo.domain.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
    Url findOneByOrigin(String origin);
    Url findOneByShortened(String shortened);
}
