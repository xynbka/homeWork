package ru.springdata.library.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "books")

@EqualsAndHashCode(exclude = "author")
@ToString(exclude = "author")

@NamedEntityGraph
        (   name = "bookGraphAll",
            attributeNodes = {
                @NamedAttributeNode("comments"),
                @NamedAttributeNode("genre")
        } )

public class Book  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "book_name")
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToMany(targetEntity = Author.class, fetch = FetchType.LAZY)
    @JoinTable( name = "book_author",
                joinColumns = {@JoinColumn(name = "book_id")},
                inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> author = new ArrayList<>();

    @ManyToOne(targetEntity = Genre.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    @Getter
    @Setter
    private Genre genre;

    @Getter
    @Setter
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<Comment> comments = new ArrayList<>();
}
