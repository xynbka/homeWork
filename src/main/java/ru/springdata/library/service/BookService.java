package ru.springdata.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.springdata.library.domain.Book;
import ru.springdata.library.domain.Comment;
import ru.springdata.library.repositories.BookRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    @Transactional(readOnly = true)
    public Book findBookById(Long bookId){
        return bookRepo.findById(bookId).orElse(new Book());
    }

    @Transactional(readOnly = true)
    public List<String> findComments(Long bookId) {
        Optional<Book> bookRepoById = bookRepo.findById(bookId);
        List<Comment> comments = bookRepoById.map(Book::getComments).orElse(Collections.emptyList());
        if (comments.isEmpty()) return Collections.EMPTY_LIST;
        else                    return comments.stream().map(comment -> comment.getBookComment()).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        List<Book> all = bookRepo.findAll();
        return all;
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ
    )
    public boolean bookExist(String name) {
        return bookRepo.findByName(name).isPresent();
    }

    @Transactional
    public boolean deleteBook(String bookName) {
        if(bookRepo.findByName(bookName).isPresent()) {
            Optional<Book> book = bookRepo.findByName(bookName);
            bookRepo.delete(book.get());
            return true;
        }
        else return false;
    }

    @Transactional
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }



}