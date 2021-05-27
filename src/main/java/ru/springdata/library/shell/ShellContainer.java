package ru.springdata.library.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.springdata.library.controller.LibraryController;

@ShellComponent
@AllArgsConstructor
public class ShellContainer {

    private final LibraryController libraryController;

    @ShellMethod(key = "lib", value = "lib")
    public void showAllLibrary() {
        libraryController.printAllBooks();
    }

    @ShellMethod(key = "cmt", value = "Show book comments by id")
    public void showComments(Long id) {
        libraryController.printComment(id);
    }


    @ShellMethod(key = "del", value = "Delete Book by name")
    public void deleteBook(@ShellOption({"bookName"}) String name) {
        libraryController.deleteBook(name);
    }

}
