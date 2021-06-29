package ru.springdata.library.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = "authorBooks")
@ToString(exclude = "authorBooks")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "author_name")
    private String name;

//    @Getter
//    @Setter
//    @ManyToMany
//    @JoinTable( name = "book_author",
//            joinColumns = {@JoinColumn(name = "author_id")},
//            inverseJoinColumns = {@JoinColumn(name = "book_id")})
//    private List<Book> authorBooks;
}
