package ru.springdata.library.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import ru.springdata.library.domain.Author;
import ru.springdata.library.domain.Book;
import ru.springdata.library.domain.Genre;
import ru.springdata.library.repositories.AuthorRepo;
import ru.springdata.library.repositories.GenreRepo;
import ru.springdata.library.service.BookService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class LibraryController {

    private final BookService bookService;
    private final AuthorRepo authorRepo;
    private final GenreRepo genreRepo;

    public void printComment(Long id){
        List<String> comments = bookService.findComments(id);
        System.out.println("Книга: " + bookService.findBookById(id).getName() + "\nКомментарии: ");
        comments.stream().forEach(comment -> System.out.println(comment));
    }

    public void printAllBooks(){
        List<Book> books = bookService.getAllBooks();

        for (Book book : books) {
            System.out.println("_____________________________________");
            System.out.println("Название: \n" + book.getName());
            System.out.println("Авторы:");
            book.getAuthor().stream().forEach(author -> System.out.println(author.getName()));
            System.out.println("Комментарии:");
            book.getComments().stream().forEach(comment -> System.out.println(comment.getBookComment()));
            System.out.println("Жанр:");
            System.out.println(book.getGenre().getName());
        }
        System.out.println("_____________________________________");
    }

    public void deleteBook(String name){
        if (bookService.deleteBook(name)) System.out.println("Книга " + name + " успешно удалена!");
        else System.out.println("Книга " + name + " отсутствует в библиотеке!");
    }

    @Transactional
    public void addNewBook(String name, String author, String genre){
        if(bookService.bookExist(name)) {
            System.out.println("Книга существует!");
            return;
        }

        Optional<Author> authors = authorRepo.findByName(author);
        if(!authors.isPresent()) {
            System.out.println("Автора не существует!");
            return;
        }
        List<Author> authorList = Collections.singletonList(authors.get());

        Optional<Genre> genres = genreRepo.findByName(genre);
        if(!authors.isPresent()) {
            System.out.println("Жанра не существует!");
            return;
        }

        Book book = new Book();
        book.setName(name);
        book.setAuthor(authorList);
        book.setGenre(genres.get());
        bookService.addBook(book);
    }
}
