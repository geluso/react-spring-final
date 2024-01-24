package springreact.demo.one_to_many;

import jakarta.persistence.*;

@Entity
@Table(name="BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String title;

    @ManyToOne
    @JoinColumn(name="artist_id", nullable=false)
    public Author author;

    public String toString() {
        return this.title + " by " + this.author.name;
    }
}
