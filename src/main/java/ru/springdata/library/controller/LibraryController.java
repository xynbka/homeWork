package ru.springdata.library.controller;

import org.springframework.stereotype.Controller;
import ru.springdata.library.domain.Book;
import ru.springdata.library.service.BookService;

import java.util.List;

@Controller
public class LibraryController {

    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    public void printComment(Long id){
        List<String> comments = bookService.findComments(id);
        System.out.println("Книга: " + bookService.findBookById(id).getName() + "\nКомментарии: ");
        comments.stream().forEach(comment -> System.out.println(comment));
    }

    public void printAllBooks(){
        bookService.getAllBooks().stream().forEach(book -> System.out.println(book.toString()));
    }
}
