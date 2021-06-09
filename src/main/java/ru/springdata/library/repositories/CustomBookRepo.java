package ru.springdata.library.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import ru.springdata.library.domain.Book;

import java.util.List;

@Repository
public interface CustomBookRepo {
    List<Book> findAll();
}
