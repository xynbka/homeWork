package ru.springdata.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springdata.library.domain.Book;
import ru.springdata.library.domain.Comment;
import ru.springdata.library.repositories.BookRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Transactional
    public Book findBookById(Long bookId){
        return bookRepo.findById(bookId).orElse(new Book());
    }

    @Transactional
    public List<String> findComments(Long bookId) {
        Optional<Book> bookRepoById = bookRepo.findById(bookId);
        List<Comment> comments = bookRepoById.map(Book::getComments).orElse(Collections.emptyList());
        if (comments.isEmpty()) return Collections.EMPTY_LIST;
        else                    return comments.stream().map(comment -> comment.getBookComment()).collect(Collectors.toList());
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}