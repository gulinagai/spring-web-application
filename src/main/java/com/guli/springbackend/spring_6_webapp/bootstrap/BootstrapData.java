package com.guli.springbackend.spring_6_webapp.bootstrap;

import com.guli.springbackend.spring_6_webapp.domain.Author;
import com.guli.springbackend.spring_6_webapp.domain.Book;
import com.guli.springbackend.spring_6_webapp.domain.Publisher;
import com.guli.springbackend.spring_6_webapp.repositories.AuthorRepository;
import com.guli.springbackend.spring_6_webapp.repositories.BookRepository;
import com.guli.springbackend.spring_6_webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Publisher addison = new Publisher();
        addison.setPublisherName("Addison-Wesley");
        addison.setAddress("1900 E Lake Ave");
        addison.setCity("Glenview");
        addison.setState("Illinois");
        addison.setZip("60025");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher addisonSaved = publisherRepository.save(addison);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("547585");

        Publisher wiley = new Publisher();
        wiley.setPublisherName("Wiley");
        wiley.setAddress("111 River Street");
        wiley.setCity("Hoboken");
        wiley.setState("New Jersey");
        wiley.setZip("07030-5774");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        Publisher wileySaved = publisherRepository.save(wiley);

        ericSaved.getBooks().add(dddSaved);
        dddSaved.getAuthors().add(ericSaved);
        rodSaved.getBooks().add(noEJBSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        dddSaved.setPublisher(addisonSaved);
        noEJBSaved.setPublisher(wileySaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
