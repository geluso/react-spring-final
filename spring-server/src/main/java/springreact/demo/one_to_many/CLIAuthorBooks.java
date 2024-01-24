package springreact.demo.one_to_many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CLIAuthorBooks implements CommandLineRunner {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookRepo bookRepo;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CLIAuthorBooks.class, args);
    }

    @Override
    public void run(String...args) throws Exception {
        // If we try to delete Authors before deleting Books
        // the server will complain that we're breaking a dependency
        // because there are books that still refer to Authors.
        // authorRepo.deleteAll();
        // bookRepo.deleteAll();

        Book fakeBook = new Book();
        fakeBook.title = "New Age Physics: Totally Free Energy";

        Author moron = new Author();
        moron.name = "Boomhauer";
        moron.id = -99; // fake id

        try {
            fakeBook.author = moron;
            bookRepo.save(fakeBook);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Optional<Author> maybeAuthor = authorRepo.findById(-1);

            boolean isEmpty = maybeAuthor.isEmpty();
            boolean isPresent = maybeAuthor.isPresent();
            System.out.println("isEmpty: " + isEmpty + ", isPresent: " + isPresent);

            Author notReallyAnAuthorHere = maybeAuthor.get();
            System.out.println(notReallyAnAuthorHere.name);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        // Start from a clean slate.
        bookRepo.deleteAll();
        authorRepo.deleteAll();

        Author hemingway = new Author();
        hemingway.name = "Ernest Hemingway";
        Author saved = authorRepo.save(hemingway);

        Book farewellToArms = new Book();
        farewellToArms.title = "A Farewell to Arms";

        // We don't have to refer to object ids
        // We can refer to entire Java Objects and the DB ORM will infer ids.
        // Then later on we can refer to `farewellToArms.author.name` in a nice manner too.
        // farewellToArms.author_id = saved.id;
        farewellToArms.author = saved;

        bookRepo.save(farewellToArms);

        Book theOldManAndTheSea = new Book();
        theOldManAndTheSea.title = "The Old Man and the Sea";
        theOldManAndTheSea.author = saved;
        bookRepo.save(theOldManAndTheSea);

        Iterable<Book> books = this.bookRepo.findAll();
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println();

        Author getAgain = authorRepo.findById(saved.id).get();
        System.out.println(getAgain.toStringWithBooks());

        // Clean up the database by deleting everything at the end.
        // This file is just letting us play with associations
        // We don't care about data persisting.
        bookRepo.deleteAll();
        authorRepo.deleteAll();
    }
}
