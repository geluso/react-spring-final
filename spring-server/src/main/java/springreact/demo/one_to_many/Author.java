package springreact.demo.one_to_many;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="AUTHOR")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String name;

    // "author" here refers to the `.author` property inside the Book class.
    // Spring will look at the @JoinColumn annotation on the Book class to see
    // what SQL column ultimately relates these two.
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    public Set<Book> books;

    public String toString() {
        return this.name;
    }

    public String toStringWithBooks() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);

        builder.append("[");
        for (Book book : this.books) {
            builder.append(book.title + ", ");
        }
        builder.append("]");
        return builder.toString();
    }
}