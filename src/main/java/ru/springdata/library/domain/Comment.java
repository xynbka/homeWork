package ru.springdata.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment  implements Serializable{

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "comment")
    private String bookComment;

    @Getter
    @Setter
    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    private Book book;
}
