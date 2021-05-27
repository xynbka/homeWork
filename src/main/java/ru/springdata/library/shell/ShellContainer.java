package ru.springdata.library.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.springdata.library.controller.LibraryController;
import ru.springdata.library.service.BookService;

@ShellComponent
@AllArgsConstructor
public class ShellContainer {

    private final LibraryController libraryController;

    @ShellMethod(key = "lib", value = "lib")
    public void showAllLibrary() {
        libraryController.printAllBooks();
    }


    @ShellMethod(key = "cmt", value = "cmt")
    public void test() {
        libraryController.printComment(4l);
    }


}
