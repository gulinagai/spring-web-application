package com.guli.springbackend.spring_6_webapp.services;

import com.guli.springbackend.spring_6_webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
