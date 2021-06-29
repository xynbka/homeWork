package ru.springdata.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springdata.library.domain.Book;
import ru.springdata.library.domain.Comment;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
