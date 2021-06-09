package ru.springdata.library.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.springdata.library.domain.Book;
import ru.springdata.library.service.BookService;

import java.util.List;

@Controller
@AllArgsConstructor
public class LibraryController {

    private final BookService bookService;

    public void printComment(Long id){
        List<String> comments = bookService.findComments(id);
        System.out.println("Книга: " + bookService.findBookById(id).getName() + "\nКомментарии: ");
        comments.stream().forEach(comment -> System.out.println(comment));
    }

    public void printAllBooks(){
        List<Book> books = bookService.getAllBooks();

        for (Book book : books) {
            System.out.println(book.getAuthor());
            System.out.println(book.getComments().toString());
        }
    }

    public void deleteBook(String name){
        if (bookService.deleteBook(name)) System.out.println("Книга " + name + " успешно удалена!");
        else System.out.println("Книга " + name + " отсутствует в библиотеке!");
    }
}
