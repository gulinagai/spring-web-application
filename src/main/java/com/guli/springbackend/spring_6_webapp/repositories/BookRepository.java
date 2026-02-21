package com.guli.springbackend.spring_6_webapp.repositories;

import com.guli.springbackend.spring_6_webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
