package com.guli.springbackend.spring_6_webapp.services;

import com.guli.springbackend.spring_6_webapp.domain.Book;
import com.guli.springbackend.spring_6_webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
