package com.guli.springbackend.spring_6_webapp.services;

import com.guli.springbackend.spring_6_webapp.domain.Book;


public interface BookService {

    Iterable<Book> findAll();

}
