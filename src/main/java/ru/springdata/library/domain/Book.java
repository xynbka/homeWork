package ru.springdata.library.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@EqualsAndHashCode(exclude = "author")
@ToString(exclude = "author")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_name")
    private String name;

    @ManyToMany(targetEntity = Author.class ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "book_author",
                joinColumns = {@JoinColumn(name = "book_id")},
                inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> author;

    @ManyToOne(targetEntity = Genre.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genres;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private List<Comment> comments;
}
