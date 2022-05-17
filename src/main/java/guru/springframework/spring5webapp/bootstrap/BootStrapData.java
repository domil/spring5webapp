package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a = new Author("domil","garg");
        Book b = new Book("alchemist","asdc123");
        a.getBooks().add(b);
        b.getAuthors().add(a);

        Publisher p = new Publisher("h","h","h","h","h");
        publisherRepository.save(p);
        p.getBooks().add(b);
        b.setPublisher(p);

        authorRepository.save(a);
        bookRepository.save(b);
        publisherRepository.save(p);

        System.out.print("authorRepo count:: " + authorRepository.count() + publisherRepository.count());
        System.out.println("publisher_books " + p.getBooks().size() + p.getName());
    }
}
